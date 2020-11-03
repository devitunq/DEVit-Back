package ar.edu.unq.devit.model

import ar.edu.unq.devit.model.error.ModelMessages
import ar.edu.unq.devit.model.error.OutOfPathException
import ar.edu.unq.devit.model.error.PlayerKeyNotFoundException


class LevelChecker(var levelToCheck: Level, var functionList: List<Function>) {

    var actualPositionPlayer = levelToCheck.playerPosition

    var totalInstructions = 0

    var levelToCheckState = LevelState.Incomplete

    private var fullGame : MutableList<List<LevelElement>> = mutableListOf(levelToCheck.elements.toList())

    var comment: String = LevelComments.LEVEL_INCOMPLETE

    var starsWons: Int = 0

    private fun tryActionOrException(action: Action){
        action(this)
        levelToCheck.changePlayerPositionToAndCollect(actualPositionPlayer!!)
        if(!levelToCheck.tilesPositions().contains(actualPositionPlayer!!))
            throw OutOfPathException(ModelMessages.OUT_OF_PATH_EXCEPTION)
        else {
            //TODO REFACTOR PUTA MADRE.
            if (levelToCheck.getLevelDoors().any { d -> d.position == actualPositionPlayer && !d.isOpen })
                levelToCheck.openDoor()
            fullGame.add(levelToCheck.elements.toList())
        }
    }

    private fun setSuccessLevelComment(){
        if(totalInstructions == levelToCheck.bestNumberMovesToWin){
            this.comment = LevelComments.LEVEL_COMPLETE_BEST_WAY
        }
        else{
            this.comment = LevelComments.LEVEL_COMPLETE
        }
    }

    private fun doActions(){
        for (action in functionList[0].actionList)
            tryActionOrException(action)
    }


    fun winOrLost(): SolutionResponse {
        try {
            totalInstructions = functionList.fold(0, { acc, f -> acc +f.actionList.size })
            if (functionList.isNotEmpty()) doActions()
            if(actualPositionPlayer == levelToCheck.finishPosition()) {
                levelToCheckState = LevelState.Complete
                levelToCheck.removeFinish()
                fullGame.removeAt(fullGame.size-1)
                this.setSuccessLevelComment()
                starsWons = StarsSystem.calculateStars(levelToCheck.bestNumberMovesToWin!!, totalInstructions)
            }
        } catch(e: OutOfPathException){
            this.comment = LevelComments.FAILED_LEVEL_BY_WATER
        } catch (e: PlayerKeyNotFoundException) {
            this.comment = LevelComments.FAILED_BY_NO_KEY
        }
        fullGame.add(levelToCheck.elements.toList())
        return SolutionResponse(levelToCheckState, this.comment, fullGame, starsWons)
    }

}