namespace Algorithm.leetcode.q2709_greatest;

public class Solution
{
    public bool CanTraverseAllPairs(int[] nums)
    {
        var factorss = new HashSet<HashSet<int>>();
        foreach (var num in nums)
        {
            var factors = Factorize(num);
            var matchedFactorss = factorss.Where(factors2 => factors2.Any(factor2 => factors.Any(factor => factor == factor2))).ToList();
            if (matchedFactorss.Any())
            {
                var matchedFactors = matchedFactorss.SelectMany(factors2 => factors2).ToHashSet();
                matchedFactors.UnionWith(factors);
                foreach (var matchedFactors2 in matchedFactorss)
                {
                    factorss.Remove(matchedFactors2);
                }

                factorss.Add(matchedFactors);
            }
            else
            {
                factorss.Add(factors);
            }
        }

        return factorss.Count == 1;
    }

    private HashSet<int> Factorize(int num)
    {
        var factors = new HashSet<int>();
        var sqrt = (int)Math.Sqrt(num);
        for (int i = 2; i <= sqrt; i++)
        {
            if (num % i == 0)
            {
                factors.Add(i);
                factors.Add(num / i);
            }
        }

        factors.Add(num);

        return factors;
    }
}