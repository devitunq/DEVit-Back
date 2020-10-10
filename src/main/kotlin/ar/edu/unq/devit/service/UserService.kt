package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.UserMongoDAO
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.user.User
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
    private lateinit var userDAO : UserMongoDAO

    @Throws(InvalidSignIn::class)
    fun loginUser(user: User) : User {
        var usr = userDAO.getUser(user.userName!!, user.password!!)
        usr.token = getJWTToken(user.userName!!)
        usr.password = null
        return usr
    }

    private fun getJWTToken(username: String): String? {
        val secretKey = "D3v1T-s3Cr3t-k3y"
        val grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER")
        val token = Jwts
                .builder()
                .setId("dvJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map { obj: GrantedAuthority -> obj.authority }
                                .collect(Collectors.toList()))
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.toByteArray()).compact()
        return "Bearer $token"
    }
}