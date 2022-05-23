package leetcode.q30_substring_with_concatenation_of_all_words

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val tree = buildTree(words)
        val totalLength = words.map { it.length }.sum()
        return listOf()
    }

    private fun buildTree(words: Array<String>): Node {
        val root = Node('-', 0)
        for (word in words) {
            for (c in word) {
                val hash = getHash(word, c)
//                root.addChild(c, hash)
                // todo 20220523
            }
        }
        return root
    }

    private fun getHash(word: String, c: Char): Long {
        var hash = 0L
        for (c in word) {
            hash = hash * 31 + c.toInt()
        }
        hash = hash * 31 + c.toInt()
        return hash
    }

    data class Node(
            val c: Char,
            val hash: Long
    ) {
        val children: MutableMap<Char, List<Node>> = mutableMapOf()
    }
}