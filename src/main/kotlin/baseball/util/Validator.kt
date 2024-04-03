package baseball.util

object Validator {
    fun validateNumber (input: String) { //사용자 입력 유효성 검사
        validateNull(input)
        validateValue(input)
        validateLength(input)
        validateDuplicate(input)
    }

    fun validateFlag (input: String) { //게임 플래그 유효성 검사
        validateNull(input)
        validateInt(input)
        validateRange(input)
    }

    private fun validateNull (input: String) { //null 검사
        require(input.trim().isNotEmpty()) {
            Error.INPUT_ERROR.getMessage()
        }
    }

    private fun validateDuplicate (input: String) { //중복 검사
        require(input.toSet().size == input.length) {
            Error.DUPLICATE_ERROR.getMessage()
        }
    }

    private fun validateLength (input: String) { //자릿수 검사
        require(input.length == 3) {
            Error.LENGTH_ERROR.getMessage()
        }
    }

    private fun validateValue (input: String) { //숫자, 0 포함 유무 검사
        require(input.all { it.isDigit() } && '0' !in input) {
            Error.VALUE_ERROR.getMessage()
        }
    }

    private fun validateInt (input: String) { //숫자 검사
        require(input.all { it.isDigit() }) {
            Error.NUMBER_ERROR.getMessage()
        }
    }

    private fun validateRange (input: String) { //입력 범위 검사
        require(input.toInt() in setOf(1, 2)) {
            Error.NUMBER_ERROR.getMessage()
        }
    }
}