package ar.edu.unq.devit.dao.levelsMongoData.userData

import ar.edu.unq.devit.dao.UserMongoDAO
import ar.edu.unq.devit.model.user.User

class GenericUserData {

    var rodrigoUser = User("rodrigo","123", "rodri")
    var lucasUser = User("lucas","123", "lucas")
    var mongoDAO = UserMongoDAO()

    var userTest = User()

    fun userGenerator(){
        mongoDAO.startTransaction()
        mongoDAO.safeSave(rodrigoUser)
        mongoDAO.safeSave(lucasUser)
        mongoDAO.commit()
    }

}