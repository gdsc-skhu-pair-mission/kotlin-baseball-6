package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Number {
    private lateinit var _number: String

    val number: String
        get() = _number

    init {
        generateNumber()
    }

    fun generateNumber() {
        val number = mutableListOf<Int>()
        while(number.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in number) {
                number.add(randomNumber)
            }
        }
        _number = number.joinToString("")
    }
}