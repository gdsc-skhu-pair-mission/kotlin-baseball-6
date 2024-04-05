package baseball

fun validateExceptionOnInput(input: String) {
    requireNonEmpty(input)
    requireInteger(input)
    requireNoDuplicates(input)
    requireCorrectNumberOfDigits(input)
}

fun requireNonEmpty(input: String) {
    require(input.isNotEmpty()) { "아무것도 입력하지 않았습니다. 숫자를 입력해주세요." }
}

fun requireInteger(input: String) {
    require(input.toIntOrNull() != null) { "정수를 입력해주세요." }
}

fun requireNoDuplicates(input: String) {
    for (i in input) {
        require(input.count { it == i } == 1) { "중복된 숫자를 입력하였습니다. 중복되지 않는 숫자를 입력해주세요." }
    }
}

fun requireCorrectNumberOfDigits(input: String) {
    require(input.length == NUMBER_OF_DIGITS) { "규칙에 맞지 않는 숫자를 입력하였습니다. ${NUMBER_OF_DIGITS}자리 숫자를 입력해주세요." }
}
