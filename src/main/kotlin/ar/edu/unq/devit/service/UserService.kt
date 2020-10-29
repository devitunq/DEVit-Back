package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.UserMongoDAO
import ar.edu.unq.devit.model.StorableDataLevel
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.user.User
import ar.edu.unq.devit.security.getJWTToken
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors


@Service
class UserService {

    @Autowired
    lateinit var userDAO : UserMongoDAO

    @Throws(InvalidSignIn::class)
    fun loginUser(user: User) : User {
        var usr = userDAO.getUser(user.userName!!, user.password!!)
        usr.token = getJWTToken(user.userName!!, 86400000)
        usr.password = null
        return usr
    }

    fun saveLevelSucces(userName: String, levelID: String, stars: Int){
        var userToUpdate = userDAO.getBy("userName", userName)
        userToUpdate!!.saveLevelSucces(StorableDataLevel(userName, levelID, stars))
        userDAO.updateBy(userToUpdate, "userName", userName)
    }

}