package leetcode.q70_climbing_stairs

/**
 * 两数之和
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author fanhl
 */
class Solution {
    fun climbStairs(n: Int): Int {
        if (n < 3) return n
        var p = 2
        val kinds = arrayOf(1, 2)
        while (p < n) {
            kinds[p % 2] += kinds[(p - 1) % 2]
            p++
        }
        return kinds[(p - 1) % 2]
    }
}