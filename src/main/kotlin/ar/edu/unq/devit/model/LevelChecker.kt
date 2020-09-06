package ar.edu.unq.devit.model


class LevelChecker(var levelToCheck: Level, var actionList: MutableList<Action>) {

    var actualPositionPlayer = levelToCheck.playerPosition()

    var levelToCheckState = LevelState.Incomplete

    // REFACTOR ..

    fun tryGoUp(){
        var newPlayerPos = actualPositionPlayer
        newPlayerPos.posY++;

        if(levelToCheck.tilesPositions().contains(newPlayerPos)){
            actualPositionPlayer = newPlayerPos
        }else{
            throw Exception("No hay camino por aquí")
        }
    }
    fun tryGoDown(){
        var newPlayerPos = actualPositionPlayer
        newPlayerPos.posY--;

        if(levelToCheck.tilesPositions().contains(newPlayerPos)){
            actualPositionPlayer = newPlayerPos
        }else{
            throw Exception("No hay camino por aquí")
        }
    }

    fun tryGoLeft(){
        var newPlayerPos = actualPositionPlayer
        newPlayerPos.posX--;

        if(levelToCheck.tilesPositions().contains(newPlayerPos)){
            actualPositionPlayer = newPlayerPos
        }else{
            throw Exception("No hay camino por aquí")
        }
    }

    fun tryGoRight(){
        var newPlayerPos = actualPositionPlayer
        newPlayerPos.posX++;

        if(levelToCheck.tilesPositions().contains(newPlayerPos)){
            actualPositionPlayer = newPlayerPos
        }else{
            throw Exception("No hay camino por aquí")
        }
    }



    fun tryActionOrException(action: Action){
        when(action){
            Action.GoUp -> tryGoUp()
            Action.GoDown -> tryGoDown()
            Action.GoLeft -> tryGoLeft()
            Action.GoRight -> tryGoRight ()
        }
    }

    fun doActions(){
        for (action in actionList){
            tryActionOrException(action)
        }
    }

    fun winOrLost(){
        doActions()
        if(actualPositionPlayer.posX == levelToCheck.finishPosition().posX
                && actualPositionPlayer.posY == levelToCheck.finishPosition().posY ){

            levelToCheckState = LevelState.Complete
        }
    }

}