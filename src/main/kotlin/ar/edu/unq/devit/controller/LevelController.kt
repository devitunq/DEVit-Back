package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.service.LevelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/levels")
class LevelController {

    @Autowired
    private lateinit var service: LevelService

    @GetMapping
    @Throws(Exception::class)
    fun getAll(): ResponseEntity<List<Level>> {
        var response: List<Level>
        try {
            response = service.findAll()
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }
}