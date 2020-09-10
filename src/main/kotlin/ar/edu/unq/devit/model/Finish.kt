package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonProperty

@BsonDiscriminator(value = "Finish", key = "type")
class Finish : LevelElement {

    override var position: Position? = null

    constructor()

    constructor(position: Position){
        this.position = position
    }
}