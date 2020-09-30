package ar.edu.unq.devit

import ar.edu.unq.devit.dao.levelsMongoData.EasyLevelOne
import ar.edu.unq.devit.dao.levelsMongoData.EasyLevelTwo
import ar.edu.unq.devit.service.LevelService
import org.junit.Assert
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LevelServiceTest {

    var lvl1EGenerator = EasyLevelOne()
    var lvl2EGenerator = EasyLevelTwo()
    var levelService = LevelService()

    @BeforeEach
    fun initialData(){
        lvl1EGenerator.createEasyLevelOne()
        lvl2EGenerator.createEasyLevelTwo()
    }

//    @AfterEach
//    fun cleanData(){
//        data.deleteDefaultLevels()
//    }

    @Test
    fun findByLevelTesting(){

        var nameLevel = "Easy_Level One"

        var level1 = levelService.findByLevelId(nameLevel)

        Assert.assertEquals(lvl1EGenerator.levelData.easy , level1.difficulty)
        Assert.assertEquals(lvl1EGenerator.level1Elements.size, level1.elements.size)

    }



}