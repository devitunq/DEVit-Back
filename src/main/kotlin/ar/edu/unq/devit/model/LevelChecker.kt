package ar.edu.unq.devit.model

import ar.edu.unq.devit.model.error.*


class LevelChecker(var levelToCheck: Level, var functionList: List<Function>) {

    var actualPositionPlayer = levelToCheck.playerPosition

    var lastKnownPlayerPosition = levelToCheck.playerPosition

    var totalInstructions = 0

    var levelToCheckState = LevelState.Incomplete

    private var fullGame : MutableList<List<LevelElement>> = mutableListOf(levelToCheck.elements.toList())

    var comment: String = LevelComments.LEVEL_INCOMPLETE

    var starsWons: Int = 0

    var canTryNextAction : Boolean = true

    private fun tryActionOrException(action: Action){
        if (canTryNextAction) {
            action(this)
            if (!levelToCheck.tilesPositions().contains(actualPositionPlayer!!))
                throw OutOfPathException(ModelMessages.OUT_OF_PATH_EXCEPTION)
            else {
                fullGame.add(levelToCheck.elements.toList())
            }
        } else canTryNextAction = true
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
        } catch (e: OutOfPathException){
            this.comment = LevelComments.FAILED_LEVEL_BY_WATER
        } catch (e: PlayerKeyNotFoundException) {
            this.comment = LevelComments.FAILED_BY_NO_KEY
        } catch (e: DoorNotFoundException) {
            this.comment = LevelComments.FAILED_BY_NO_DOOR
        } catch (e: DoorAlreadyOpenException) {
            this.comment = LevelComments.FAILED_BY_ALREADY_OPEN
        } catch (e: KeyNotFoundException) {
            this.comment = LevelComments.FAILED_BY_KEY_NOT_FOUND
        } catch (e: ClosedDoorException) {
            this.comment = LevelComments.FAILED_BY_CLOSED_DOOR
        }
        fullGame.add(levelToCheck.elements.toList())
        return SolutionResponse(levelToCheckState, this.comment, fullGame, starsWons)
    }

}