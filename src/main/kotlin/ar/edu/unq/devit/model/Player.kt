package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonProperty


@BsonDiscriminator(value = "Player", key = "type")
class Player : LevelElement {

    override var position: Position? = null
    var keys : MutableList<Key> = mutableListOf()

    constructor()

    constructor(position: Position){
        this.position = position
        this.keys = emptyList<Key>().toMutableList()
    }

}