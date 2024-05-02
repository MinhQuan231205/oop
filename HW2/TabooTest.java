import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
public class TabooTest {
    //test noFollow:
    @Test
    public void testNoFollow_rule1() {
        List<String> rule = String_to_ArrayList("acab");
        Taboo<String> tb = new Taboo<String>(rule);
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> s3 = new HashSet<>();
        s1.add("b");
        s1.add("c");
        s3.add("a");
        assertEquals(s1, tb.noFollow("a"));
        assertEquals(s2, tb.noFollow("b"));
        assertEquals(s3, tb.noFollow("c"));
    }
    @Test
    public void testNoFollow_rule2() {
        List<String> rule = new ArrayList<>();
        rule.add("a");
        rule.add("b");
        rule.add(null);
        rule.add("c");
        rule.add("d");
        Taboo<String> tb = new Taboo<String>(rule);
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> s3 = new HashSet<>();
        s1.add("b");
        s2.add("d");
        assertEquals(s1, tb.noFollow("a"));
        assertEquals(s3, tb.noFollow("b"));
        assertEquals(s2, tb.noFollow("c"));
        assertEquals(s3, tb.noFollow("d"));
    }
    @Test
    public void testNoFollow_rule3() {
        List<String> rule = String_to_ArrayList("acbxca");
        Taboo<String> tb = new Taboo<String>(rule);
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> s3 = new HashSet<>();
        s1.add("c");
        s2.add("x");
        s3.add("a");
        s3.add("b");
        assertEquals(s1, tb.noFollow("a"));
        assertEquals(s2, tb.noFollow("b"));
        assertEquals(s3, tb.noFollow("c"));
        assertEquals(s1, tb.noFollow("x"));
    }

    //test reduce:
    @Test
    public void testReduce_list1() {
        List<String> rule = String_to_ArrayList("acab");
        List<String> list = String_to_ArrayList("acbxca");
        List<String> result = String_to_ArrayList("axc");
        Taboo<String> tb = new Taboo<String>(rule);
        tb.reduce(list);
        assertEquals(result, list);
    }
    @Test
    public void testReduce_list2() {
        List<String> rule = new ArrayList<>();
        rule.add("a");
        rule.add("b");
        rule.add(null);
        rule.add("c");
        rule.add("d");
        List<String> list = String_to_ArrayList("acbdca");
        List<String> result = String_to_ArrayList("acbdca");
        Taboo<String> tb = new Taboo<String>(rule);
        tb.reduce(list);
        assertEquals(result, list);
    }
    @Test
    public void testReduce_list3() {
        List<String> rule = String_to_ArrayList("acbxca");
        List<String> list = String_to_ArrayList("acbxca");
        List<String> result = String_to_ArrayList("abc");
        Taboo<String> tb = new Taboo<String>(rule);
        tb.reduce(list);
        assertEquals(result, list);
    }

    public List<String> String_to_ArrayList(String s) {
        String[] s0 = s.split("");
        List<String> al = new ArrayList<>(Arrays.asList(s0));
        return al;
    }
}
