package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "PathTile", key = "type")
class PathTile : LevelElement {
    override var position: Position? = null

    constructor(position: Position){
        this.position = position
    }
}
