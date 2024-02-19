package racingcar.model

import racingcar.util.MoveStrategy
import racingcar.util.Constant
import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>,
    private val moveStrategy: MoveStrategy
) {
    fun racingCars() {
        cars.forEach { car ->
            racingCar(car = car)
        }
    }

    fun judgeWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        return cars.filter { car ->
            car.position == maxPosition
        }
    }

    private fun racingCar(car: Car) {
        if (moveStrategy.shouldMove()) {
            car.moveCar()
        }
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { car ->
            car.position
        }
    }
}
