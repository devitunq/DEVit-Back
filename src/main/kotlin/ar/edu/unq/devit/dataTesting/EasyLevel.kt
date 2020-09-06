package ar.edu.unq.devit.dataTesting

import ar.edu.unq.devit.model.*

class EasyLevel{

    var levelOneElementsList = mutableListOf<LevelElement>()

    var player = Player()

    var finish = Finish()

    var tile01 = PathTile()
    var tile02 = PathTile()
    var tile11 = PathTile()
    var tile12 = PathTile()
    var tile13 = PathTile()
    var tile21 = PathTile()
    var tile23 = PathTile()
    var tile24 = PathTile()
    var tile31 = PathTile()
    var tile32 = PathTile()
    var tile34 = PathTile()
    var tile42 = PathTile()
    var tile43 = PathTile()
    var tile44 = PathTile()

    var levelTest = Level()

    fun dataInitialize() {
        player.position = Position(1,1)

        finish.position = Position(4,4)

        tile01.position = Position(0,1)
        tile02.position = Position(0,2)
        tile11.position = Position(1,1)
        tile12.position = Position(1,2)
        tile13.position = Position(1,3)
        tile21.position = Position(2,1)
        tile23.position = Position(2,3)
        tile24.position = Position(2,4)
        tile31.position = Position(3,1)
        tile32.position = Position(3,2)
        tile34.position = Position(3,4)
        tile42.position = Position(4,2)
        tile43.position = Position(4,3)
        tile44.position = Position(4,4)

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