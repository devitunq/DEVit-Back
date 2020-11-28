package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.*

class MediumLevelTwo {

    val levelData = GenericLevelData

    // Level name
    var level1name = "Level Two"

    // Level description
    var level1Desc = "El objetivo de este nivel es lograr llegar a la meta" +
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

    var tile00 = PathTile(Position(0, 1))
    var tile01 = PathTile(Position(0, 2))
    var tile02 = PathTile(Position(0, 3))
    var tile12 = PathTile(Position(1, 1))
    var tile32 = PathTile(Position(1, 4))
    var tile40 = PathTile(Position(1, 5))
    var tile41 = PathTile(Position(1, 6))
    var tile42 = PathTile(Position(2, 0))
    var tile46 = PathTile(Position(2, 1))
    var tile60 = PathTile(Position(2, 6))
    var tile61 = PathTile(Position(3, 1))
    var tile62 = PathTile(Position(3, 6))
    var tile63 = PathTile(Position(4, 1))
    var tile64 = PathTile(Position(4, 6))
    var tile65 = PathTile(Position(5, 1))


    // Paths element
    // Elements list
    fun level2Elements(): MutableList<LevelElement> {
        conceal.hiddenElement = Key(Position(4,6))
        concealTwo.hiddenElement = Key(Position(3,2))
        concealThree.hiddenElement = Key(Position(1,2))
        return listOf(
                finish, player, door, doorTwo, tile46, tile41, tile01, tile02, conceal, concealTwo,
                tile00, tile40, tile60, tile61, tile64, concealThree, doorThree, tile65
        ).toMutableList()
    }
    // Level
    private var levelOne =
            Level(
                    levelData.medium,
                    level1name,
                    level2Elements(),
                    level1Desc,
                    19)

    fun createMediumLevelTwo(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(levelOne)
        levelData.levelDAO.commit()
    }
}
