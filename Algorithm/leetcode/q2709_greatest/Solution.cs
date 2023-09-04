namespace Algorithm.leetcode.q2709_greatest;

public class Solution
{
    private readonly int[] _primes = new int[100010];
    private readonly HashSet<int> _set = new();

    public bool CanTraverseAllPairs(int[] nums)
    {
        foreach (var num in nums)
        {
            if (num == 1) return nums.Length == 1;

            int tNum = num;
            int lst = 1;
            for (int j = 2; j <= Math.Sqrt(tNum); j++)
            {
                if (tNum % j == 0)
                {
                    if (_primes[j] == 0)
                    {
                        _primes[j] = j;
                        _set.Add(j);
                    }

                    if (lst != 1)
                    {
                        Merge(lst, j);
                    }

                    lst = j;
                    while (tNum % j == 0) tNum /= j;
                }
            }

            if (tNum > 1)
            {
                if (_primes[tNum] == 0)
                {
                    _primes[tNum] = tNum;
                    _set.Add(tNum);
                }

                if (lst != 1)
                {
                    Merge(lst, tNum);
                }
            }
        }

        return _set.Count == 1;
    }

    private int Find(int x) => _primes[x] == x ? _primes[x] : _primes[x] = Find(_primes[x]);

    private void Merge(int a, int b)
    {
        if (a < b)
        {
            a ^= b;
            b ^= a;
            a ^= b;
        }

        _set.Remove(Find(b));
        _primes[Find(b)] = Find(a);
        _set.Add(Find(a));
    }
}