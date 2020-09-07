package ar.edu.unq.devit.dao

import ar.edu.unq.devit.model.Level

class LevelMongoDAO: GenericMongoDAO<Level>(Level::class.java)