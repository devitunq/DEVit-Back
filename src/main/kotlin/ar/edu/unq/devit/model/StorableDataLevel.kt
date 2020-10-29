package ar.edu.unq.devit.model

class StorableDataLevel{

    var userName:String? = null
    var levelID: String? = null
    var stars: Int? = null

    constructor()

    constructor(userName: String, levelID: String, stars: Int){
        this.userName = userName
        this.levelID = levelID
        this.stars = stars
    }

}
