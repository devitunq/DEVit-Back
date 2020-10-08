package ar.edu.unq.devit.modelTesting

import ar.edu.unq.devit.dao.levelsMongoData.userData.GenericUserData
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


}