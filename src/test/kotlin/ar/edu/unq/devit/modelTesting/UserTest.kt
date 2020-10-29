package ar.edu.unq.devit.modelTesting

import ar.edu.unq.devit.dao.levelsMongoData.userData.GenericUserData
import ar.edu.unq.devit.model.StorableDataLevel
import ar.edu.unq.devit.model.error.InvalidSignIn
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.lang.AssertionError

class UserTest {

    var data = GenericUserData()

    @Test
    fun changeUserPassowor(){
        data.rodrigoUser.changePassword("123456")
        Assert.assertTrue(data.rodrigoUser.password == "123456" )
    }

    @Test
    fun checkPasswordCorrect(){
        Assert.assertTrue(data.rodrigoUser.checkPassword("123"))
    }

    @Test
    fun checkPasswordIncorrect(){
        try{
            data.rodrigoUser.checkPassword("123hj")
            fail("An error about password expected")
        }catch (e: InvalidSignIn){
            Assert.assertTrue(e.message == "Usuario o contraseña no valida")
        }
    }

    @Test
    fun saveLevelPassed(){
        var newDataStorable = StorableDataLevel("rodrigo", "Easy_Level One", 2)
        data.rodrigoUser.saveLevelSucces(newDataStorable)
        Assert.assertEquals(1,data.rodrigoUser.levelsPassed!!.size)

        var newDataStorable2 = StorableDataLevel("rodrigo", "Easy_Level One", 1)
        data.rodrigoUser.saveLevelSucces(newDataStorable2)
        Assert.assertEquals(1,data.rodrigoUser.levelsPassed!!.size)
        Assert.assertEquals(2, data.rodrigoUser.levelsPassed!![0].stars)

        var newDataStorable3 = StorableDataLevel("rodrigo", "Easy_Level One", 3)
        data.rodrigoUser.saveLevelSucces(newDataStorable3)
        Assert.assertEquals(1,data.rodrigoUser.levelsPassed!!.size)
        Assert.assertEquals(3, data.rodrigoUser.levelsPassed!![0].stars)
    }


}