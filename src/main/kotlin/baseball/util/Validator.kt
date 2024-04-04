package baseball.util

object Validator {
    fun validateNumber (input: String) {
        validateNull(input)
        validateValue(input)
        validateLength(input)
        validateDuplicate(input)
    }

    fun validateFlag (input: String) {
        validateNull(input)
        validateInt(input)
        validateRange(input)
    }

    private fun validateNull (input: String) {
        require(input.trim().isNotEmpty()) {
            Error.INPUT_ERROR.getMessage()
        }
    }

    private fun validateDuplicate (input: String) {
        require(input.toSet().size == input.length) {
            Error.DUPLICATE_ERROR.getMessage()
        }
    }

    private fun validateLength (input: String) {
        require(input.length == 3) {
            Error.LENGTH_ERROR.getMessage()
        }
    }

    private fun validateValue (input: String) {
        require(input.all { it.isDigit() } && '0' !in input) {
            Error.VALUE_ERROR.getMessage()
        }
    }

    private fun validateInt (input: String) {
        require(input.all { it.isDigit() }) {
            Error.NUMBER_ERROR.getMessage()
        }
    }

    private fun validateRange (input: String) {
        require(input.toInt() in setOf(1, 2)) {
            Error.NUMBER_ERROR.getMessage()
        }
    }
}