package leetcode.q18_4sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = 4;
        int[][] numGroups = sample(nums, n);
        return nSum(numGroups, n, target);
    }

    /**
     * @param numGroups sorted grouped array
     */
    private List<List<Integer>> nSum(int[][] numGroups, int n, int target) {
        HashSet<Integer> tupleHashes = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        nSum(numGroups, 0, target, new int[n], tupleHashes, result);
        return result;
    }

    private void nSum(int[][] numGroups, int k, int target, int[] usedIndexes, Set<Integer> tupleHashes, List<List<Integer>> result) {
        // TODO 去重，不足n个元素也要去重

        if (k == usedIndexes.length) {
            if (target == 0) {
                int[] tuple = Arrays.stream(usedIndexes).map(index -> numGroups[index][0]).sorted().toArray();
                int hash = getHash(tuple);
                if (!tupleHashes.contains(hash)) {
                    tupleHashes.add(hash);
                    result.add(Arrays.stream(tuple).boxed().collect(Collectors.toList()));
                }
            }
            return;
        }

        int closestIndex = binarySearchClosest(numGroups, target / (usedIndexes.length - k));
        IntStream.range(0, numGroups.length)
                .map(index -> getSwingIndex(closestIndex, numGroups.length, index))
                .filter(index -> numGroups[index][1] > 0)
                .forEach(index -> {
                    numGroups[index][1]--;
                    usedIndexes[k] = index;
                    nSum(numGroups, k + 1, target - numGroups[index][0], usedIndexes, tupleHashes, result);
                    numGroups[index][1]++;
                    //                    usedIndexes[k] = 0;
                });
    }

    /**
     * @return int[][] 把nums从小到大排序，return[0] < return[1]; 对每个 return[i]，有return[i][0]为数值，return[i][1]为重复的次数
     * 对于n数之和，最多重复n次。
     */
    static int[][] sample(int[] nums, int n) {
        Arrays.sort(nums);// todo 可优化

        List<int[]> list = new ArrayList<>();
        int[] lastNumGroup = null;
        for (int num : nums) {
            if (lastNumGroup == null) {
                lastNumGroup = new int[]{num, 1};
                list.add(lastNumGroup);
            } else if (lastNumGroup[0] != num) {
                lastNumGroup = new int[]{num, 1};
                list.add(lastNumGroup);
            } else {
                int count = lastNumGroup[1];
                if (count < n) {
                    lastNumGroup[1] = count + 1;
                }
            }
        }
        return list.toArray(int[][]::new);
    }

    static int binarySearchClosest(int[][] arrayGroup, int key) {
        return binarySearchClosest0(arrayGroup, 0, arrayGroup.length, key);
    }

    static int binarySearchClosest(int[][] arrayGroup, int fromIndex, int toIndex, int key) {
        // todo 后续可以替代成这个，不一定要从头开始二分查找
        return binarySearchClosest0(arrayGroup, fromIndex, toIndex, key);
    }

    /**
     * java.util.Arrays.binarySearch( int[],int)
     */
    private static int binarySearchClosest0(int[][] arrayGroup, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int mid = -(low + 1);
        while (low <= high) {
            mid = low + high >>> 1;
            int midVal = arrayGroup[mid][0];
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

    private int getHash(int[] tuple) {
        int hash = tuple[0];
        for (int i = 1; i < tuple.length - 1; i++) {
            hash = hash * 31 + tuple[i]; // todo 31?
        }
        return hash;
    }
}