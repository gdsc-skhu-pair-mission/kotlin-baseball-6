package baseball.view

import baseball.util.Constants.BALL_MESSAGE
import baseball.util.Constants.FAIL_MESSAGE
import baseball.util.Constants.INPUT_MESSAGE
import baseball.util.Constants.RESTART_MESSAGE
import baseball.util.Constants.START_MESSAGE
import baseball.util.Constants.STRIKE_MESSAGE
import baseball.util.Constants.SUCCESS_MESSAGE

class Output {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printInputMessage() {
        print(INPUT_MESSAGE)
    }

    fun printResultMessage(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) {
            println(FAIL_MESSAGE)
            return
        }
        if (ball > 0 && strike > 0) {
            println("${ball}${BALL_MESSAGE} ${strike}${STRIKE_MESSAGE}")
            return
        }
        if (ball > 0) {
            println("${ball}${BALL_MESSAGE}")
            return
        }
        println("${strike}${STRIKE_MESSAGE}")
    }

    fun printEndMessage() {
        println(SUCCESS_MESSAGE)
        println(RESTART_MESSAGE)
    }
}