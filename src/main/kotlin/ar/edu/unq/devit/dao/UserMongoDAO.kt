package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.ModelMessages
import ar.edu.unq.devit.model.error.PasswordsDontMatch
import ar.edu.unq.devit.model.error.UserAlreadyExists
import ar.edu.unq.devit.model.user.User
import com.mongodb.client.model.Filters
import org.springframework.stereotype.Repository

@Repository
class UserMongoDAO: GenericMongoDAO<User>(User::class.java){

    @Throws(UserAlreadyExists::class)
    fun registerUser(user:User) {
        if(getBy("userName", user.userName) != null) throw UserAlreadyExists("El usuario ya existe")
        save(user)
    }

    fun safeSave(user: User) {
        if(getBy("userName", user.userName) == null){ save(user) }
    }

    @Throws(InvalidSignIn::class)
    fun getUser(userName: String, password: String) : User {
            var user = this.getBy("userName", userName)
            if (user != null)
                user.checkPassword(password)
            else
                throw InvalidSignIn(ModelMessages.INVALID_SIGN_IN)
            return user
    }

}