package ar.edu.unq.devit.service
import ar.edu.unq.devit.dao.UserMongoDAO
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.user.User
import org.springframework.stereotype.Service

@Service
class UserService {

    private val userDAO = UserMongoDAO()

    fun findByUserAndPassoword(userName: String, password: String) : User = userDAO.getUser(userName,password)


}