package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import org.springframework.stereotype.Service

@Service
class LevelService {

    private val levelDAO = LevelMongoDAO()

    fun findByDifficulty(difficulty: Difficulty) : List<Level> = levelDAO.findEq("difficulty", difficulty.toString())

    fun findByLevelId(levelId: String) : Level = levelDAO.getBy("levelId", levelId)!!

    fun getDificulties() : List<Difficulty> = levelDAO.findAll().map { level -> level.difficulty!! }.toSet().toList()


}