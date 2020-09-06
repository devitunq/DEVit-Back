package ar.edu.unq.devit.service

import ar.edu.unq.devit.model.Level
import org.springframework.stereotype.Repository

@Repository
class LevelService {
    fun findAll() : List<Level> {
       return mutableListOf()
    }
}