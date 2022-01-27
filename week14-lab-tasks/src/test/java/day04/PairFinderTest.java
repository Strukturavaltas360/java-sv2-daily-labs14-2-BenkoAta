package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    PairFinder pairFinder = new PairFinder();

    @Test
    void findPairs() {
        assertEquals(1, pairFinder.findPairs(new int[] {5, 1, 4, 5}));
        assertEquals(4, pairFinder.findPairs(new int[] {7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
    }
}