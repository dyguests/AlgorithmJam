package leetcode.q295_find_median;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    @Test
    void test1() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        assertEquals(1.5f, obj.findMedian());
        obj.addNum(3);
        assertEquals(2f, obj.findMedian());
    }
}