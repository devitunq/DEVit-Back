package ar.edu.unq.devit.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
        JsonSubTypes.Type(value = Door::class, name = "door")
        )
@BsonDiscriminator(value = "Obstruction", key = "type")
interface Obstruction : LevelElement