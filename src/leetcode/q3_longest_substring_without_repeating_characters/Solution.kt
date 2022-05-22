package leetcode.q3_longest_substring_without_repeating_characters

import org.junit.jupiter.api.Test

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = -1
        var r = -1
        val windowChars = HashMap<Char, Int>()

        val sLength = s.length
        var subLength = 0
        while (r < sLength - 1 /*&& l + subLength < sLength*/) {
            val nextCharIndex = r + 1
            val nextChar = s[nextCharIndex]
            val cachedCharIndex = windowChars[nextChar]
            if (cachedCharIndex != null && cachedCharIndex > l) {
                l = cachedCharIndex
                continue
            }
            windowChars[nextChar] = nextCharIndex
            r = nextCharIndex
            subLength = maxOf(subLength, r - l)
        }

        return subLength
    }
}

class Test {
    @Test
    fun test1() {
        printSolution("abcabcbb")
    }

    @Test
    fun test160() {
        //                012345
        printSolution("pwwkew")
    }

    @Test
    fun test423() {
        printSolution("hkcpmprxxxqw")
    }

    private fun printSolution(s: String) {
        println(s + ":" + Solution().lengthOfLongestSubstring(s))
    }
}