package ar.edu.unq.devit.model.levelElements

import ar.edu.unq.devit.model.*
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Player::class, name = "Player"),
    JsonSubTypes.Type(value = Finish::class, name = "Finish"),
    JsonSubTypes.Type(value = Finish::class, name = "Key"),
    JsonSubTypes.Type(value = PathTile::class, name = "PathTile"),
    JsonSubTypes.Type(value = Obstruction::class, name = "Obstruction")
    )
@BsonDiscriminator(key = "type")
interface LevelElement {
    var position : Position?
}