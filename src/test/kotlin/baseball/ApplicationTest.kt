package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun 세_자리가_아닌_숫자_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun 문자_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("가나다") }
        }
    }

    @Test
    fun 중복된_숫자_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("111") }
        }
    }

    @Test
    fun 음수_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-123") }
        }
    }

    @Test
    fun 소수_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("123.123") }
        }
    }

    @Test
    fun 공백_문자_입력_시_예외_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun 아무것도_입력하지_않은_경우_예외_테스트() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { checkExceptionOnInput("") }
            assertEquals("아무것도 입력하지 않았습니다. 숫자를 입력해주세요.", exception.message)
        }
    }


    override fun runMain() {
        main()
    }
}
