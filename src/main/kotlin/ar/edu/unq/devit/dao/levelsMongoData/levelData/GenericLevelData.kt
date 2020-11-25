package ar.edu.unq.devit.dao.levelsMongoData.levelData

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.*

object GenericLevelData {

    val levelDAO = LevelMongoDAO()

    val easy = Difficulty.Easy
    val medium = Difficulty.Medium
    val hard = Difficulty.Hard

    val goUp = GoUp()
    val goDown = GoDown()
    val goLeft = GoLeft()
    val goRight = GoRight()

}