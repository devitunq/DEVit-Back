package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.user.User
import ar.edu.unq.devit.service.LevelService
import ar.edu.unq.devit.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/user")
class UserController {

    @Autowired
    private lateinit var service: UserService

    @PostMapping
    @Throws(Exception::class)
    fun getUserByUserAndPassoword(@RequestBody user: String, @RequestBody password: String): ResponseEntity<User> {
        var response: User
        try {
            response = service.findByUserAndPassoword(user, password)
        } catch (e: Exception) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }
}