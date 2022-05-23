package leetcode.q9_palindrome_number

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun isPalindrome_1() = validate(121, true)

    @Test
    fun isPalindrome_2() = validate(-121, false)

    @Test
    fun isPalindrome_3() = validate(10, false)

    private fun validate(x: Int, expected: Boolean) {
        assertEquals(expected, Solution().isPalindrome(x))
    }
}