package racingcar.view

import racingcar.model.Car
import racingcar.util.Message

object OutputView {

    fun outputStartGame() {
        println()
        println(Message.RESULT_START)
    }

    fun outputRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            println(Message.ROUND_RESULT.format(car.getName(), PROGRESS_BAR.repeat(car.getStep())))
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Message.FINAL_WINNERS.format(winners.joinToString(", ")))
    }

    private const val PROGRESS_BAR = "-"
}
