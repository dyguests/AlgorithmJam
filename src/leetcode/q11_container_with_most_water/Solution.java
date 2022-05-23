package leetcode.q11_container_with_most_water;

class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int w;
        int h;
        int capacity = 0;

        while (l < r) {
            w = r - l;
            int lH = heights[l];
            int rH = heights[r];
            if (lH > rH) {
                h = rH;
                r--;
            } else if (lH < rH) {
                h = lH;
                l++;
            } else {
                h = lH;
                l++;
                r--;
            }
            int capacity_ = w * h;
            if (capacity_ > capacity) capacity = capacity_;
        }

        return capacity;
    }

}