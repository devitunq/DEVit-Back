package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Finish", key = "type")
class Finish : LevelElement {
    override var position: Position? = null
}