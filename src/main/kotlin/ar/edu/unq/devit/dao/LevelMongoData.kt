package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.*

class LevelMongoData {

    // DAO
    var mongoDAO = LevelMongoDAO()

    // Difficulty
    var easy = Difficulty.Easy
    var medium = Difficulty.Medium
    var hard = Difficulty.Hard

    // Action
    var goUp = Action.GoUp
    var goDown = Action.GoDown
    var goLeft = Action.GoLeft
    var goRight = Action.GoRight

    // Positions
    var posFinishLvl1 = Position(0,6)
    var posPlayerLvl1 = Position(1,4)

    // Level name
    var level1name = "Level One"

    // Level description
    var level1Desc = "El objetivo de este nivel es lograr llegar a la meta" +
            " con la menor cantidad de instrucciones posible"

    // Finish element
    var finish = Finish(posFinishLvl1)

    // Player element
    var player = Player(posPlayerLvl1)

    // Paths element
    var tile00 = PathTile(Position(0,0))
    var tile01 = PathTile(Position(0,1))
    var tile02 = PathTile(Position(0,2))
    var tile03 = PathTile(Position(0,3))
    var tile04 = PathTile(Position(0,4))
    var tile05 = PathTile(Position(0,5))
    var tile10 = PathTile(Position(1,0))
    var tile11 = PathTile(Position(1,1))
    var tile12 = PathTile(Position(1,2))
    var tile13 = PathTile(Position(1,3))
    var tile15 = PathTile(Position(1,5))
    var tile16 = PathTile(Position(1,6))
    var tile20 = PathTile(Position(2,0))
    var tile21 = PathTile(Position(2,1))
    var tile22 = PathTile(Position(2,2))
    var tile23 = PathTile(Position(2,3))
    var tile24 = PathTile(Position(2,4))
    var tile25 = PathTile(Position(2,5))
    var tile26 = PathTile(Position(2,6))
    var tile30 = PathTile(Position(3,0))
    var tile31 = PathTile(Position(3,1))
    var tile32 = PathTile(Position(3,2))
    var tile33 = PathTile(Position(3,3))
    var tile34 = PathTile(Position(3,4))
    var tile35 = PathTile(Position(3,5))
    var tile36 = PathTile(Position(3,6))
    var tile40 = PathTile(Position(4,0))
    var tile41 = PathTile(Position(4,1))
    var tile42 = PathTile(Position(4,2))
    var tile43 = PathTile(Position(4,3))
    var tile44 = PathTile(Position(4,4))
    var tile45 = PathTile(Position(4,5))
    var tile46 = PathTile(Position(4,6))
    var tile50 = PathTile(Position(5,0))
    var tile51 = PathTile(Position(5,1))
    var tile52 = PathTile(Position(5,2))
    var tile53 = PathTile(Position(5,3))
    var tile54 = PathTile(Position(5,4))
    var tile55 = PathTile(Position(5,5))
    var tile56 = PathTile(Position(5,6))
    var tile60 = PathTile(Position(6,0))
    var tile61 = PathTile(Position(6,1))
    var tile62 = PathTile(Position(6,2))
    var tile63 = PathTile(Position(6,3))
    var tile64 = PathTile(Position(6,4))
    var tile65 = PathTile(Position(6,5))
    var tile66 = PathTile(Position(6,6))


    // Path list

    var pathList = listOf(
            tile00,tile01,tile02,tile03,tile04,tile05,
            tile10,tile11,tile12,tile13,tile15,tile16,
            tile20,tile21,tile22,tile23,tile24,tile25,tile26,
            tile30,tile31,tile32,tile33,tile34,tile35,tile36,
            tile40,tile41,tile42,tile43,tile44,tile45,tile46,
            tile50,tile51,tile52,tile53,tile54,tile55,tile56,
            tile60,tile61,tile62,tile63,tile64,tile65,tile66)

    // Elements list
    var level1Elements =
            listOf(
                    finish,player,
                    tile00,tile01,tile02,tile03,tile04,tile05,
                    tile10,tile11,tile12,tile13,tile15,tile16,
                    tile20,tile21,tile22,tile23,tile24,tile25,tile26,
                    tile30,tile31,tile32,tile33,tile34,tile35,tile36,
                    tile40,tile41,tile42,tile43,tile44,tile45,tile46,
                    tile50,tile51,tile52,tile53,tile54,tile55,tile56,
                    tile60,tile61,tile62,tile63,tile64,tile65,tile66
            ).toMutableList()

    // Level
    var levelOne = Level(easy,level1name,level1Elements,level1Desc)

    fun createDefaultLevels(){
        mongoDAO.startTransaction()
        mongoDAO.save(levelOne)
        mongoDAO.commit()
    }

    fun deleteDefaultLevels(){
        mongoDAO.deleteAll()
    }

}