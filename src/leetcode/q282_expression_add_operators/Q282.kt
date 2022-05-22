package leetcode.q282_expression_add_operators

class Solution {
    fun addOperators(num: String, target: Int): List<String> {

        return findResult(num, 0, num.length, target)
    }

    private fun findResult(num: String, startIndex: Int, endIndex: Int, target: Int): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    enum class Operate(index: Int) {
        Plus(0),
        Minus(1),
        Multi(2),
        /**
         *  A Tenx B = A*10+b
         */
        Tenx(3),
    }
}

fun main() {
    print("1234".subSequence(0, 4))
}