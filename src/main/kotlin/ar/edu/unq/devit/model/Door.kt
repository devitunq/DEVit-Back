package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Door", key = "type")
class Door : Obstruction {
    override var position: Position? = null
}