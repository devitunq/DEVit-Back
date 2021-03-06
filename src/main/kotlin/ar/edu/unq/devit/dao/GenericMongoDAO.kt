package ar.edu.unq.devit.dao

import ar.edu.unq.devit.service.runner.MongoTransaction
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.eq
import org.bson.conversions.Bson

open class GenericMongoDAO<T>(entityType: Class<T>) {

    private var connection: MongoTransaction = MongoTransaction()
    private var collection: MongoCollection<T>

    init {
        collection = connection.getCollection(entityType.simpleName, entityType)
    }

    fun deleteAll() {
        if(connection.session != null) {
            collection.drop(connection.session!!)
        }else{
            collection.drop()
        }
    }

    fun save(anObject: T) {
        save(listOf(anObject))
    }

    fun update(anObject: T, id: String?) {
        if(connection.session != null) {
            collection.replaceOne(connection.session!!, eq("id", id), anObject)
        }else{
            collection.replaceOne(eq("id", id), anObject)
        }
    }

    // Just admit string value.
    fun updateBy(anObject: T, property:String, value: String?) {
        if(connection.session != null) {
            collection.replaceOne(connection.session!!, eq(property, value), anObject)
        }else{
            collection.replaceOne(eq(property, value), anObject)
        }
    }

    fun save(objects: List<T>) {
        if(connection.session != null) {
            collection.insertMany(connection.session!!, objects)
        }else{
            collection.insertMany(objects)
        }
    }

    operator fun get(id: String?): T? {
        return getBy("id", id)
    }

    fun getBy(property:String, value: String?): T? {
        if(connection.session != null) {
            return collection.find(connection.session!!, eq(property, value)).first()
        }
        return collection.find(eq(property, value)).first()
    }

    fun <E> findEq(field:String, value:E ): List<T> {
        return find(eq(field, value))
    }

    fun findAll(): List<T> {
        if(connection.session != null) {
            return collection.find(connection.session!!).into(mutableListOf())
        }
        return collection.find().into(mutableListOf())
    }

    fun find(filter: Bson): List<T> {
        if(connection.session != null) {
            return collection.find(connection.session!!, filter).into(mutableListOf())
        }
        return collection.find(filter).into(mutableListOf())
    }

    fun numberOfDocuments() : Long {
        return collection.countDocuments()
    }

    fun <T> aggregate(pipeline:List<Bson> , resultClass:Class<T>): List<T> {
        if(connection.session != null) {
            return collection.aggregate(connection.session!!, pipeline, resultClass).into(ArrayList())
        }
        return collection.aggregate(pipeline, resultClass).into(ArrayList())
    }

    fun startTransaction(){
        connection.start()
    }

    fun commit(){
        connection.commit()
    }

    fun rollack(){
        connection.rollback()
    }



}