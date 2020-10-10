package ar.edu.unq.devit.service

import ar.edu.unq.devit.model.user.Guest
import org.springframework.stereotype.Service

@Service
class GuestService {

    fun getGuestPermision() = Guest.permission

}