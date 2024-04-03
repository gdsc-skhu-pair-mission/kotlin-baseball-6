package baseball.model

import baseball.dto.AnswerDTO
import baseball.util.Constants.WIN_COUNT
import baseball.util.Constants.ZERO

class Answer(private var _ballCount: Int = ZERO, private var _strikeCount: Int = ZERO) {

    fun checkAnswer(): Boolean {
        return _strikeCount == WIN_COUNT
    }

    fun calculateResult(number: Number, user: User) {
        val answer = number.number
        val input = user.input!!
        for (i in answer.indices) {
            calculateBall(answer, input, i)
            calculateStrike(answer, input, i)
        }
    }

    fun createDTO(): AnswerDTO {
        return AnswerDTO(ballCount = _ballCount, strikeCount = _strikeCount)
    }

    private fun calculateBall(answer: String, input: String, index: Int) {
        if (answer[index] != input[index] && input[index] in answer) {
            _ballCount++
        }
    }

    private fun calculateStrike(answer: String, input: String, index: Int) {
        if (answer[index] == input[index]) {
            _strikeCount++
        }
    }

    companion object {
        fun initCount(): Answer {
            return Answer(0, 0)
        }
    }
}