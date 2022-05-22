package leetcode.q7_Reverse_Integer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun reverse_1() = validate(123, 321)

    @Test
    fun reverse_2() = validate(-123, -321)

    @Test
    fun reverse_3() = validate(120, 21)

    @Test
    fun reverse_4() = validate(0, 0)

    private fun validate(x: Int, expected: Int) {
        assertEquals(expected, Solution().reverse(x))
    }
}