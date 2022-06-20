package leetcode.q18_4sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void fourSum() {
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