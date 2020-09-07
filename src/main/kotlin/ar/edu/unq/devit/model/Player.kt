package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator


@BsonDiscriminator(value = "Player", key = "type")
class Player : LevelElement {

    override var position: Position? = null
    var keys : MutableList<Key> = mutableListOf()

}