package leetcode.q9_palindrome_number

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val arr = mutableListOf<Int>()
        var x_ = x
        while (x_ > 0) {
            arr.add(x_ % 10)
            x_ /= 10
        }
        val size = arr.size
        for (i in 0 until size / 2) {
            if (arr[i] != arr[size - 1 - i]) {
                return false
            }
        }
        return true
    }
}