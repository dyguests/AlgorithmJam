package leetcode.q18_4sum;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void fourSum1() {
        validateFourSum(new int[]{1, 0, -1, 0, -2, 2}, 0, new int[][]{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}});
    }

    @Test
    void fourSum2() {
        validateFourSum(new int[]{-500, -481, -480, -469, -437, -423, -408, -403, -397, -381, -379, -377, -353, -347, -337, -327, -313, -307, -299, -278, -265, -258, -235, -227, -225, -193, -192, -177, -176, -173, -170, -164, -162, -157, -147, -118, -115, -83, -64, -46, -36, -35, -11, 0, 0, 33, 40, 51, 54, 74, 93, 101, 104, 105, 112, 112, 116, 129, 133, 146, 152, 157, 158, 166, 177, 183, 186, 220, 263, 273, 320, 328, 332, 356, 357, 363, 372, 397, 399, 420, 422, 429, 433, 451, 464, 484, 485, 498, 499}, 2139, new int[][]{});
    }

    @Test
    void fourSum3() {
        validateFourSum(new int[]{-497, -494, -484, -477, -453, -453, -444, -442, -428, -420, -401, -393, -392, -381, -357, -357, -327, -323, -306, -285, -284, -263, -262, -254, -243, -234, -208, -170, -166, -162, -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, -65, -6, 1, 3, 4, 11, 69, 77, 78, 107, 108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 170, 175, 179, 211, 230, 251, 255, 266, 288, 306, 308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 356, 357, 360, 361, 361, 367, 375, 378, 387, 387, 408, 414, 421, 435, 439, 440, 441, 470, 492}, 1682,
                new int[][]{
                        {387, 421, 435, 439},
                        {356, 421, 435, 470},
                        {334, 421, 435, 492},
                        {408, 414, 421, 439},
                        {361, 408, 421, 492},
                        {367, 435, 439, 441},
                        {347, 408, 435, 492},
                        {314, 435, 441, 492},
                        {387, 414, 440, 441},
                        {357, 414, 441, 470},
                        {306, 414, 470, 492},
                        {333, 439, 440, 470},
                        {310, 439, 441, 492},
                        {331, 440, 441, 470},
                        {333, 387, 470, 492},
                }
        );
    }

    private void validateFourSum(int[] nums, int target, int[][] expected) {
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        for (List<Integer> tuple : result) {
            System.out.println(tuple.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        assertEquals(expected.length, result.size());
        for (int[] expectedI : expected) {
            assertTrue(result.stream().anyMatch(resultI -> {
                if (expectedI.length != resultI.size()) {
                    return false;
                }
                for (int i = 0; i < expectedI.length; i++) {
                    if (expectedI[i] != resultI.get(i)) {
                        return false;
                    }
                }
                return true;
            }));
        }
    }

    @Test
    void sample1() {
        assertArrayEquals(new int[][]{{1, 1}, {2, 1}, {3, 1}}, Solution.sample(new int[]{1, 2, 3, 3}, 1));
    }

    @Test
    void sample2() {
        assertArrayEquals(new int[][]{{1, 1}, {2, 1}, {3, 2}}, Solution.sample(new int[]{1, 2, 3, 3}, 2));
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
        //        assertEquals(expected, Solution.binarySearchClosest(array, key));
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