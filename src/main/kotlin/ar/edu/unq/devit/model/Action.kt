package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

//Eh... No estoy seguro...

enum class Action {
    GoUp { override fun invoke(position: Position): Position = position.up()},
    GoDown { override fun invoke(position: Position): Position = position.down()},
    GoLeft { override fun invoke(position: Position): Position = position.left()},
    GoRight { override fun invoke(position: Position): Position = position.right()};

    abstract operator fun invoke(position: Position): Position
}