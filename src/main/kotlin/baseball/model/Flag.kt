package baseball.model

import baseball.util.Constants.END_FLAG
import baseball.util.Constants.START_FLAG

class Flag(private var _isRunning: Boolean = true) {

    fun checkFlag(): Boolean {
        return _isRunning
    }

    companion object {
        fun changeFlag(input: String): Flag {
            return when (input.trim()) {
                START_FLAG -> Flag(true)
                END_FLAG -> Flag(false)
                else -> Flag()
            }
        }
    }
}