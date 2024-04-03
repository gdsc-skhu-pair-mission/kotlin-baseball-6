package baseball.view

import baseball.util.Constants.BALL_MESSAGE
import baseball.util.Constants.FAIL_MESSAGE
import baseball.util.Constants.INPUT_MESSAGE
import baseball.util.Constants.RESTART_MESSAGE
import baseball.util.Constants.START_MESSAGE
import baseball.util.Constants.STRIKE_MESSAGE
import baseball.util.Constants.SUCCESS_MESSAGE

class Output {
    fun printStartMessage() { //게임 시작 문구 출력
        println(START_MESSAGE)
    }

    fun printInputMessage() { //숫자 입력 문구 출력
        print(INPUT_MESSAGE)
    }

    fun printResultMessage(ball: Int, strike: Int) { //매칭 결과 문구 출력
        when {
            ball == 0 && strike == 0 -> println(FAIL_MESSAGE)
            ball > 0 && strike > 0 -> println("${ball}${BALL_MESSAGE} ${strike}${STRIKE_MESSAGE}")
            ball > 0 -> println("${ball}${BALL_MESSAGE}")
            else -> println("${strike}${STRIKE_MESSAGE}")
        }
    }

    fun printEndMessage() { //게임 종료 및 플래그 입력 문구 출력
        println(SUCCESS_MESSAGE)
        println(RESTART_MESSAGE)
    }
}