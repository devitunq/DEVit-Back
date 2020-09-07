package ar.edu.unq.devit.model

import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Key", key = "type")
class Key : LevelElement {
    override var position: Position? = null
}