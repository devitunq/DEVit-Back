package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.Difficulty
import ar.edu.unq.devit.model.Level
import com.mongodb.client.model.Aggregates
import com.mongodb.client.model.Filters.eq
import org.springframework.stereotype.Repository

@Repository
class LevelMongoDAO: GenericMongoDAO<Level>(Level::class.java){

    fun safeSave(level: Level) {
        if(getBy("levelId", level.levelId) == null){ save(level) }
    }

    fun numberOfLevelsInCollection() = aggregate(listOf(Aggregates.count()), Int::class.java)[0]

    fun numberOfLevelsInCollectionByDifficulty(difficulty: Difficulty): Int {
        val match = Aggregates.match(eq("difficulty", difficulty))
        val count = Aggregates.count()
        return aggregate(listOf(match, count), Int::class.java)[0]
    }
}