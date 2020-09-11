package ar.edu.unq.devit.model

class LevelChecker(var levelToCheck: Level?, var actionList: MutableList<Action>) {

    var actualPositionPlayer = levelToCheck!!.playerPosition()

    var levelToCheckState = LevelState.Incomplete

    private fun tryActionOrException(action: Action){
        actualPositionPlayer = action(actualPositionPlayer)
        if(!levelToCheck!!.tilesPositions().contains(actualPositionPlayer))
            throw Exception("No hay camino por aquí")
    }

    private fun doActions(){
        for (action in actionList)
            tryActionOrException(action)
    }

    fun winOrLost(): SolutionResponse {
        doActions()
        if(actualPositionPlayer == levelToCheck!!.finishPosition())
            levelToCheckState = LevelState.Complete
        return SolutionResponse(levelToCheckState, actualPositionPlayer)
    }

}