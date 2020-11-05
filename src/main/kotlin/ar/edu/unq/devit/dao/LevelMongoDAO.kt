package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.Level
import org.springframework.stereotype.Repository

@Repository
class LevelMongoDAO: GenericMongoDAO<Level>(Level::class.java){

    fun safeSave(level: Level) {
        if(getBy("levelId", level.levelId) == null){ save(level) }
    }

    fun numberOfLevelsInCollection() = numberOfDocuments()

}