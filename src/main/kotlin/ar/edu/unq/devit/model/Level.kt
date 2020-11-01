package ar.edu.unq.devit.model


import ar.edu.unq.devit.model.error.ModelMessages
import ar.edu.unq.devit.model.error.PlayerKeyNotFoundException
import org.bson.codecs.pojo.annotations.BsonProperty


class Level {

    @BsonProperty(value = "levelId")
    var levelId: String? = null
    @BsonProperty
    var difficulty: Difficulty? = null
    @BsonProperty
    var name : String? = null
    @BsonProperty
    var elements: MutableList<LevelElement> = mutableListOf()
    @BsonProperty
    var description: String? = null
    @BsonProperty
    var bestNumberMovesToWin: Int? = null
    @BsonProperty
    var playerPosition: Position? = null
    @BsonProperty
    var likes: Int = 0
    @BsonProperty
    var dislikes: Int = 0
    @BsonProperty
    var scoreFromAndLevel: MutableSet<String> = mutableSetOf()

    constructor()

    constructor(difficulty: Difficulty,name: String, elements: MutableList<LevelElement>,
                description: String, bestNumberMovesToWin: Int){
        this.levelId = "${difficulty}_${name}"
        this.difficulty = difficulty
        this.name = name
        this.elements = elements
        this.description = description
        this.bestNumberMovesToWin = bestNumberMovesToWin
        this.playerPosition = elements.find { e -> e is Player }?.position!!
    }


    fun tilesPositions(): MutableList<Position> = elements.filterIsInstance<PathTile>().map { e -> e.position!! }.toMutableList()

    fun finishPosition(): Position = elements.find { e -> e is Finish }?.position!!

    fun getLevelDoors(): List<Door> = elements.filterIsInstance<Door>()

    fun changePlayerPositionToAndCollect(pos: Position) {
        var keys = (elements.find { e -> e is Player } as Player).keys
        val keyInPos = elements.find { e -> e.position == pos && e is Key } as? Key
        if (keyInPos !== null)
            keys.add(keyInPos)
        elements.removeIf { e -> e is Player || ( e.position == pos && e is Key) }
        elements.add(Player(pos, keys))
    }

    fun removeFinish() {
        elements.removeIf { e -> e is Finish }
    }

    fun openDoor() {
        var player = (elements.find { e -> e is Player } as Player)
        var keys = player.keys
        if (keys.size > 0) {
            keys.removeAt(0)
            val newDoor = Door(player.position, true)
            elements.removeIf { e -> e is Player || (e.position == player.position && e is Door) }
            elements.addAll(listOf(newDoor, Player(player.position!!, keys)))
        } else
            throw PlayerKeyNotFoundException(ModelMessages.PLAYER_KEY_NOT_FOUND)
    }

    fun addCalificator(userName: String, levelId: String){
        scoreFromAndLevel.add(userName + "_" + levelId)
    }

    fun addScore(score: String){
        if(score == "Like"){ this.likes++ }
        else{ this.dislikes++ }
    }

    fun isUserCalificator(userName: String, levelId: String): Boolean{
        println(userName)
        println(levelId)
        return scoreFromAndLevel.contains(userName + "_" + levelId)
    }
}