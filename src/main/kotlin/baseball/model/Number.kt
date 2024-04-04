package baseball.model

import baseball.util.Constants.MAX_NUMBER
import baseball.util.Constants.MIN_NUMBER
import baseball.util.Constants.NUMBER_SIZE
import baseball.util.Constants.SEPARATOR
import camp.nextstep.edu.missionutils.Randoms

class Number {
    private lateinit var _randomNumber: String

    val randomNumber: String
        get() = _randomNumber

    init {
        generateNumber()
    }

    fun generateNumber() {
        val number = mutableListOf<Int>()
        while(number.size < NUMBER_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            if (randomNumber !in number) {
                number.add(randomNumber)
            }
        }
        _randomNumber = number.joinToString(SEPARATOR)
    }
}