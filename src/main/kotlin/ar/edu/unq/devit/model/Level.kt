package ar.edu.unq.devit.model


import ar.edu.unq.devit.model.error.*
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

    fun tryAndMovePlayer(newPos: Position, lastKnownPosition: Position) {
        val player = elements.find { e -> e is Player } as Player
        val doorAtPlayerPos = elements.find { e -> e is Door && e.position == player.position } as? Door
        if (newPos != lastKnownPosition && doorAtPlayerPos != null && !doorAtPlayerPos.isOpen) throw ClosedDoorException(ModelMessages.CLOSED_DOOR)
        elements.removeIf { e -> e is Player }
        elements.add(Player(newPos, player.keys))
    }

    fun removeFinish() {
        elements.removeIf { e -> e is Finish }
    }

    fun doorAtPlayer() : Boolean {
        val player = elements.find { e -> e is Player } as Player
        return elements.find { e -> e is Door && e.position == player.position } as? Door != null
    }

    fun keyAtPlayer() : Boolean {
        val player = elements.find { e -> e is Player } as Player
        return elements.find { e -> e.position == player.position && e is Key } as? Key != null
    }

    fun openDoor() {
        val player = (elements.find { e -> e is Player } as Player)
        val doorAtPlayerPos = elements.find { e -> e is Door && e.position == player.position } as? Door ?: throw DoorNotFoundException(ModelMessages.DOOR_NOT_FOUND)
        if (doorAtPlayerPos.isOpen) throw DoorAlreadyOpenException(ModelMessages.DOOR_ALREADY_OPEN)
        val keys = player.keys
        if (keys.size > 0) {
            keys.removeAt(0)
            val newDoor = Door(player.position, true)
            elements.removeIf { e -> e is Player || (e.position == player.position && e is Door) }
            elements.addAll(listOf(newDoor, Player(player.position!!, keys)))
        } else
            throw PlayerKeyNotFoundException(ModelMessages.PLAYER_KEY_NOT_FOUND)
    }

    fun collectKey() {
        val player = (elements.find { e -> e is Player } as Player)
        val keys = player.keys
        val keyInPos = elements.find { e -> e.position == player.position && e is Key } as? Key ?: throw KeyNotFoundException(ModelMessages.KEY_NOT_FOUND)
        keys.add(keyInPos)
        elements.removeIf { e -> e is Player || ( e.position == player.position && e is Key) }
        elements.add(Player(player.position!!, keys))
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