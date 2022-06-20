package leetcode.q18_4sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Map<String, List<Integer>> result = new HashMap<>();
        nSum(nums, n, target, new HashSet<>(), result);
        return new ArrayList<>(result.values());
    }

    private void nSum(int[] nums, int n, int target, HashSet<Integer> usedIndexes, Map<String, List<Integer>> result) {
        // TODO 去重，不足n个元素也要去重

        if (n == 0) {
            if (target == 0) {
                List<Integer> tuple = usedIndexes.stream().map(index -> nums[index]).sorted().collect(Collectors.toList());
                String key = tuple.stream().map(Object::toString).collect(Collectors.joining());
                result.putIfAbsent(key, tuple);
            }
            return;
        }

        int closestIndex = binarySearchClosest(nums, target / n);
        IntStream.range(0, nums.length)
                .map(index -> getSwingIndex(closestIndex, nums.length, index))
                .filter(index -> !usedIndexes.contains(index))
                .forEach(index -> {
                    usedIndexes.add(index);
                    nSum(nums, n - 1, target - nums[index], usedIndexes, result);
                    usedIndexes.remove(index);
                });
    }

    static int binarySearchClosest(int[] array, int key) {
        return binarySearchClosest0(array, 0, array.length, key);
    }

    static int binarySearchClosest(int[] array, int fromIndex, int toIndex, int key) {
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

    /**
     * 从总长度为length的array中，取得从closestIndex开始的第index个swingIndex
     * <p>
     * 这是一个类似fori的索引遍历，依次取closestIndex, start+1, start-1, start+2, start-2, ...
     * <p>
     * 例： 当 start=2, length=7, index从0取值到6时，返回值分别为： 2,3,1,4,0,5,6
     */
    static int getSwingIndex(int start, int length, int index) {
        if (index > start * 2) {
            return index;
        }
        if (index > (length - 1 - start) * 2) {
            return length - 1 - index;
        }
        return start + (((index & 1) == 1) ? 1 : -1) * ((index + 1) / 2);
    }
}