package ar.edu.unq.devit.model.request

import ar.edu.unq.devit.model.levelElements.LevelElement
import ar.edu.unq.devit.model.LevelState

data class SolutionResponse(
        val levelState : LevelState,
        val comment: String,
        val fullGame : List<List<LevelElement>> = listOf(),
        val starsWon: Int
)