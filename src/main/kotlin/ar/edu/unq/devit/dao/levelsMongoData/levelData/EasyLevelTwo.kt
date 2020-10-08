package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*

class EasyLevelTwo {

    val levelData = GenericLevelData


    // Level name
    var level2name = "Level Two"

    // Level description
    var level2Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible"

    // Finish element
    var finish = Finish(Position(6,0))

    // Player element
    var player = Player(Position(1,5))

    // Paths element
    var tile16 = PathTile(Position(1,6))
    var tile26 = PathTile(Position(2,6))
    var tile36 = PathTile(Position(3,6))
    var tile46 = PathTile(Position(4,6))
    var tile15 = PathTile(Position(1,5))
    var tile45 = PathTile(Position(4,5))
    var tile55 = PathTile(Position(5,5))
    var tile65 = PathTile(Position(6,5))
    var tile14 = PathTile(Position(1,4))
    var tile64 = PathTile(Position(6,4))
    var tile03 = PathTile(Position(0,3))
    var tile13 = PathTile(Position(1,3))
    var tile63 = PathTile(Position(6,3))
    var tile02 = PathTile(Position(0,2))
    var tile62 = PathTile(Position(6,2))
    var tile01 = PathTile(Position(0,1))
    var tile11 = PathTile(Position(1,1))
    var tile31 = PathTile(Position(3,1))
    var tile41 = PathTile(Position(4,1))
    var tile51 = PathTile(Position(5,1))
    var tile61 = PathTile(Position(6,1))
    var tile10 = PathTile(Position(1,0))
    var tile20 = PathTile(Position(2,0))
    var tile30 = PathTile(Position(3,0))
    var tile60 = PathTile(Position(6,0))

    // Elements list
    var level2Elements =
            listOf(
                    finish,player,tile16,tile26,tile36,tile46,tile15,tile45,tile55,tile65,tile14,
                    tile64,tile03,tile13,tile63,tile02,tile62,tile01,tile11,tile31,tile41,tile51,
                    tile61,tile10,tile20,tile30,tile60
            ).toMutableList()

    // Level
    private var levelTwo =
            Level(
                    levelData.easy,
                    level2name,
                    level2Elements,
                    level2Desc,
                    12)

    fun createEasyLevelTwo(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelTwo)
        levelData.levelDAO.commit()
    }
}
