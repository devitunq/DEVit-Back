package ar.edu.unq.devit

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.dao.levelsMongoData.levelData.EasyLevelOne
import ar.edu.unq.devit.dao.levelsMongoData.levelData.EasyLevelTwo
import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.service.LevelService
import org.junit.Assert
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LevelServiceTest {

    var lvl1EGenerator = EasyLevelOne()
    var lvl2EGenerator = EasyLevelTwo()
    var levelService = LevelService()

    @BeforeAll
    fun beforeData() {
        levelService.levelDAO = LevelMongoDAO()
    }

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
    fun findByLevelIDTesting(){

        var nameLevel1 = "Easy_Level One"
        var nameLevel2 = "Easy_Level Two"

        var level1 = levelService.findByLevelId(nameLevel1)
        var level2 = levelService.findByLevelId(nameLevel2)

        Assert.assertEquals(lvl1EGenerator.levelData.easy , level1.difficulty)
        Assert.assertEquals(lvl1EGenerator.level1Elements.size, level1.elements.size)
        Assert.assertEquals(lvl2EGenerator.levelData.easy , level2.difficulty)
        Assert.assertEquals(lvl2EGenerator.level2Elements.size, level2.elements.size)
    }

    @Test
    fun findByDifficultyTesting(){

        var difficultyToTest = Difficulty.Easy
        var easyLevels = levelService.findByDifficulty(difficultyToTest).map { level -> level.levelId }
        var expectedLevelsID = listOf("Easy_Level One","Easy_Level Two")

        Assert.assertTrue(easyLevels.containsAll(expectedLevelsID))
    }


    @Test
    fun getDifficultiesTesting(){

        var difficultyExpected = Difficulty.Easy
        var difficulties = levelService.getDificulties()

        Assert.assertTrue(difficulties.contains(difficultyExpected))
    }


}