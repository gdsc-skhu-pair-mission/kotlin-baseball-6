package baseball.util

enum class Error(private val message: String) {
    INPUT_ERROR("올바르지 않은 입력입니다. 다시 입력해 주세요.\n"),
    LENGTH_ERROR("입력 숫자는 3자리여야 합니다. 다시 입력해 주세요.\n"),
    VALUE_ERROR("0이나 문자는 입력할 수 없습니다. 다시 입력해 주세요.\n"),
    NUMBER_ERROR("1 또는 2를 입력해 주세요.\n"),
    DUPLICATE_ERROR("중복된 숫자가 있습니다. 다시 입력해 주세요.\n");

    fun getMessage(): String = "[ERROR] $message"
}