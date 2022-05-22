package leetcode.q70_climbing_stairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun climbStairs_1() = validate(2, 2)

    @Test
    fun climbStairs_2() = validate(3, 3)

    private fun validate(n: Int, expected: Int) {
        assertEquals(expected, Solution().climbStairs(n))
    }
}