package ar.edu.unq.devit

import ar.edu.unq.devit.dao.levelsMongoData.userData.GenericUserData
import ar.edu.unq.devit.service.UserService
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserServiceTest {

    var users = GenericUserData()
    var userService = UserService()

    @BeforeEach
    fun initialData() {
        users.userGenerator()
    }

//    @AfterEach
//    fun cleanData(){
//        data.deleteDefaultLevels()
//    }

    @Test
    fun findByUserAndPassoword() {
        var me = userService.findByUserAndPassoword("rodrigo", "123")
        Assert.assertTrue(me.nick == "rodri")
    }

}