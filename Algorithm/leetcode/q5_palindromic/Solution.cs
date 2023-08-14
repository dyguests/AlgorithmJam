namespace Algorithm.leetcode.q5_palindromic;

public class Solution
{
    public string LongestPalindrome(string str)
    {
        var result = "";
        for (var i = 0; i < str.Length; i++)
        {
            for (var j = i; j < str.Length; j++)
            {
                if (j - i + 1 <= result.Length) continue;

                var matched = true;
                for (int k = 0; k <= (j - i) / 2; k++)
                {
                    if (str[i + k] != str[j - k])
                    {
                        matched = false;
                        break;
                    }
                }

                if (matched)
                {
                    result = str.Substring(i, j - i + 1);
                }
            }
        }

        return result;
    }
}