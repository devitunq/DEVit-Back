package ar.edu.unq.devit.model

enum class Action {
    GoUp {
        override fun invoke(checker: LevelChecker) {
            val newPos = checker.actualPositionPlayer!!.up()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, null)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
        }
    },
    GoDown {
        override fun invoke(checker: LevelChecker) {
            val newPos = checker.actualPositionPlayer!!.down()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, null)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
        }
    },
    GoLeft {
        override fun invoke(checker: LevelChecker) {
            val newPos = checker.actualPositionPlayer!!.left()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, LookingTo.LEFT)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
        }
    },
    GoRight {
        override fun invoke(checker: LevelChecker) {
            val newPos = checker.actualPositionPlayer!!.right()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, LookingTo.RIGHT)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
        }
    },
    CollectKey {
        override fun invoke(checker: LevelChecker) {
            checker.levelToCheck.collectKey()
        }
    },
    OpenDoor {
        override fun invoke(checker: LevelChecker) {
            checker.levelToCheck.openDoor()
        }
    },
    DoorCondition {
        override fun invoke(checker: LevelChecker) {
            checker.canTryNextAction = checker.levelToCheck.doorAtPlayer()
        }
    },
    KeyCondition {
        override fun invoke(checker: LevelChecker) {
            checker.canTryNextAction = checker.levelToCheck.keyAtPlayer()
        }
    };

    abstract operator fun invoke(checker: LevelChecker)
}
