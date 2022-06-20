package leetcode.q219_contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) return true;
            set.add(num);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}