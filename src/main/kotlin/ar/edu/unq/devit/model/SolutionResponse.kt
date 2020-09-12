package ar.edu.unq.devit.model

data class SolutionResponse(val levelState : LevelState, val fullGame : List<List<LevelElement>> = listOf())