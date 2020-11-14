package ar.edu.unq.devit.model.request

data class RegisterRequest(val userName: String, val password: String, val passwordConfirm : String, val nick: String)