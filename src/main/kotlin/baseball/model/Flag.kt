package baseball.model

import baseball.util.Constants.END_FLAG
import baseball.util.Constants.START_FLAG

class Flag {
    private var _flag: Boolean

    val flag: Boolean
        get() = _flag

    init {
        _flag = true
    }

    fun setFlag(input: String) {
        if (input.trim() == START_FLAG) this._flag = true
        if (input.trim() == END_FLAG) this._flag = false
    }
}