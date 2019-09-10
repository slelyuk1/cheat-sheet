import com.leliuk.sort.MySorter;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MySortTester {
    private static final int ARR_LEN = 10000;
    private Random rand = new Random();
    private int[] toSort;

    @Before
    public void init() {
        toSort = new int[ARR_LEN];
        for (int i = 0; i < ARR_LEN; ++i) {
            toSort[i] = rand.nextInt();
        }
    }

    @Test
    public void testSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.sort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }
}
