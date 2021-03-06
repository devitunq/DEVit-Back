package ar.edu.unq.devit.model.levelElements

import ar.edu.unq.devit.model.Position
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Finish", key = "type")
class Finish : LevelElement {

    override var position: Position? = null

    constructor()

    constructor(position: Position){
        this.position = position
    }
}