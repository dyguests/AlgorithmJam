using System.Text;

namespace Algorithm.leetcode.q60_permutation;

public class Solution
{
    public string GetPermutation(int n, int k)
    {
        // var c = A(4, 2);
        // Console.WriteLine($"c:{c}");

        var numbers = Enumerable.Range(1, n).ToList();
        var result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--)
        {
            var ani = A(n, i);
            var quotient = k / ani;
            k %= ani;
            result.Append(numbers[quotient]);
            numbers.RemoveAt(quotient);
        }

        return result.ToString();
    }

    private int A(int a, int b)
    {
        if (a <= b) throw new InvalidOperationException("a<=b");

        if (b * 2 > a) b = a - b;

        int r = 1;
        for (int i = 0; i < b; i++)
        {
            r *= (a - i);
        }

        // for (int i = 2; i <= b; i++)
        // {
        //     r /= i;
        // }

        return r;
    }
}