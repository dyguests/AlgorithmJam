package leetcode.q219_contains_duplicate_ii

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    @Test
    fun containsNearbyDuplicate() = validate(intArrayOf(1, 2, 3, 1), 3, true)

    private fun validate(nums: IntArray, k: Int, expected: Boolean) {
        assertEquals(expected, Solution().containsNearbyDuplicate(nums, k))
    }
}