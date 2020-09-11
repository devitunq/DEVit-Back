package ar.edu.unq.devit.model

data class SolutionResponse(val levelState : LevelState, val finalPlayerPosition : Position?) {
    constructor(levelState: LevelState) : this(levelState, null)
}