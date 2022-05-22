package leetcode.q15_3_Sum

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {

    @Test
    fun threeSum_1() = validate(intArrayOf(-1, 0, 1, 2, -1, -4), listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))

    @Test
    fun threeSum_2() = validate(intArrayOf(), listOf())

    @Test
    fun threeSum_3() = validate(intArrayOf(0), listOf())

    private fun validate(nums: IntArray, expected: List<List<Int>>) {
        val actual = Solution().threeSum(nums)
        assertEquals(expected.size, actual.size)
        actual.forEachIndexed(fun(index: Int, list: List<Int>) {
            val actualI = actual[index]
            val expectedI = expected[index]
            assertEquals(actualI, expectedI)
            actualI.forEachIndexed { index, i -> assertEquals(actualI[index], expectedI[index]) }
        })
    }
}