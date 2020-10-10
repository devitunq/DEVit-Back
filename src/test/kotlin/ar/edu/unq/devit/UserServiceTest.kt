package ar.edu.unq.devit

import ar.edu.unq.devit.dao.levelsMongoData.userData.GenericUserData
import ar.edu.unq.devit.model.user.User
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
        var usr = User()
        usr.userName = "rodrigo"
        usr.password = "123"
        var me = userService.loginUser(usr)
        Assert.assertTrue(me.nick == "rodri")
    }

}