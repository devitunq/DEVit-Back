package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Door", key = "type")
class Door(override var position: Position? = null, var isOpen: Boolean = false) : Obstruction {
}