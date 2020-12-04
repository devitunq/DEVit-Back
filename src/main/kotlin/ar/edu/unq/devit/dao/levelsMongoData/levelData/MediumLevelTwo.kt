package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.*

class MediumLevelTwo {

    val levelData = GenericLevelData

    // Level name
    var level2name = "Level Two"

    // Level description
    var level2Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible, utilizando repeticiones, condiciones y el tablero secundario"

    // Finish element
    var finish = Finish(Position(0, 0))

    // Player element
    var player = Player(Position(3, 6))

    var door = Door(Position(4, 1))
    var doorTwo = Door(Position(2, 2))
    var doorThree = Door(Position(0, 2))

    var conceal = Conceal(Position(4,6))
    var concealTwo = Conceal(Position(3,2))
    var concealThree = Conceal(Position(1,2))

    var tile00 = PathTile(Position(0, 0))
    var tile01 = PathTile(Position(0, 1))
    var tile02 = PathTile(Position(0, 2))
    var tile12 = PathTile(Position(1, 2))
    var tile22 = PathTile(Position(2, 2))
    var tile32 = PathTile(Position(3, 2))
    var tile36 = PathTile(Position(3, 6))
    var tile40 = PathTile(Position(4, 0))
    var tile41 = PathTile(Position(4, 1))
    var tile42 = PathTile(Position(4, 2))
    var tile46 = PathTile(Position(4, 6))
    var tile50 = PathTile(Position(5, 0))
    var tile55 = PathTile(Position(5, 5))
    var tile56 = PathTile(Position(5, 6))
    var tile60 = PathTile(Position(6, 0))
    var tile61 = PathTile(Position(6, 1))
    var tile62 = PathTile(Position(6, 2))
    var tile63 = PathTile(Position(6, 3))
    var tile64 = PathTile(Position(6, 4))
    var tile65 = PathTile(Position(6, 5))



    // Paths element
    // Elements list
    fun level2Elements(): MutableList<LevelElement> {
        conceal.hiddenElement = Key(Position(4,6))
        concealTwo.hiddenElement = Key(Position(3,2))
        concealThree.hiddenElement = Key(Position(1,2))
        return listOf(
                finish, player, door, doorTwo, tile46, tile41, tile01, tile02, conceal, concealTwo,
                tile00, tile40, tile60, tile61,tile62,tile63, tile64, concealThree, doorThree, tile65, tile36,
                tile50, tile55, tile56, tile42, tile32, tile22, tile12

        ).toMutableList()
    }
    // Level
    private var levelTwo =
            Level(
                    levelData.medium,
                    level2name,
                    level2Elements(),
                    level2Desc,
                    7)

    fun createMediumLevelTwo(){
        levelTwo.ifEnabled = true
        levelTwo.repeatEnabled = true
        levelTwo.callProceduresEnabled = true
        levelTwo.maxMovsBoard1 = 7
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelTwo)
        levelData.levelDAO.commit()
    }
}
