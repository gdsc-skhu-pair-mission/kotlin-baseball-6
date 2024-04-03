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
    private val number = Number()
    private var user = User()
    private var answer = Answer()
    private var flag = Flag()

    fun game() {
        outputView.printStartMessage()
        while (flag.checkFlag()) {
            playRound()
        }
    }

    private fun playRound() {
        processGame()
        if (answer.checkAnswer()) {
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
        if(flag.checkFlag()) {
            number.generateNumber()
        }
    }

    private fun getGameFlag() {
        var isValid = false
        while(!isValid) {
            try {
                val input = inputView.getFlag()
                flag = Flag.changeFlag(input)
                isValid = true
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun showResult() {
        val count = answer.createDTO()
        outputView.printResultMessage(count.ballCount, count.strikeCount)
    }

    private fun getUserNumber() {
        var isValid = false
        while(!isValid) {
            try {
                val input = inputView.getNumber()
                user = User.changeInput(input)
                isValid = true
            } catch(e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun calculate() {
        answer = Answer.initCount()
        answer.calculateResult(number, user)
    }
}