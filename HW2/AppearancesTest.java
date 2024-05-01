import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class AppearancesTest {
    //test sameCount:
    @Test
    public void testSameCount_Collection1() {
        ArrayList<String> l1 = String_to_ArrayList("ababc");
        ArrayList<String> l2 = String_to_ArrayList("caadbbb");
        assertEquals(2, Appearances.sameCount(l1, l2));
    }
    @Test
    public void testSameCount_Collection2() {
        ArrayList<String> l1 = String_to_ArrayList("abcdabcd");
        ArrayList<String> l2 = String_to_ArrayList("aaabbbccc");
        assertEquals(0, Appearances.sameCount(l1, l2));
    }
    @Test
    public void testSameCount_Collection3() {
        ArrayList<String> l1 = String_to_ArrayList("aaabbcdeefff");
        ArrayList<String> l2 = String_to_ArrayList("bceffdeaabaf");
        assertEquals(6, Appearances.sameCount(l1, l2));
    }


    public ArrayList<String> String_to_ArrayList(String s) {
        String[] s0 = s.split("");
        ArrayList<String> al = new ArrayList<>(Arrays.asList(s0));
        return al;
    }

}
