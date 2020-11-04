package ar.edu.unq.devit.controller

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Function
import ar.edu.unq.devit.service.LevelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
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

    @GetMapping("/difficulties")
    @Throws(Exception::class)
    fun getDifficulties(): ResponseEntity<List<Difficulty>>{
        var response: List<Difficulty>
        try{
            response = service.getDificulties()
        }catch (e: Exception){
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{levelId}")
    @Throws(Exception::class)
    fun getLevelByLevelId(@PathVariable levelId: String): ResponseEntity<Level> {
        var response: Level
        try {
            response = service.findByLevelId(levelId)
        } catch (e: Exception) {
            println("Error: $e")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/solve/{levelId}")
    @Throws(Exception::class)
    fun solve(@PathVariable levelId: String, @RequestBody solution: List<Function>): ResponseEntity<SolutionResponse> {
        var res: SolutionResponse? = null
        try {
            var level = service.findByLevelId(levelId)
            var levelChecker = LevelChecker(level, solution.toMutableList())
            res = levelChecker.winOrLost()
        } catch (e: Exception) {
            return ResponseEntity(res, HttpStatus.OK)
        }
        return ResponseEntity(res, HttpStatus.OK)
    }

    @PostMapping("/score/{levelId}")
    @Throws(Exception::class)
    fun scoreLevel(@PathVariable levelId: String, @RequestBody score: ScoreHeader): ResponseEntity<String> {
        try {
             service.scoreLevel(levelId, score.score!!, score.from!!)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.OK)
    }
}