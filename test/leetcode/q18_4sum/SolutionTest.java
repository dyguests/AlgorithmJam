package leetcode.q18_4sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void fourSum() {
        validateFourSum(new int[]{1, 0, -1, 0, -2, 2}, 0, new int[][]{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}});
    }

    private void validateFourSum(int[] nums, int target, int[][] expected) {
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        assertEquals(expected.length,result.size());
        for (int[] expectedI : expected) {
            for (List<Integer> resultI : result) {
//                assertEquals(expectedI.length,resultI.size());
            }
        }
    }

    @Test
    void binarySearchClosest1() {
        validateBinarySearchClosest(new int[]{1, 2, 3}, 2, 1);
    }

    @Test
    void binarySearchClosest2() {
        validateBinarySearchClosest(new int[]{1, 2, 4, 5}, 3, 2);
    }

    @Test
    void binarySearchClosest3() {
        validateBinarySearchClosest(new int[]{1, 2, 4, 5, 6}, 3, 1);
    }

    private void validateBinarySearchClosest(int[] array, int key, int expected) {
        assertEquals(expected, Solution.binarySearchClosest(array, key));
    }

    @Test
    void getSwingIndex1() {
        int[] index2expected = {
                0, 2,
                1, 3,
                2, 1,
                3, 4,
                4, 0,
                5, 5,
                6, 6,
                7, 7,
        };
        for (int i = 0; i < index2expected.length; i += 2) {
            validateGetSwingIndex(2, 8, index2expected[i], index2expected[i + 1]);
        }
    }

    @Test
    void getSwingIndex2() {
        int[] index2expected = {
                0, 6,
                1, 7,
                2, 5,
                3, 4,
                4, 3,
                5, 2,
                6, 1,
                7, 0,
        };
        for (int i = 0; i < index2expected.length; i += 2) {
            validateGetSwingIndex(6, 8, index2expected[i], index2expected[i + 1]);
        }
    }

    private void validateGetSwingIndex(int closestIndex, int length, int index, int expected) {
        assertEquals(expected, Solution.getSwingIndex(closestIndex, length, index));
    }
}