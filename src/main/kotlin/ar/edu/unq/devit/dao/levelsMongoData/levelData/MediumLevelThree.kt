package ar.edu.unq.devit.dao.levelsMongoData.levelData
import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.*

class MediumLevelThree {

    val levelData = GenericLevelData

    var levelname = "Level Three"

    var levelDesc = "¿Eres capaz de llegar a la meta con tan solo 3 instrucciones y un tablero?"

    // Finish element
    var finish = Finish(Position(6, 0))

    // Player element
    var player = Player(Position(0, 6))

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
                finish, player, tile06, tile05, tile15, tile14, tile24, tile23, tile33, tile32, tile42, tile41, tile51, tile50, tile60
        ).toMutableList()
    }
    // Level
    private var level =
            Level(
                    levelData.medium,
                    levelname,
                    levelElements(),
                    levelDesc,
                    3,
                    maxMovsBoard1 = 3,
                    maxMovsBoard2 = 0,
                    callProceduresEnabled = true)

    fun createMediumLevelThree(){
        levelData.levelDAO.startTransaction()
        levelData.levelDAO.safeSave(level)
        levelData.levelDAO.commit()
    }
}