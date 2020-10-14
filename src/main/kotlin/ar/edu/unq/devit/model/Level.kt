package ar.edu.unq.devit.model


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
}