package baseball.view

import baseball.util.Validator.validateFlag
import baseball.util.Validator.validateNumber
import camp.nextstep.edu.missionutils.Console

class Input {
    private fun getUserInput(): String = Console.readLine()

    fun getNumber(): String { //숫자 입력
        val input = getUserInput()
        validateNumber(input)
        return input
    }

    fun getFlag(): String { //게임 플래그 숫자 입력
        val input = getUserInput()
        validateFlag(input)
        return input
    }
}