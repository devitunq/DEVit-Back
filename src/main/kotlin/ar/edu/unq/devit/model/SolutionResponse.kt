package ar.edu.unq.devit.model

data class SolutionResponse(
        val levelState : LevelState,
        val comment: String,
        val fullGame : List<List<LevelElement>> = listOf()
)