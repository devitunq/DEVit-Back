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

    // Elements list
    var level1Elements = listOf(finish,player).toMutableList()

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