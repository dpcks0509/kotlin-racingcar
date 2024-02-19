package racingcar.util

import kotlin.random.Random

class MoveStrategy(private val randomBound: Pair<Int, Int>) {
    fun shouldMove(): Boolean {
        val minRandomNumber = randomBound.first
        val maxRandomNumber = randomBound.second
        return Random.nextInt(minRandomNumber, maxRandomNumber) >= Constant.STANDARD_RANDOM_NUMBER
    }
}
