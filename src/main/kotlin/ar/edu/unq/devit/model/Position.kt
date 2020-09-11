package ar.edu.unq.devit.model

class Position {
    constructor()
    constructor(x: Int, y: Int) {
        posX = x
        posY = y
    }
    var posX: Int = 0
    var posY: Int = 0

    fun up(): Position = Position(posX,  posY-1)
    fun down(): Position = Position(posX,  posY+1)
    fun left(): Position = Position(posX-1, posY)
    fun right(): Position = Position(posX+1, posY)


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (posX != other.posX) return false
        if (posY != other.posY) return false

        return true
    }

    override fun hashCode(): Int {
        var result = posX
        result = 31 * result + posY
        return result
    }


}