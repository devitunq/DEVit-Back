package ar.edu.unq.devit

import ar.edu.unq.devit.dao.LevelMongoData
import ar.edu.unq.devit.service.LevelService
import org.junit.Assert
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LevelServiceTest {

    var data = LevelMongoData()
    var levelService = LevelService()

    @BeforeEach
    fun initialData(){
        data.createDefaultLevels()
    }

    @AfterEach
    fun cleanData(){
        //data.deleteDefaultLevels() Se utilizaria en caso de no querer persistir los datos.
    }

    @Test
    fun findByLevelTesting(){

        var nameLevel = "Easy_Level One"

        var level1 = levelService.findByLevelId(nameLevel)

        Assert.assertEquals(data.easy , level1.difficulty)
        Assert.assertEquals(data.level1Elements.size, level1.elements.size)

    }

}