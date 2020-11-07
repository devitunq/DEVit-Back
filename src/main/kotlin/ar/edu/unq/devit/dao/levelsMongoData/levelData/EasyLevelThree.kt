package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*

class EasyLevelThree {

    val levelData = GenericLevelData

    // Level name
    var level3name = "Level Three"

    // Level description
    var level3Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible"

    // Finish element
    var finish = Finish(Position(6,0))

    // Player element
    var player = Player(Position(2,6))

    // Door element
    var key = Key(Position(0,6))

    var door = Door(Position(4,1))

    var tile06 = PathTile(Position(0,6))
    var tile16 = PathTile(Position(1,6))
    var tile26 = PathTile(Position(2,6))
    var tile36 = PathTile(Position(3,6))
    var tile46 = PathTile(Position(4,6))
    var tile56 = PathTile(Position(5,6))
    var tile05 = PathTile(Position(0,5))
    var tile25 = PathTile(Position(2,5))
    var tile55 = PathTile(Position(5,5))
    var tile04 = PathTile(Position(0,4))
    var tile24 = PathTile(Position(2,4))
    var tile34 = PathTile(Position(3,4))
    var tile64 = PathTile(Position(6,4))
    var tile03 = PathTile(Position(0,3))
    var tile33 = PathTile(Position(3,3))
    var tile63 = PathTile(Position(6,3))
    var tile12 = PathTile(Position(1,2))
    var tile32 = PathTile(Position(3,2))
    var tile21 = PathTile(Position(2,1))
    var tile31 = PathTile(Position(3,1))
    var tile41 = PathTile(Position(4,1))
    var tile51 = PathTile(Position(5,1))
    var tile50 = PathTile(Position(5,0))
    var tile60 = PathTile(Position(6,0))

    // Paths element
    // Elements list
    var level3Elements =
            listOf(
                    finish,player,key,door,tile06,tile16,tile26,tile36,tile46,tile56,tile05,
                    tile25,tile55,tile04,tile24,tile34,tile64,tile03,tile33,tile63,tile12,
                    tile32,tile21,tile31,tile41,tile51,tile50,tile60
            ).toMutableList()

    // Level
    private var levelThree =
            Level(
                    levelData.easy,
                    level3name,
                    level3Elements,
                    level3Desc,
                    16)

    fun createEasyLevelThree(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelThree)
        levelData.levelDAO.commit()
    }
}
