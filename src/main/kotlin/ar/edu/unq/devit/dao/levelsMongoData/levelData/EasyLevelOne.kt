package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*

class EasyLevelOne {

    val levelData = GenericLevelData

    // Level name
    var level1name = "Level One"

    // Level description
    var level1Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible"

    // Finish element
    var finish = Finish(Position(6,0))

    // Player element
    var player = Player(Position(1,4))

    // Paths element
    var tile13 = PathTile(Position(1,3))
    var tile12 = PathTile(Position(1,2))
    var tile14 = PathTile(Position(1,4))
    var tile22 = PathTile(Position(2,2))
    var tile32 = PathTile(Position(3,2))
    var tile42 = PathTile(Position(4,2))
    var tile41 = PathTile(Position(4,1))
    var tile51 = PathTile(Position(5,1))
    var tile61 = PathTile(Position(6,1))
    var tile60 = PathTile(Position(6,0))



    // Elements list
    var level1Elements =
            listOf(
                    finish,player,tile12,tile13,tile14,tile22,tile32,tile41,tile42,tile51,tile60,tile61
            ).toMutableList()

    // Level
    private var levelOne = Level(levelData.easy,level1name,level1Elements,level1Desc,9)

    fun createEasyLevelOne(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelOne)
        levelData.levelDAO.commit()
    }

    fun deleteDefaultLevels(){
        levelData.levelDAO.deleteAll()
    }

}