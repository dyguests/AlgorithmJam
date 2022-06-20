package leetcode.q18_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, target);
    }

    //        java.util.Arrays.binarySearch( int[],int)

    /**
     * @param nums sorted array
     */
    private List<List<Integer>> nSum(int[] nums, int n, int target) {
        HashSet<Integer> usedIndexes = new HashSet<>();
        int remainder = target;
        for (int k = n; k > 0; k--) {
            int indexOfNums = binarySearchClosest(nums, remainder / k);
            //            swingTraversal(nums, indexOfNums, index ->)
        }
        return new ArrayList<>();
    }

    public static int binarySearchClosest(int[] array, int key) {
        return binarySearchClosest0(array, 0, array.length, key);
    }

    private static int binarySearchClosest(int[] array, int fromIndex, int toIndex, int key) {
        return binarySearchClosest0(array, fromIndex, toIndex, key);
    }

    private static int binarySearchClosest0(int[] array, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int mid = -(low + 1);
        while (low <= high) {
            mid = low + high >>> 1;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal <= key) {
                    return mid;
                }

                high = mid - 1;
            }
        }

        return mid;
    }
}