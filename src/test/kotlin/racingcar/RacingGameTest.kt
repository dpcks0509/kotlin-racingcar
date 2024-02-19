package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.util.Constant
import racingcar.util.MoveStrategy

class RacingGameTest {
    @Test
    fun `올바른 자동차 전진 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.STANDARD_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        assertThat(cars.all { car -> car.position == 1 }).isTrue
    }

    @Test
    fun `올바르지 않은 자동차 전진 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.MIN_RANDOM_NUMBER, Constant.STANDARD_RANDOM_NUMBER - 1))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        assertThat(cars.all { car -> car.position == 0 }).isTrue
    }

    @Test
    fun `전진 가능할 때 올바른 최종 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.STANDARD_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners.all { winner -> winner.position == 1 }).isTrue
    }

    @Test
    fun `전진 가능할 때 올바르지 않은 최종 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.STANDARD_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners.all { winner -> winner.position == 0 }).isFalse
    }

    @Test
    fun `전진 가능하지 않을때 올바른 최종 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.MIN_RANDOM_NUMBER, Constant.STANDARD_RANDOM_NUMBER - 1))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners.all { winner -> winner.position == 0 }).isTrue
    }

    @Test
    fun `전진 가능하지 않을때 올바르지 않은 최종 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val moveStrategy = MoveStrategy(Pair(Constant.MIN_RANDOM_NUMBER, Constant.STANDARD_RANDOM_NUMBER - 1))
        val racingGame = RacingGame(
            cars = cars,
            moveStrategy = moveStrategy
        )
        racingGame.racingCars()

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners.all { winner -> winner.position == 1 }).isFalse
    }
}
