import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import hexlet.code.Comparing;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.List;



class ComparingTest {
    private static final int EXPECTED_VALUE = 5;
    private static final int DIFFERENT_VALUE = 10;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;

    @Test
    void testComparePrimitiveValues() {
        assertFalse(Comparing.comparing(EXPECTED_VALUE, DIFFERENT_VALUE));
        assertTrue(Comparing.comparing("test", "test"));
        assertFalse(Comparing.comparing("test", "Test"));
    }

    @Test
    void testCompareLists() {

        List<Integer> list1 = List.of(NUM_ONE, NUM_TWO, NUM_THREE);
        List<Integer> list2 = List.of(NUM_ONE, NUM_TWO, NUM_THREE);
        List<Integer> list3 = List.of(NUM_THREE, NUM_TWO, NUM_ONE);

        assertTrue(Comparing.comparing(list1, list2));
        assertFalse(Comparing.comparing(list1, list3));
    }

    @Test
    void testCompareMaps() {
        Map<String, Object> oneMap = Map.of("a", 1, "b", 2);
        Map<String, Object> twoMap = Map.of("a", 1, "b", 2);
        Map<String, Object> threeMap = Map.of("a", 2, "b", NUM_THREE);
        Map<String, Object> map1 = oneMap;
        Map<String, Object> map2 = twoMap;
        Map<String, Object> map3 = threeMap;

        assertTrue(Comparing.comparing(map1, map2));
        assertFalse(Comparing.comparing(map1, map3));
    }

    @Test
    void testCompareDifferentTypes() {
        assertFalse(Comparing.comparing(List.of(1, 2), Map.of("a", 1)));
    }
}

