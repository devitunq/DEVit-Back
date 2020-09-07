package ar.edu.unq.devit.service.runner

object TransactionRunner {
    private var transaction:Transaction = MongoTransaction()

    fun <T> runTrx(bloque: ()->T): T {
        try{
            transaction.start()
            val result = bloque()
            transaction.commit()
            return result
        } catch (exception:Throwable){
            transaction.rollback()
            throw exception
        }
    }
}