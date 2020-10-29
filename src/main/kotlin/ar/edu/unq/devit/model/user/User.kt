package ar.edu.unq.devit.model.user

import ar.edu.unq.devit.model.StorableDataLevel
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
    var levelsPassed: MutableList<StorableDataLevel>? = null

    @BsonIgnore
    var token : String? = null

    constructor()

    constructor(userName: String, password: String, nick: String){
        this.userName = userName
        this.password = password
        this.nick = nick
        this.permission = UserPermission.FullAccess
        this.levelsPassed = listOf<StorableDataLevel>().toMutableList()
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

    fun saveLevelSucces(levelData: StorableDataLevel){
        if(isPreviousPassed(levelData.levelID!!)){
            updateIfBestResultFromLevel(levelData.levelID!!, levelData.stars!!)
        } else {
            levelsPassed!!.add(levelData)
        }
    }

    fun updateIfBestResultFromLevel(levelID: String, starsWon: Int){
        var betterLevels = levelsPassed!!.filter { dl -> dl.levelID == levelID && dl.stars!! > starsWon }
        if(betterLevels.isEmpty()){
            this.levelsPassed!!.find { dl -> dl.levelID == levelID }!!.stars = starsWon
        }
    }

    fun isPreviousPassed(levelID: String): Boolean{
        return levelsPassed!!.find { dl -> dl.levelID == levelID } != null
    }

}