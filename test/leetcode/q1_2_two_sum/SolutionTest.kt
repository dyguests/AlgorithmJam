package leetcode.q1_2_two_sum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun twoSum_4s_9() = validate(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1))

    @Test
    fun twoSum_3s_6() = validate(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2))

    @Test
    fun twoSum_2s_6() = validate(intArrayOf(3, 3), 6, intArrayOf(0, 1))

    private fun validate(nums: IntArray, target: Int, expected: IntArray) {
        assertArrayEquals(expected, Solution().twoSum(nums, target))
    }
}