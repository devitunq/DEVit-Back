package ar.edu.unq.devit.service.runner

import com.mongodb.*
import com.mongodb.client.*
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider


class MongoTransaction: Transaction{
    var client: MongoClient
    var dataBase: MongoDatabase
    var session:ClientSession? = null

    override fun start() {
        try {
            session = client.startSession()
            session?.startTransaction(TransactionOptions.builder().writeConcern(WriteConcern.MAJORITY).build())
        }catch (exception: MongoClientException){
            exception.printStackTrace()
        }
    }

    override fun commit() {
        session?.commitTransaction()
        closeSession()
    }

    override fun rollback() {
        session?.abortTransaction()
        closeSession()
    }

    private fun closeSession(){
        session?.close()
        session = null
    }

    fun <T> getCollection(name:String, entityType: Class<T> ): MongoCollection<T> {
        try{
            dataBase.createCollection(name)
        } catch (exception: MongoCommandException){
            println("Ya existe la coleccion $name")
        }
        return dataBase.getCollection(name, entityType)
    }

    init {
        val codecRegistry: CodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().register("ar.edu.unq.devit.model","ar.edu.unq.devit.model.user").build())
        )

        val uri = System.getenv().getOrDefault("MONGO_URI","mongodb+srv://devitmongo:devitmongo@cluster0.mvdfz.mongodb.net/devit_mongo?retryWrites=true&w=majority")
//        val uri = System.getenv().getOrDefault("MONGO_URI","mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false")

        val connectionString = ConnectionString(uri)
        val settings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .applyConnectionString(connectionString)
                .build()
        client = MongoClients.create(settings)
        dataBase = client.getDatabase("devit")
    }

}