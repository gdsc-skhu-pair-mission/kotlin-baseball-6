package baseball

import baseball.controller.Controller
import baseball.view.Input
import baseball.view.Output

fun main() {
    val controller = Controller(Input(), Output())
    controller.game()
}
