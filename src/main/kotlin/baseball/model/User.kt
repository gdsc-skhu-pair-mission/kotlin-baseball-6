package baseball.model

class User {
    private var _input: String? = null

    val input: String?
        get() = _input

    fun setInput(input: String) {
        this._input = input
    }
}