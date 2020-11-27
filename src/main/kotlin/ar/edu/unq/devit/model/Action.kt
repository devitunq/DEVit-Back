package ar.edu.unq.devit.model
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
        JsonSubTypes.Type(value = GoUp::class, name = "GoUp"),
        JsonSubTypes.Type(value = GoDown::class, name = "GoDown"),
        JsonSubTypes.Type(value = GoLeft::class, name = "GoLeft"),
        JsonSubTypes.Type(value = GoRight::class, name = "GoRight"),
        JsonSubTypes.Type(value = CollectKey::class, name = "CollectKey"),
        JsonSubTypes.Type(value = OpenDoor::class, name = "OpenDoor"),
        JsonSubTypes.Type(value = DoorCondition::class, name = "DoorCondition"),
        JsonSubTypes.Type(value = KeyCondition::class, name = "KeyCondition"),
        JsonSubTypes.Type(value = Board1Call::class, name = "Board1Call"),
        JsonSubTypes.Type(value = Board2Call::class, name = "Board2Call")
)
interface Action {
    var times : Int
    operator fun invoke(checker: LevelChecker)
}

class GoUp : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        repeat(times) {
            val newPos = checker.actualPositionPlayer!!.up()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, null)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
            checker.addIfValidPosition()
        }
    }
}
class GoDown : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        repeat(times) {
            val newPos = checker.actualPositionPlayer!!.down()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, null)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
            checker.addIfValidPosition()
        }
    }
}
class GoLeft : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        repeat(times) {
            val newPos = checker.actualPositionPlayer!!.left()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, LookingTo.LEFT)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
            checker.addIfValidPosition()
        }
    }
}
class GoRight : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        repeat(times) {
            val newPos = checker.actualPositionPlayer!!.right()
            checker.levelToCheck.tryAndMovePlayer(newPos, checker.lastKnownPlayerPosition!!, LookingTo.RIGHT)
            checker.lastKnownPlayerPosition = checker.actualPositionPlayer
            checker.actualPositionPlayer = newPos
            checker.addIfValidPosition()
        }
    }
}
class CollectKey : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.levelToCheck.collectKey()
        checker.addIfValidPosition()
    }
}
class OpenDoor : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.levelToCheck.openDoor()
        checker.addIfValidPosition()
    }
}
class DoorCondition : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.canTryNextAction = checker.levelToCheck.doorAtPlayer()
        checker.addIfValidPosition()
    }
}
class KeyCondition : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.canTryNextAction = checker.levelToCheck.keyAtPlayer()
        checker.addIfValidPosition()
    }
}
class Board1Call : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.doActions(checker.functionList[0].actionList)
    }
}

class Board2Call : Action {
    override var times: Int = 1
    override fun invoke(checker: LevelChecker) {
        checker.doActions(if (checker.functionList.size == 2) checker.functionList[1].actionList else listOf())
    }
}