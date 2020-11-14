package ar.edu.unq.devit.model.levelElements

import ar.edu.unq.devit.model.Position
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Key", key = "type")
class Key(override var position: Position? = null) : LevelElement {
}