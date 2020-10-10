package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.ModelMessages
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
    fun loginUser(@RequestBody user: User): ResponseEntity<User> {
        var response: User
        try {
            response = service.loginUser(user)
        } catch (e: InvalidSignIn) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }
}