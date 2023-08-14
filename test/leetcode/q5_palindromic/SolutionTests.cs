using Algorithm.leetcode.q5_palindromic;

namespace Test.leetcode.q5_palindromic;

public class SolutionTests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void Test1()
    {
        Check("babad", "bab");
    }

    private static void Check(string input, string expected)
    {
        Assert.That(new Solution().LongestPalindrome(input), Is.EqualTo(expected));
    }
}