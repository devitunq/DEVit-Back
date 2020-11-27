package ar.edu.unq.devit.model.levelElements

import ar.edu.unq.devit.model.Position
import org.bson.codecs.pojo.annotations.BsonDiscriminator

@BsonDiscriminator(value = "Conceal", key = "type")
class Conceal(override var position: Position? = null, var hiddenElement: Key? = null) : LevelElement
