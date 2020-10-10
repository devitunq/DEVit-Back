package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.user.UserPermission
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
    fun getAllByDifficulty(): ResponseEntity<UserPermission> {
        var response: UserPermission
        try {
            response = service.getGuestPermision()!!
        } catch (e: Exception) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

}