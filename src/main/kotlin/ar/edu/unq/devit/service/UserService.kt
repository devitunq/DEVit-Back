package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.dao.UserMongoDAO
import ar.edu.unq.devit.model.request.RegisterRequest
import ar.edu.unq.devit.model.StorableDataLevel
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.PasswordsDontMatch
import ar.edu.unq.devit.model.error.UserAlreadyExists
import ar.edu.unq.devit.model.user.User
import ar.edu.unq.devit.security.getJWTToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService {

    @Autowired
    lateinit var userDAO : UserMongoDAO

    @Autowired
    lateinit var levelMongoDAO: LevelMongoDAO

    @Throws(InvalidSignIn::class)
    fun loginUser(user: User) : User {
        var usr = userDAO.getUser(user.userName!!, user.password!!)
        usr.token = getJWTToken(user.userName!!, 86400000)
        usr.password = null
        return usr
    }

    @Throws(PasswordsDontMatch::class, UserAlreadyExists::class)
    fun registerUser(registerRequest: RegisterRequest) : User {
        if (registerRequest.password != registerRequest.passwordConfirm) throw PasswordsDontMatch("Las contraseñas no coinciden.")
        var usr = User(registerRequest.userName, registerRequest.password, registerRequest.nick)
        userDAO.registerUser(usr)
        usr.token = getJWTToken(usr.userName!!, 86400000)
        usr.password = null
        return usr
    }

    fun saveLevelSucces(userName: String, levelID: String, stars: Int){
        var userToUpdate = userDAO.getBy("userName", userName)
        userToUpdate!!.saveLevelSucces(StorableDataLevel(userName, levelID, stars))
        userDAO.updateBy(userToUpdate, "userName", userName)
    }

    fun getUserLevelsCompleted(userName: String): MutableList<StorableDataLevel>{
        var user = userDAO.getBy("userName", userName)
        return user!!.levelsPassed!!
    }

    fun getUserCompletionProgress(userName: String): Long {
        val user = userDAO.getBy("userName", userName)
        val totalLevelCount = levelMongoDAO.numberOfLevelsPublicsInCollection()
        return ((user!!.levelsPassed!!.size * 100) / totalLevelCount).toLong()
    }
}