package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.user.User
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

    @PostMapping("/saveLevel")
    @Throws(Exception::class)
    fun saveLevelSucces(@RequestBody levelData: StorableDataLevel): ResponseEntity<String> {
        try {
            service.saveLevelSucces(levelData.userName!!, levelData.levelID!!, levelData.stars!!)
        }catch(e: Exception){
            return ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity("Saved succesfully", HttpStatus.OK)
    }

    @GetMapping("/levelsCompleted")
    @Throws(Exception::class)
    fun getUserLevelsCompleted(@RequestParam userName: String): ResponseEntity<MutableList<StorableDataLevel>> {
        var response: MutableList<StorableDataLevel>
        try {
            response = service.getUserLevelsCompleted(userName)
        }catch(e: Exception){
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/completionProgress")
    @Throws(Exception::class)
    fun getUserCompletionProgress(@RequestParam userName: String): ResponseEntity<Int> {
        var response: Int = 0
        try {
            response = service.getUserCompletionProgress(userName)
        }catch(e: Exception){
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

}