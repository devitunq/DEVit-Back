package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.user.User
import ar.edu.unq.devit.service.GuestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/guest")

class GuestController {

    @Autowired
    private lateinit var service: GuestService

    @GetMapping
    @Throws(Exception::class)
    fun loginAsGuest(@RequestParam nick: String): ResponseEntity<User> {
        var response: User
        try {
            response = service.getGuestAccess(nick)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

}