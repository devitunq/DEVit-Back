package ar.edu.unq.devit.model

class Level {

    var name : String? = null
    var elements: MutableList<LevelElement> = mutableListOf() //Pensar si no separar los "tiles" de los elementos, estaría bien supongo. de momento es una lista de objetos ([Player, Key, Finish, Door, PathTile, PathTile, PathTile, PathTile, PathTile]))
    var description: String? = null

    fun playerPosition(): Position =  elements.find { e -> e is Player }?.position!!

    fun tilesPositions(): MutableList<Position> = elements.filterIsInstance<PathTile>().map { e -> e.position!! }.toMutableList()

    fun finishPosition(): Position = elements.find { e -> e is Finish }?.position!!







}