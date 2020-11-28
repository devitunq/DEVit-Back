package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.*

class EasyLevelFour {

    val levelData = GenericLevelData

    // Level name
    var level4name = "Level Four"

    // Level description
    var level4Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible"

    // Finish element
    var finish = Finish(Position(3, 3))

    // Player element
    var player = Player(Position(4, 6))

    // Door element
    var keyOne = Key(Position(2, 6))
    var keyTwo = Key(Position(0, 1))
    var keyThree = Key(Position(0, 2))
    var keyFour = Key(Position(4, 0))

    var doorOne = Door(Position(1, 3))
    var doorFour = Door(Position(4, 3))
    var doorFive = Door(Position(5, 3))
    var doorSix = Door(Position(5, 2))

    var concealOne = Conceal(Position(6,4))

    var tile01 = PathTile(Position(0, 1))
    var tile02 = PathTile(Position(0, 2))
    var tile12 = PathTile(Position(1, 2))
    var tile13 = PathTile(Position(1, 3))
    var tile14 = PathTile(Position(1, 4))
    var tile15 = PathTile(Position(1, 5))
    var tile16 = PathTile(Position(1, 6))
    var tile26 = PathTile(Position(2, 6))
    var tile32 = PathTile(Position(3, 2))
    var tile33 = PathTile(Position(3, 3))
    var tile36 = PathTile(Position(3, 6))
    var tile40 = PathTile(Position(4, 0))
    var tile43 = PathTile(Position(4, 3))
    var tile46 = PathTile(Position(4, 6))
    var tile50 = PathTile(Position(5, 0))
    var tile51 = PathTile(Position(5, 1))
    var tile52 = PathTile(Position(5, 2))
    var tile53 = PathTile(Position(5, 3))
    var tile54 = PathTile(Position(5, 4))
    var tile55 = PathTile(Position(5, 5))
    var tile56 = PathTile(Position(5, 6))
    var tile64 = PathTile(Position(6, 4))

    // Paths element
    // Elements list
    var level4Elements =
            listOf(
                    finish,player,keyOne,keyTwo,keyThree,keyFour,doorOne,doorFour,doorFive,doorSix,
                    tile01, tile02,tile12,tile13,tile14,tile15,tile16,tile26,tile32,tile33,tile36,tile40,tile43,
                    tile46,tile50,tile51,tile52,tile53,tile54,tile55,tile56,tile64,concealOne
            ).toMutableList()

    // Level
    private var levelFour =
            Level(
                    levelData.easy,
                    level4name,
                    level4Elements,
                    level4Desc,
                    30)

    fun createEasyLevelFour(){
        levelFour.ifEnabled = true
        levelFour.repeatEnabled = true
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelFour)
        levelData.levelDAO.commit()
    }
}
