package ar.edu.unq.devit.model

import ar.edu.unq.devit.model.Errors.ModelMessages
import ar.edu.unq.devit.model.Errors.OutOfPathException

class LevelChecker(var levelToCheck: Level, var actionList: MutableList<Action>) {

    var actualPositionPlayer = levelToCheck.playerPosition()

    var levelToCheckState = LevelState.Incomplete

    private var fullGame : MutableList<List<LevelElement>> = mutableListOf(levelToCheck.elements.toList())

    var comment: String = ""

    private fun tryActionOrException(action: Action){
        actualPositionPlayer = action(actualPositionPlayer)
        levelToCheck.changePlayerPositionTo(actualPositionPlayer)
        if(!levelToCheck.tilesPositions().contains(actualPositionPlayer))
            throw OutOfPathException(ModelMessages.outOfPathMessage)
        else
            fullGame.add(levelToCheck.elements.toList())
    }

    private fun setSuccessLevelComment(){
        if(actionList.size == levelToCheck.bestNumberMovesToWin){
            this.comment = LevelComments.successLevelBestWay
        }
        else{
            this.comment = LevelComments.successLevel
        }
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
            this.setSuccessLevelComment()
        } catch(e: OutOfPathException){
            this.comment = LevelComments.failedLevelByWater
        }
        fullGame.add(levelToCheck.elements.toList())
        return SolutionResponse(levelToCheckState, this.comment, fullGame)
    }

}