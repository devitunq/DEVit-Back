package ar.edu.unq.devit.service

import ar.edu.unq.devit.model.user.User
import ar.edu.unq.devit.model.user.UserPermission
import ar.edu.unq.devit.security.getJWTToken
import org.springframework.stereotype.Service

@Service
class GuestService {

    fun getGuestAccess(nick: String) : User {
        var usr = User()
        usr.userName = nick
        usr.nick = nick
        usr.token = getJWTToken(nick, 43200000)
        usr.permission = UserPermission.LimitAccess
        return usr
    }
}