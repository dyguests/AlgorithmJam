namespace Algorithm.leetcode.q5_palindromic;

public class Solution
{
    public string LongestPalindrome(string str)
    {
        var l = str.Length;
        if (l <= 1) return str;
        var offsets = Enumerable.Range(0, l - 1).Select(i => str[i + 1] - str[i]).ToArray();
        var ol = offsets.Length;
        var hollow = new int[ol*2-1,1];
        return "";
    }
}