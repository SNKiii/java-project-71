import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import hexlet.code.Comparing;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.List;



class ComparingTest {

    @Test
    void testComparePrimitiveValues() {
        int EXPECTED = 5;
        int DIFFERENT = 10;
        assertTrue(Comparing.comparing(DIFFERENT, EXPECTED));
        assertFalse(Comparing.comparing(EXPECTED, DIFFERENT));
        assertTrue(Comparing.comparing("test", "test"));
        assertFalse(Comparing.comparing("test", "Test"));
    }

    @Test
    void testCompareLists() {
        int NUMONE = 1;
        int NUMTWO = 2;
        int NUMTHREE = 3;
        List<Integer> list1 = List.of(NUMONE, NUMTWO, NUMTHREE);
        List<Integer> list2 = List.of(NUMONE, NUMTWO, NUMTHREE);
        List<Integer> list3 = List.of(NUMTHREE, NUMTWO, NUMONE);

        assertTrue(Comparing.comparing(list1, list2));
        assertFalse(Comparing.comparing(list1, list3));
    }

    @Test
    void testCompareMaps() {
        Map<String, Object> oneMap = Map.of("a", 1, "b", 2);
        Map<String, Object> twoMap = Map.of("a", 1, "b", 2);
        Map<String, Object> threeMap = Map.of("a", 2, "b", 3);
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

