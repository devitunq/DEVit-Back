package ar.edu.unq.devit.model

enum class Action {
    GoUp { override fun invoke(checker: LevelChecker) { checker.actualPositionPlayer = checker.actualPositionPlayer!!.up() } },
    GoDown { override fun invoke(checker: LevelChecker) { checker.actualPositionPlayer = checker.actualPositionPlayer!!.down() } },
    GoLeft { override fun invoke(checker: LevelChecker) { checker.actualPositionPlayer = checker.actualPositionPlayer!!.left() }},
    GoRight { override fun invoke(checker: LevelChecker) { checker.actualPositionPlayer = checker.actualPositionPlayer!!.right() }};

    abstract operator fun invoke(checker: LevelChecker)
}