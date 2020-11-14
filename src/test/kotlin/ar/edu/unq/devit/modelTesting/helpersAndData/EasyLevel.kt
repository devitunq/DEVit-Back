package ar.edu.unq.devit.modelTesting.helpersAndData

import ar.edu.unq.devit.model.*
import ar.edu.unq.devit.model.Level
import ar.edu.unq.devit.model.levelElements.Finish
import ar.edu.unq.devit.model.levelElements.LevelElement
import ar.edu.unq.devit.model.levelElements.PathTile
import ar.edu.unq.devit.model.levelElements.Player

class EasyLevel{

    var player = Player(Position(1, 1))

    var finish = Finish(Position(4, 4))

    var tile01 = PathTile(Position(0, 1))
    var tile02 = PathTile(Position(0, 2))
    var tile11 = PathTile(Position(1, 1))
    var tile12 = PathTile(Position(1, 2))
    var tile13 = PathTile(Position(1, 3))
    var tile21 = PathTile(Position(2, 1))
    var tile23 = PathTile(Position(2, 3))
    var tile24 = PathTile(Position(2, 4))
    var tile31 = PathTile(Position(3, 1))
    var tile32 = PathTile(Position(3, 2))
    var tile34 = PathTile(Position(3, 4))
    var tile42 = PathTile(Position(4, 2))
    var tile43 = PathTile(Position(4, 3))
    var tile44 = PathTile(Position(4, 4))

    var levelOneElementsList = listOf<LevelElement>(
            player,finish,tile01,tile02,tile11,tile12,tile13,tile21,tile23,tile24,tile31,tile32,
            tile34, tile42,tile43,tile44
    ).toMutableList()


    var levelTest = Level(
            Difficulty.Easy,
            "Easy_Level One",
            levelOneElementsList,
            "",
            6
    )
}