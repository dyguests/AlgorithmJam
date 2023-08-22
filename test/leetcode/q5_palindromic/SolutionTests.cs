using Algorithm.leetcode.q5_palindromic;

namespace Test.leetcode.q5_palindromic;

public class SolutionTests
{
    [SetUp]
    public void Setup()
    {
    }

    /// <summary>
    /// 输入：s = "babad"
    /// 输出："bab"
    /// 解释："aba" 同样是符合题意的答案。
    /// </summary>
    [Test]
    public void Test1() => Check("babad", "bab", "aba");

    /// <summary>
    /// 输入：s = "cbbd"
    /// 输出："bb"
    /// </summary>
    [Test]
    public void Test2() => Check("cbbd", "bb");

    [Test]
    public void Test3() => Check("a", "a");

    [Test]
    public void Test4() => Check("", "");

    private static void Check(string input, params string[] expectedArray)
    {
        Assert.That(new Solution().LongestPalindrome(input), Is.AnyOf(expectedArray));
    }
}