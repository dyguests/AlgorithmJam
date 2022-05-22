package leetcode.q3_longest_substring_without_repeating_characters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun lengthOfLongestSubstring_1() = validate("abcabcbb", 3)

    @Test
    fun lengthOfLongestSubstring_2() = validate("bbbbb", 1)

    @Test
    fun lengthOfLongestSubstring_3() = validate("pwwkew", 3)

    private fun validate(s: String, result: Int) {
        assertEquals(result, Solution().lengthOfLongestSubstring(s))
    }
}