package ar.edu.unq.devit

import ar.edu.unq.devit.HelpersAndData.EasyLevel
import ar.edu.unq.devit.model.Action
import ar.edu.unq.devit.model.LevelChecker
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
                listOf(Action.GoUp,Action.GoUp,Action.GoRight,Action.GoUp,Action.GoRight,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost() == LevelState.Complete)
    }

    @Test
    fun secondPosibleTravel(){
        var succesActionList =
                listOf(Action.GoRight,Action.GoRight,Action.GoUp,Action.GoRight,Action.GoUp,Action.GoUp).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost() == LevelState.Complete)
    }

    @Test
    fun thirdPosibleTravel(){
        var succesActionList =
                listOf(Action.GoLeft,Action.GoUp,Action.GoRight,Action.GoUp,Action.GoRight,Action.GoUp,
                        Action.GoRight,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost() == LevelState.Complete)

    }

    @Test
    fun notPosibleTravel(){
        var succesActionList =
                listOf(Action.GoLeft,Action.GoUp,Action.GoUp).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        try {
            levelChecker.winOrLost()
            fail("Se esperaba algun error de camino no accesible")
        }catch (ex: Exception){
            Assert.assertEquals(ex.message,"No hay camino por aquí")
        }
    }

    @Test
    fun incompletePosibleTravel(){
        var succesActionList =
                listOf(Action.GoUp,Action.GoUp,Action.GoRight,Action.GoUp,Action.GoRight).toMutableList()

        var levelChecker = LevelChecker(data.levelTest,succesActionList)

        Assert.assertTrue(levelChecker.winOrLost() == LevelState.Incomplete)
    }




}