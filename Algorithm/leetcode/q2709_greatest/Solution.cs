namespace Algorithm.leetcode.q2709_greatest;

public class Solution
{
    HashSet<int> st = new HashSet<int>();
    int[] p = new int[100010];

    public bool CanTraverseAllPairs(int[] nums)
    {
        foreach (var i in nums)
        {
            if (i == 1) return nums.Length == 1;
            var tmp = i;
            var lst = 1;
            for (int j = 2; j < Math.Sqrt(tmp); j++)
            {
                if (tmp % j == 0)
                {
                    if (p[j] == 0)
                    {
                        p[j] = j;
                        st.Add(j);
                    }

                    if (lst != 1)
                    {
                        Merge(lst, j);
                    }

                    lst = j;
                    while (tmp % j == 0) tmp /= j;
                }
            }

            if (tmp > 1)
            {
                if (p[tmp] == 0)
                {
                    p[tmp] = tmp;
                    st.Add(tmp);
                }

                if (lst != 1)
                {
                    Merge(lst, tmp);
                }
            }
        }

        return st.Count == 1;
    }

    private void Merge(int a, int b)
    {
        if (a < b)
        {
            a ^= b;
            b ^= a;
            a ^= b;
        }

        st.Remove(Find(b));
        p[Find(b)] = Find(a);
        st.Add(Find(a));
    }

    private int Find(int x)
    {
        return p[x] == x ? p[x] : (p[x] = Find(p[x]));
    }
}