package leetcode.q7_Reverse_Integer

/**
 * 反转整数
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * @author fanhl
 */
class Solution {
    fun reverse(x: Int): Int {
        return try {
            Math.abs(x).toString().reversed().toInt() * if (x >= 0) 1 else -1
        } catch (e: NumberFormatException) {
            0
        }
    }
}