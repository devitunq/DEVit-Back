package ar.edu.unq.devit.model


class LevelChecker(var levelToCheck: Level, var actionList: MutableList<Action>) {

    var actualPositionPlayer = levelToCheck.playerPosition()

    var levelToCheckState = LevelState.Incomplete

    private fun tryActionOrException(action: Action){
        //Básicamente estamos llamando al "invoke" con la posición desde la cuál queremos subir, evita el when.. Volver a mirarlo por las dudas mañana.
        val newPlayerPos = action(actualPositionPlayer)
//        var newPlayerPos: Position = when(action){
//            Action.GoUp -> actualPositionPlayer.up()
//            Action.GoDown -> actualPositionPlayer.down()
//            Action.GoLeft -> actualPositionPlayer.left()
//            Action.GoRight -> actualPositionPlayer.right()
//        }

        if(levelToCheck.tilesPositions().contains(newPlayerPos))
            actualPositionPlayer = newPlayerPos!!
        else
            throw Exception("No hay camino por aquí")
    }

    private fun doActions(){
        for (action in actionList)
            tryActionOrException(action)
    }

    fun winOrLost(){
        doActions()
        if(actualPositionPlayer == levelToCheck.finishPosition())
            levelToCheckState = LevelState.Complete
    }

}