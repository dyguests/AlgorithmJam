using System.Text;

namespace Algorithm.leetcode.q60_permutation;

public class Solution
{
    public string GetPermutation(int n, int k)
    {
        k--; // 中文第k个，转成编程语言第k-1个
        var numbers = Enumerable.Range(1, n).ToList();
        var result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--)
        {
            var ani = Factorial(i);
            var quotient = k / ani;
            k %= ani;
            result.Append(numbers[quotient]);
            numbers.RemoveAt(quotient);
        }

        return result.ToString();
    }

    private int Factorial(int n)
    {
        int result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }

        return result;
    }
}