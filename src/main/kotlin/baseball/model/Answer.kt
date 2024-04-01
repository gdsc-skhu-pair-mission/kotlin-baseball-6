package baseball.model

class Answer {
    private var _ballCount = 0
    private var _strikeCount = 0

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
}