package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.service.LevelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/levels")
class LevelController {

    @Autowired
    private lateinit var service: LevelService

    @GetMapping
    @Throws(Exception::class)
    fun getAllByDifficulty(@RequestParam difficulty: Difficulty): ResponseEntity<List<Level>> {
        var response: List<Level>
        try {
            response = service.findByDifficulty(difficulty)
        } catch (e: Exception) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping
    @Throws(Exception::class)
    fun getLevelByName(@RequestParam name: String): ResponseEntity<Level> {
        var response: Level
        try {
            response = service.findByLevel(name)
        } catch (e: Exception) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }



    @PostMapping("/solve")
    @Throws(Exception::class)
    fun solve(@RequestBody solution: SolutionLevel): ResponseEntity<LevelState> {
        var levelChecker = LevelChecker(solution.level, solution.actions.toMutableList())
        var res = LevelState.Incomplete
        try {
            res = levelChecker.winOrLost()
        } catch (e: Exception) {
            return ResponseEntity(res, HttpStatus.OK)
        }
        return ResponseEntity(res, HttpStatus.OK)
    }
}