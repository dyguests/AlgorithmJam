package leetcode.q18_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int target) {
        Arrays.sort(nums);
        //        java.util.Arrays.binarySearch( int[],int)
        int i = binarySearchClosest(nums, target / n);
        return new ArrayList<>();
    }

    private static int binarySearchClosest(int[] array, int key) {
        return binarySearchClosest0(array, 0, array.length, key);
    }

    private static int binarySearchClosest(int[] array, int fromIndex, int toIndex, int key) {
        return binarySearchClosest0(array, fromIndex, toIndex, key);
    }

    private static int binarySearchClosest0(int[] array, int fromIndex, int toIndex, int key) {
        return 0;
    }
}