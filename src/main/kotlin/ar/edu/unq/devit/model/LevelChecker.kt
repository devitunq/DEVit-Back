package ar.edu.unq.devit.model

class LevelChecker(var levelToCheck: Level, var actionList: MutableList<Action>) {

    var actualPositionPlayer = levelToCheck.playerPosition()

    var levelToCheckState = LevelState.Incomplete

    private var fullGame : MutableList<List<LevelElement>> = mutableListOf(levelToCheck.elements.toList())

    private fun tryActionOrException(action: Action){
        actualPositionPlayer = action(actualPositionPlayer)
        levelToCheck.changePlayerPositionTo(actualPositionPlayer)
        if(!levelToCheck.tilesPositions().contains(actualPositionPlayer))
            throw Exception("No hay camino por aquí")
        else
            fullGame.add(levelToCheck.elements.toList())
    }

    private fun doActions(){
        for (action in actionList)
            tryActionOrException(action)


    }

    fun winOrLost(): SolutionResponse {
        try {
            doActions()
            if(actualPositionPlayer == levelToCheck.finishPosition()) {
                levelToCheckState = LevelState.Complete
                levelToCheck.removeFinish()
                fullGame.removeAt(fullGame.size-1)
            }
        } catch(e: Exception){}
        fullGame.add(levelToCheck.elements.toList())
        return SolutionResponse(levelToCheckState, fullGame)
    }

}