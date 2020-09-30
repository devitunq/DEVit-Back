package ar.edu.unq.devit.dao.levelsMongoData

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.Action
import ar.edu.unq.devit.model.Difficulty

object GenericLevelData {

    val levelDAO = LevelMongoDAO()

    val easy = Difficulty.Easy
    val medium = Difficulty.Medium
    val hard = Difficulty.Hard

    val goUp = Action.GoUp
    val goDown = Action.GoDown
    val goLeft = Action.GoLeft
    val goRight = Action.GoRight

}