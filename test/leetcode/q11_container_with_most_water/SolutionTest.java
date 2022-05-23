package leetcode.q11_container_with_most_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxArea_1() {
        validate(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49);
    }

    @Test
    void maxArea_2() {
        validate(new int[]{1, 1}, 1);
    }

    private void validate(int[] height, int expected) {
        assertEquals(expected, new Solution().maxArea(height));
    }
}