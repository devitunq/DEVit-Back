package ar.edu.unq.devit.model.error

class OutOfPathException(message: String) : Exception(message)

class InvalidSignIn(message:String) : Exception(message)

class PlayerKeyNotFoundException(message: String) : Exception(message)

class DoorNotFoundException(message: String) : Exception(message)

class DoorAlreadyOpenException(message: String) : Exception(message)

class KeyNotFoundException(message: String) : Exception(message)

class ClosedDoorException(message: String) : Exception(message)
