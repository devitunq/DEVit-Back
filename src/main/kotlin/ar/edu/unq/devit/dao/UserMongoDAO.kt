package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.ModelMessages
import ar.edu.unq.devit.model.user.User

class UserMongoDAO: GenericMongoDAO<User>(User::class.java){

    fun safeSave(user: User) {
        if(getBy("userName", user.userName) == null){ save(user) }
    }

    fun getUser(userName: String, password: String) : User {
        try{
            var user = this.getBy("userName", userName)
            user!!.checkPassword(password)
            return user
        }catch (e: Exception){
            throw InvalidSignIn(ModelMessages.INVALID_SIGN_IN)
        }
    }

}