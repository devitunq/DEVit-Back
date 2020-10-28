package ar.edu.unq.devit.model

object StarsSystem {

    fun calculateStars(bestNumberOfMovements: Int, userMovements: Int): Int {
        var starsWon = 0
        when (bestNumberOfMovements  * 100 / userMovements) {
            in 80..100 -> starsWon = 3
            in 70..80 -> starsWon = 2
            in 0..70 -> starsWon = 1
        }
        return starsWon
    }
}