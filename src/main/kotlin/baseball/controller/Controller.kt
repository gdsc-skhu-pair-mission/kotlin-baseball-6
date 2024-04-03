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
    private val user = User()
    private val number = Number()
    private val answer = Answer()
    private val flag = Flag()

    fun game() {
        outputView.printStartMessage()
        while (flag.flag) {
            playRound()
        }
    }

    private fun playRound() {
        processGame()
        if (answer.strikeCount == WIN_COUNT) {
            exitGame()
        }
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

    private fun getGameFlag() {
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

    private fun showResult() {
        val ball = answer.ballCount
        val strike = answer.strikeCount
        outputView.printResultMessage(ball, strike)
    }

    private fun getUserNumber() {
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

    private fun calculate() {
        val number = number.number
        val input = user.input
        answer.initCount()
        answer.calculateResult(number, input!!)
    }
}