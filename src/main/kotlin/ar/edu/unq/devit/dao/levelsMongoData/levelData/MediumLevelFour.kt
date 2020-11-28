package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.Position
import ar.edu.unq.devit.model.levelElements.*

class MediumLevelFour {

    val levelData = GenericLevelData

    var levelname = "Level Four"

    var levelDesc = "Es hora de combinar todo lo aprendido hasta el momento, esta vez tendrás un límite de 6 movimientos para el tablero 1, y 6 para el tablero 2. Pista: Delegar responsabilidades."

    // Finish element
    var finish = Finish(Position(6, 0))

    // Player element
    var player = Player(Position(0, 6))

    //Key and Door
    var key = Key(Position(1, 4 ))
    var door = Door(Position(3, 3))


    // Paths element
    var tile06 = PathTile(Position(0, 6))
    var tile05 = PathTile(Position(0, 5))
    var tile15 = PathTile(Position(1, 5))
    var tile14 = PathTile(Position(1, 4))
    var tile24 = PathTile(Position(2, 4))
    var tile23 = PathTile(Position(2, 3))
    var tile33 = PathTile(Position(3, 3))
    var tile32 = PathTile(Position(3, 2))
    var tile42 = PathTile(Position(4, 2))
    var tile41 = PathTile(Position(4, 1))
    var tile51 = PathTile(Position(5, 1))
    var tile50 = PathTile(Position(5, 0))
    var tile60 = PathTile(Position(6, 0))


    fun levelElements(): MutableList<LevelElement> {
        return listOf(
                finish, player, key, door, tile06, tile05, tile15, tile14, tile24, tile23, tile33, tile32, tile42, tile41, tile51, tile50, tile60
        ).toMutableList()
    }
    // Level
    private var level =
            Level(
                    levelData.medium,
                    levelname,
                    levelElements(),
                    levelDesc,
                    9,
                    maxMovsBoard1 = 6,
                    maxMovsBoard2 = 6,
                    callProceduresEnabled = true,
                    ifEnabled = true,
                    repeatEnabled = true)

    fun createMediumLevelFour(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(level)
        levelData.levelDAO.commit()
    }
}

