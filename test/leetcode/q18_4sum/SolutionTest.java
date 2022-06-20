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
}