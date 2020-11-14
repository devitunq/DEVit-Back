package ar.edu.unq.devit.model.levelElements

import ar.edu.unq.devit.model.Obstruction
import ar.edu.unq.devit.model.Position
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Door", key = "type")
class Door(override var position: Position? = null, var isOpen: Boolean = false) : Obstruction {
}