package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.request.RegisterRequest
import ar.edu.unq.devit.model.StorableDataLevel
import ar.edu.unq.devit.model.error.InvalidSignIn
import ar.edu.unq.devit.model.error.PasswordsDontMatch
import ar.edu.unq.devit.model.error.UserAlreadyExists
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
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/register")
    @Throws(Exception::class)
    fun registerUser(@RequestBody registerRequest: RegisterRequest): ResponseEntity<*> {
        var response: User
        try {
            response = service.registerUser(registerRequest)
        } catch (e: PasswordsDontMatch) {
            return ResponseEntity("Las contraseñas no coinciden", HttpStatus.BAD_REQUEST)
        } catch (e: UserAlreadyExists) {
            return ResponseEntity("El usuario ya existe", HttpStatus.PRECONDITION_FAILED)
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
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/completionProgress")
    @Throws(Exception::class)
    fun getUserCompletionProgress(@RequestParam userName: String): ResponseEntity<Long> {
        var response: Long
        try {
            response = service.getUserCompletionProgress(userName)
        }catch(e: Exception){
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

}