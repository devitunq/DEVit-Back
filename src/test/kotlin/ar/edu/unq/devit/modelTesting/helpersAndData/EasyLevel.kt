package ar.edu.unq.devit.modelTesting.helpersAndData

import ar.edu.unq.devit.model.*

class EasyLevel{

    var levelOneElementsList = mutableListOf<LevelElement>()

    var player = Player(Position(1,1))

    var finish = Finish(Position(4,4))

    var tile01 = PathTile(Position(0,1))
    var tile02 = PathTile(Position(0,2))
    var tile11 = PathTile(Position(1,1))
    var tile12 = PathTile(Position(1,2))
    var tile13 = PathTile(Position(1,3))
    var tile21 = PathTile(Position(2,1))
    var tile23 = PathTile(Position(2,3))
    var tile24 = PathTile(Position(2,4))
    var tile31 = PathTile(Position(3,1))
    var tile32 = PathTile(Position(3,2))
    var tile34 = PathTile(Position(3,4))
    var tile42 = PathTile(Position(4,2))
    var tile43 = PathTile(Position(4,3))
    var tile44 = PathTile(Position(4,4))

    var levelTest = Level()

    fun dataInitialize() {
        levelOneElementsList.add(player)
        levelOneElementsList.add(finish)
        levelOneElementsList.add(tile01)
        levelOneElementsList.add(tile02)
        levelOneElementsList.add(tile11)
        levelOneElementsList.add(tile12)
        levelOneElementsList.add(tile13)
        levelOneElementsList.add(tile21)
        levelOneElementsList.add(tile23)
        levelOneElementsList.add(tile24)
        levelOneElementsList.add(tile31)
        levelOneElementsList.add(tile32)
        levelOneElementsList.add(tile34)
        levelOneElementsList.add(tile42)
        levelOneElementsList.add(tile43)
        levelOneElementsList.add(tile44)

        levelTest.elements = levelOneElementsList

    }
}