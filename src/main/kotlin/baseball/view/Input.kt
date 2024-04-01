package baseball.view

import baseball.util.Validator.validateFlag
import baseball.util.Validator.validateNumber
import camp.nextstep.edu.missionutils.Console

class Input {
    private fun getUserInput(): String = Console.readLine()

    fun getNumber(): Int { //숫자 입력
        val input = getUserInput()
        validateNumber(input)
        return input.toInt()
    }

    fun getFlag(): Int { //게임 플래그 숫자 입력
        val input = getUserInput()
        validateFlag(input)
        return input.toInt()
    }
}