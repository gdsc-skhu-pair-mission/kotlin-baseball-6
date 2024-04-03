package baseball.model

import baseball.util.Constants.ZERO

class Answer {
    private var _ballCount = ZERO
    private var _strikeCount = ZERO

    val ballCount: Int
        get() = _ballCount
    val strikeCount: Int
        get() = _strikeCount

    fun calculateResult(answer: String, input: String) {
        for (i in answer.indices) {
            if (answer[i] == input[i]) {
                _strikeCount++
            }
            if (answer[i] != input[i] && input[i] in answer) {
                _ballCount++
            }
        }
    }

    fun initCount() {
        _ballCount = ZERO
        _strikeCount = ZERO
    }
}