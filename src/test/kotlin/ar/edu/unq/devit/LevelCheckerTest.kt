package ar.edu.unq.devit

import ar.edu.unq.devit.helpersAndData.EasyLevel
import ar.edu.unq.devit.model.Action
import ar.edu.unq.devit.model.LevelChecker
import ar.edu.unq.devit.model.LevelComments
import ar.edu.unq.devit.model.LevelState
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.lang.Exception

class LevelCheckerTest{

    var data = EasyLevel()


    @BeforeEach
    fun initializerLvlTesting(){
        data.dataInitialize()
    }

    @Test
    fun firstPosibleTravel(){
        var succesActionList =
                listOf(Action.GoDown,Action.GoDown,Action.GoRight,Action.GoDown,Action.GoRight,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)
    }

    @Test
    fun secondPosibleTravel(){
        var succesActionList =
                listOf(Action.GoRight,Action.GoRight,Action.GoDown,Action.GoRight,Action.GoDown,Action.GoDown).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)
    }

    @Test
    fun thirdPosibleTravel(){
        var succesActionList =
                listOf(Action.GoLeft,Action.GoDown,Action.GoRight,Action.GoDown,Action.GoRight,Action.GoDown,
                        Action.GoRight,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost().levelState == LevelState.Complete)

    }

    @Test
    fun notPosibleTravel(){
        var succesActionList =
                listOf(Action.GoLeft,Action.GoDown,Action.GoDown).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        var res = levelChecker.winOrLost()

        Assert.assertEquals(LevelState.Incomplete, res.levelState)
        Assert.assertEquals(LevelComments.FAILED_LEVEL_BY_WATER , res.comment)
    }

    @Test
    fun incompletePosibleTravel(){
        var succesActionList =
                listOf(Action.GoDown,Action.GoDown,Action.GoRight,Action.GoDown,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)
        var res = levelChecker.winOrLost()
        Assert.assertEquals(LevelState.Incomplete, res.levelState)
        Assert.assertEquals(LevelComments.LEVEL_INCOMPLETE, res.comment)
    }




}