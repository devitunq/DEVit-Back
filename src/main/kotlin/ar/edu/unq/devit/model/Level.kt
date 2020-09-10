package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonProperty

@BsonDiscriminator
class Level {

    @BsonProperty(value = "id")
    val id: String? = null
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
        this.difficulty = difficulty
        this.name = name
        this.elements = elements
        this.description = description
    }



    fun playerPosition(): Position =  elements.find { e -> e is Player }?.position!!

    fun tilesPositions(): MutableList<Position> = elements.filterIsInstance<PathTile>().map { e -> e.position!! }.toMutableList()

    fun finishPosition(): Position = elements.find { e -> e is Finish }?.position!!

}