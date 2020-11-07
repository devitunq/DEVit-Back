package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonProperty


@BsonDiscriminator(value = "Player", key = "type")
class Player : LevelElement {

    override var position: Position? = null
    var keys : MutableList<Key> = mutableListOf()

    var lookingTo: LookingTo = LookingTo.RIGHT

    constructor()

    constructor(position: Position, keys: MutableList<Key> = mutableListOf(), lookingTo: LookingTo = LookingTo.RIGHT){
        this.position = position
        this.keys = keys
        this.lookingTo = lookingTo
    }

}

enum class LookingTo {
    LEFT,
    RIGHT
}