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
        var actual = new Solution().LongestPalindrome("babad");
        Assert.Pass();
    }
}