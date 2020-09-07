package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonProperty

class Level {

    @BsonProperty(value = "id")
    val id: String? = null

    var difficulty: Difficulty? = null
    var name : String? = null
    var elements: MutableList<LevelElement> = mutableListOf() //Pensar si no separar los "tiles" de los elementos, estaría bien supongo. de momento es una lista de objetos ([Player, Key, Finish, Door, PathTile, PathTile, PathTile, PathTile, PathTile]))
    var description: String? = null

    constructor()

    fun playerPosition(): Position =  elements.find { e -> e is Player }?.position!!

    fun tilesPositions(): MutableList<Position> = elements.filterIsInstance<PathTile>().map { e -> e.position!! }.toMutableList()

    fun finishPosition(): Position = elements.find { e -> e is Finish }?.position!!

}