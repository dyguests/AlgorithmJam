using Algorithm.leetcode.q60_permutation;

namespace Test.leetcode.q60_permutation;

public class SolutionTests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void Test1() => Check(3, 3, "213");

    [Test]
    public void Test2() => Check(4, 9, "2314");

    [Test]
    public void Test3() => Check(3, 2, "132");

    private static void Check(int n, int k, string expected)
    {
        Assert.That(new Solution().GetPermutation(n, k), Is.EqualTo(expected));
    }
}