package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LevelService {

    @Autowired
    lateinit var levelDAO : LevelMongoDAO

    fun findByDifficulty(difficulty: Difficulty) : List<Level> = levelDAO.findEq("difficulty", difficulty.toString())

    fun findByLevelId(levelId: String) : Level = levelDAO.getBy("levelId", levelId)!!

    fun getDificulties() : List<Difficulty> = levelDAO.findAll().map { level -> level.difficulty!! }.toSet().toList()

    fun scoreLevel (levelID: String, score: String, from: String){
        var level = levelDAO.getBy("levelId", levelID)!!
        if (!level.isUserCalificator(from, levelID)){
            level.addCalificator(from, levelID)
            level.addScore(score)
            levelDAO.updateBy(level, "levelId", levelID)
        }
    }

    fun saveLevel(level: Level) = levelDAO.safeSave(level)


}