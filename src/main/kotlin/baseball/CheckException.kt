package baseball

fun validateExceptionOnInput(input: String) {
    isEmpty(input)
    isInteger(input)
    isContainsDuplicated(input)
    isCorrectNumberOfDigit(input)
}

fun isEmpty(input: String) {
    require(input.isNotEmpty()) { "아무것도 입력하지 않았습니다. 숫자를 입력해주세요." }
}

fun isInteger(input: String) {
    try{
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자를 입력해주세요.")
    }
}

fun isContainsDuplicated(input: String) {
    for (i in input) {
       require(input.count { it == i } == 1) { "중복된 숫자를 입력하셨습니다. 중복되지 않는 숫자를 입력해주세요." }
    }
}

fun isCorrectNumberOfDigit(input: String) {
    require(input.length == NUMBER_OF_DIGITS) { "규칙에 맞지 않는 길이의 숫자를 입력하였습니다. 세 자리 숫자를 입력해주세요." }
}