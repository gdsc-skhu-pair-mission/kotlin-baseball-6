package baseball.controller

import baseball.model.Answer
import baseball.model.Flag
import baseball.model.Number
import baseball.model.User
import baseball.util.Constants.WIN_COUNT
import baseball.view.Input
import baseball.view.Output

class Controller(
    private val inputView: Input,
    private val outputView: Output,
) {
    private var user = User()
    private var number = Number()
    private var answer = Answer()
    private var flag = Flag()

    fun game() {
        outputView.printStartMessage()
        do {
            processGame()
            if (answer.strikeCount == WIN_COUNT) {
                exitGame()
            }
        } while (flag.flag)
    }

    private fun processGame() {
        outputView.printInputMessage()
        getUserNumber()
        calculate()
        showResult()
    }

    private fun exitGame() {
        outputView.printEndMessage()
        getGameFlag()
        if(flag.flag) {
            number.generateNumber()
        }
    }

    private fun getGameFlag() { //게임 플래그 입력
        var isValid = false
        while(!isValid) {
            try {
                val input = inputView.getFlag()
                flag.setFlag(input)
                isValid = true
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun showResult() { //매칭 결과 출력
        val ball = answer.ballCount
        val strike = answer.strikeCount
        outputView.printResultMessage(ball, strike)
    }

    private fun getUserNumber() { //사용자 입력
        var isValid = false
        while(!isValid) {
            try {
                val input = inputView.getNumber()
                user.setInput(input)
                isValid = true
            } catch(e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun calculate() { //매칭 결과 계산
        val number = number.number
        val input = user.input
        answer.initCount()
        answer.calculateResult(number, input!!)
    }
}