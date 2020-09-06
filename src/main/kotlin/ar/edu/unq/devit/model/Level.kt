package ar.edu.unq.devit.model

class Level {

    var name : String? = null
    var elements: MutableList<LevelElement> = mutableListOf() //Pensar si no separar los "tiles" de los elementos, estaría bien supongo. de momento es una lista de objetos ([Player, Key, Finish, Door, PathTile, PathTile, PathTile, PathTile, PathTile]))
    var description: String? = null

    fun playerPosition(): Position{
        var playerPosition: Position? = null

        var positionFound = false

        var elementsList = this.elements

        while(!positionFound){
            if(elementsList.first() is Player){
                playerPosition = elementsList.first().position
                positionFound = true
            }else{
                elementsList.removeAt(0)
            }
        }

        return playerPosition!!
    }

    fun tilesPositions(): MutableList<Position>{
        var tilesPositions = mutableListOf<Position>()

        for (element in elements){
            if(element is PathTile){
                tilesPositions.add(element.position!!)
            }
        }

        return tilesPositions
    }

    fun finishPosition(): Position{
        var finishPosition: Position? = null

        var positionFound = false

        var elementsList = this.elements

        while(!positionFound){
            if(elementsList.first() is Finish){
                finishPosition = elementsList.first().position
                positionFound = true
            }else{
                elementsList.removeAt(0)
            }
        }

        return finishPosition!!
    }







}