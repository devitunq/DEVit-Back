package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.*

class MediumLevelOne {

    val levelData = GenericLevelData

    // Level name
    var level1name = "Level One"

    // Level description
    var level1Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible, utilizando repeticiones e condiciones"

    // Finish element
    var finish = Finish(Position(5, 1))

    // Player element
    var player = Player(Position(6, 6))

    // Door element
    var keyTwo = Key(Position(2, 0))

    var door = Door(Position(1, 1))
    var doorTwo = Door(Position(3, 1))

    var conceal = Conceal(Position(0,2))
    var concealTwo = Conceal(Position(1,6))

    var tile01 = PathTile(Position(0, 1))
    var tile02 = PathTile(Position(0, 2))
    var tile03 = PathTile(Position(0, 3))
    var tile04 = PathTile(Position(0, 4))
    var tile11 = PathTile(Position(1, 1))
    var tile14 = PathTile(Position(1, 4))
    var tile15 = PathTile(Position(1, 5))
    var tile16 = PathTile(Position(1, 6))
    var tile20 = PathTile(Position(2, 0))
    var tile21 = PathTile(Position(2, 1))
    var tile26 = PathTile(Position(2, 6))
    var tile31 = PathTile(Position(3, 1))
    var tile36 = PathTile(Position(3, 6))
    var tile41 = PathTile(Position(4, 1))
    var tile46 = PathTile(Position(4, 6))
    var tile51 = PathTile(Position(5, 1))
    var tile56 = PathTile(Position(5, 6))
    var tile66 = PathTile(Position(6, 6))


    // Paths element
    // Elements list
    fun level1Elements(): MutableList<LevelElement> {
        concealTwo.hiddenElement = Key(Position(1, 6))
        player.lookingTo = LookingTo.LEFT
        return listOf(
                finish, player, keyTwo, door, doorTwo, tile16, tile26, tile36, tile46, tile56, tile03,
                tile21, tile31, tile41, tile51, tile01, tile11, tile14, tile15, tile20, tile66, tile02,
                tile04, conceal, concealTwo
        ).toMutableList()
    }
    // Level
    private var levelOne =
            Level(
                    levelData.medium,
                    level1name,
                    level1Elements(),
                    level1Desc,
                    19)

    fun createMediumLevelOne(){
        levelOne.callProceduresEnabled = false
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelOne)
        levelData.levelDAO.commit()
    }
}
