package baseball.model

class User(private var _input: String? = null) {

    val input: String?
        get() = _input

    companion object {
        fun changeInput(input: String): User {
            return User(input)
        }
    }
}