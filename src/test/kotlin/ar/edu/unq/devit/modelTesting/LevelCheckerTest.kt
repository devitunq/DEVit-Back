package ar.edu.unq.devit.modelTesting

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Function
import ar.edu.unq.devit.modelTesting.helpersAndData.EasyLevel
import org.junit.Assert
import org.junit.jupiter.api.Test

class LevelCheckerTest{

    var data = EasyLevel()

    @Test
    fun firstPosibleTravel(){
        var succesActionList =
                listOf(Function("f1", listOf(GoDown(),GoDown(),GoRight(),GoDown(),GoRight(),GoRight())))

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)
    }

    @Test
    fun secondPosibleTravel(){
        var succesActionList =
                listOf(Function("f1", listOf(GoRight(),GoRight(),GoDown(),GoRight(),GoDown(),GoDown())))

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)
    }

    @Test
    fun thirdPosibleTravel(){
        var succesActionList =
                listOf(Function("f1", listOf(GoLeft(),GoDown(),GoRight(),GoDown(),GoRight(),GoDown(),
                        GoRight(),GoRight())))

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)

    }

    @Test
    fun notPosibleTravel(){
        var succesActionList =
                listOf(Function("f1", listOf(GoLeft(),GoDown(),GoDown())))

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        var res = levelChecker.winOrLost()

        Assert.assertEquals(LevelState.Incomplete, res.levelState)
        Assert.assertEquals(LevelComments.FAILED_LEVEL_BY_WATER , res.comment)
    }

    @Test
    fun incompletePosibleTravel(){
        var succesActionList =
                listOf(Function("f1", listOf(GoDown(),GoDown(),GoRight(),GoDown(),GoRight())))

        var levelChecker = LevelChecker(data.levelTest,succesActionList)
        var res = levelChecker.winOrLost()
        Assert.assertEquals(LevelState.Incomplete, res.levelState)
        Assert.assertEquals(LevelComments.LEVEL_INCOMPLETE, res.comment)
    }

}