package service.logging

interface Observer {
    fun update(message: String, status: Status)
}