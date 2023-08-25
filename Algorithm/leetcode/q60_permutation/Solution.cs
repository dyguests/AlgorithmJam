using System.Text;

namespace Algorithm.leetcode.q60_permutation;

public class Solution
{
    private static readonly int[] Factorials =
    {
        1,
        1,
        2,
        6,
        24,
        120,
        720,
        5040,
        40320,
    };

    public string GetPermutation(int n, int k)
    {
        k--; // 中文第k个，转成编程语言第k-1个
        var numbers = Enumerable.Range(1, n).ToList();
        var result = new StringBuilder();

        for (var i = n - 1; i >= 0; i--)
        {
            var ani = Factorials[i];
            var quotient = k / ani;
            k -= quotient * ani;
            result.Append(numbers[quotient]);
            numbers.RemoveAt(quotient);
        }

        return result.ToString();
    }
}