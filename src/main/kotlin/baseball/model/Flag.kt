package baseball.model

class Flag {
    private var _flag: Boolean? = null

    val flag: Boolean?
        get() = _flag

    fun setFlag(input: String) {
        if (input.trim() == "1") this._flag = true
        if (input.trim() == "2") this._flag = false
    }
}