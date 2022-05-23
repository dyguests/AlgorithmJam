package leetcode.q765_Couples_Holding_Hands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun minSwapsCouples_1() = validate(intArrayOf(0, 2, 1, 3), 1)

    @Test
    fun minSwapsCouples_2() = validate(intArrayOf(3, 2, 0, 1), 0)

    private fun validate(row: IntArray, expected: Int) {
        assertEquals(expected, Solution().minSwapsCouples(row))
    }
}