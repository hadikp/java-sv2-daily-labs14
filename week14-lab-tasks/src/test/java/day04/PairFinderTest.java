package day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    PairFinder pairFinder = new PairFinder();

    @Test
    void testMainList() {
        List<Integer> find = Arrays.asList(2, 3, 2, 4, 3, 1, 4, 4);
        assertEquals(3, pairFinder.findPairs(find));
    }

    @Test
    void testSmallList() {
        List<Integer> find = Arrays.asList(5, 1, 4, 5);
        assertEquals(1, pairFinder.findPairs(find));
    }

    @Test
    void testHigherlList() {
        List<Integer> find = Arrays.asList(7, 1, 5, 7, 3, 3, 5, 7, 6, 7);
        assertEquals(4, pairFinder.findPairs(find));
        pairFinder.findPairs(find);
        System.out.println(pairFinder.getResult());
    }

}