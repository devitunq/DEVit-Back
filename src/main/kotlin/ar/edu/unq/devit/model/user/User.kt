package ar.edu.unq.devit.model.user

import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.ModelMessages
import org.bson.codecs.pojo.annotations.BsonIgnore
import org.bson.codecs.pojo.annotations.BsonProperty

class User{

    @BsonProperty(value = "userName")
    var userName: String? = null
    @BsonProperty
    var password: String? = null
    @BsonProperty
    var nick : String? = null
    @BsonProperty
    var permission: UserPermission? = null
    @BsonProperty
    var levelsIdPassed: MutableList<String>? = null

    @BsonIgnore
    var token : String? = null

    constructor()

    constructor(userName: String, password: String, nick: String){
        this.userName = userName
        this.password = password
        this.nick = nick
        this.permission = UserPermission.FullAccess
        this.levelsIdPassed = listOf<String>().toMutableList()
    }

    fun changePassword(newPassword: String){
        this.password = newPassword
    }

    fun checkPassword (password: String) : Boolean {
        if (this.password != password){
            throw InvalidSignIn(ModelMessages.INVALID_SIGN_IN)
        }
        return true
    }

    fun saveLevelSucces(levelId: String){
        levelsIdPassed!!.add(levelId)
    }

}