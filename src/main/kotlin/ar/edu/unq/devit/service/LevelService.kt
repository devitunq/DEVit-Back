package ar.edu.unq.devit.service

import ar.edu.unq.devit.dao.LevelMongoDAO
import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.LevelScore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LevelService {

    @Autowired
    lateinit var levelDAO : LevelMongoDAO

    fun findByDifficulty(difficulty: Difficulty) : List<Level> = levelDAO.findEq("difficulty", difficulty.toString())

    fun findByLevelId(levelId: String) : Level = levelDAO.getBy("levelId", levelId)!!

    fun getDificulties() : List<Difficulty> = levelDAO.findAll().map { level -> level.difficulty!! }.toSet().toList()

    fun scoreLevel (levelID: String, score: String){
        var level = levelDAO.getBy("levelId", levelID)!!
        println(score)
        if(score == "Like"){ level.likes++ }
        else{ level.dislikes++ }
        levelDAO.updateBy(level, "levelId", levelID)
    }

}