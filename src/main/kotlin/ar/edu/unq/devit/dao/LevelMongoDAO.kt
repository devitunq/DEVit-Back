package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.Level
import com.mongodb.client.model.Filters.*
import org.springframework.stereotype.Repository

@Repository
class LevelMongoDAO: GenericMongoDAO<Level>(Level::class.java){

    fun safeSave(level: Level) {
        if(getBy("levelId", level.levelId) == null){ save(level) }
    }

    fun isExistentLevel (levelId: String): Boolean {
        var isExistentLevel = false
        if(getBy("levelId", levelId) != null) isExistentLevel = true
        return isExistentLevel
    }

    fun numberOfLevelsInCollection() = numberOfDocuments()

    fun numberOfLevelsPublicsInCollection(): Int =
            find(
                    and(
                            eq("private", false),
                            or(
                                    eq("difficulty", "Easy"),
                                    eq("difficulty", "Medium")
                            )
                    )
            ).size
}