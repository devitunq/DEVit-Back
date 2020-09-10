package ar.edu.unq.devit

import ar.edu.unq.devit.helpersAndData.EasyLevel
import ar.edu.unq.devit.model.*
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LevelTest{

    var data = EasyLevel()


    @BeforeEach
    fun initializerLvlTesting(){
        data.dataInitialize()
    }

    @Test
    fun getPlayerPosition(){
        var playerPos = data.levelTest.playerPosition()

        val realPlayerPos = Position(1,1)

        Assert.assertTrue(playerPos == realPlayerPos)
    }

    @Test
    fun getFinishPosition(){
        var finishPos = data.levelTest.finishPosition()

        val realFinishPos = Position(4,4)

        Assert.assertTrue(finishPos == realFinishPos)
    }

    @Test
    fun getTilesPositions(){
        var tilesPos = data.levelTest.tilesPositions()

        val realtilesPos = listOf(
                data.tile01.position,data.tile02.position,data.tile12.position,data.tile11.position,
                data.tile13.position,data.tile21.position, data.tile23.position,data.tile24.position,
                data.tile31.position,data.tile32.position,data.tile34.position,data.tile42.position,
                data.tile43.position,data.tile44.position)

        Assert.assertTrue(tilesPos.containsAll(realtilesPos))
        Assert.assertTrue(tilesPos.size == realtilesPos.size)
    }




}