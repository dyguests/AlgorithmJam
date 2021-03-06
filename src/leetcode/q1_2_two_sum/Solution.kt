package leetcode.q1_2_two_sum

import java.security.InvalidParameterException

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in (i + 1) until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw InvalidParameterException()
    }
}