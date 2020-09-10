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

    constructor()

    constructor(difficulty: Difficulty,name: String, elements: MutableList<LevelElement>, description: String){
        this.levelId = "${difficulty}_${name}"
        this.difficulty = difficulty
        this.name = name
        this.elements = elements
        this.description = description
    }


    fun playerPosition(): Position =  elements.find { e -> e is Player }?.position!!

    fun tilesPositions(): MutableList<Position> = elements.filterIsInstance<PathTile>().map { e -> e.position!! }.toMutableList()

    fun finishPosition(): Position = elements.find { e -> e is Finish }?.position!!

}