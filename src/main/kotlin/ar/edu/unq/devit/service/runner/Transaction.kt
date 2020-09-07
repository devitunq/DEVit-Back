package ar.edu.unq.devit.service.runner

interface Transaction {
    fun start()
    fun commit()
    fun rollback()
}