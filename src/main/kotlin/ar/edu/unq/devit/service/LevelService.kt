package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import org.springframework.stereotype.Repository

@Repository
class LevelService {

    private val levelDAO = LevelMongoDAO()

    fun findByDifficulty(difficulty: Difficulty) : List<Level> = levelDAO.findEq("difficulty", difficulty.toString())

    fun findByLevel(levelName: String) : Level = levelDAO.findEq("name", levelName).first()

}