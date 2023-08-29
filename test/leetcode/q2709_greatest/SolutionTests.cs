using Algorithm.leetcode.q2709_greatest;

namespace Test.leetcode.q2709_greatest;

public class SolutionTests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void Test1() => Check(new[] { 2, 3, 6 }, true);

    [Test]
    public void Test2() => Check(new[] { 3, 9, 5 }, true);

    [Test]
    public void Test3() => Check(new[] { 4, 3, 12, 8 }, true);

    private static void Check(int[] nums, bool expected)
    {
        Assert.That(new Solution().CanTraverseAllPairs(nums), Is.EqualTo(expected));
    }
}