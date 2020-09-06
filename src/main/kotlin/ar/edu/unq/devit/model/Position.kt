package ar.edu.unq.devit.model

//Revisar los copy, funcionan pero algo no me cierra.
data class Position(var posX: Int, var posY: Int) {
    fun up(): Position = copy(posY = posY+1)
    fun down(): Position = copy(posY = posY-1)
    fun left(): Position = copy(posX = posX-1)
    fun right(): Position = copy(posX = posX+1)
}