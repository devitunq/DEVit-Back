package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Key", key = "type")
class Key(override var position: Position? = null) : LevelElement {
}