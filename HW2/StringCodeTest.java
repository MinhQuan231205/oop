import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class StringCodeTest {

    //test blowup:
    @Test
    public void testBlowUp_BasicCases() {
        assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
        assertEquals("2xxx", StringCode.blowup("12x"));
    }
    @Test
    public void testBlowUp_DigitAtEnd() {
        assertEquals("axxx", StringCode.blowup("a2x3"));
    }
    @Test
    public void testBlowUp_DigitZero() {
        assertEquals("aabb", StringCode.blowup("aa0bb"));
    }

    //test maxRun:
    @Test
    public void testMaxRun_String1() {
        assertEquals(3, StringCode.maxRun("xxyyyz"));
        assertEquals(1, StringCode.maxRun("xyz"));
    }
    @Test
    public void testMaxRun_String2() {
        assertEquals(1, StringCode.maxRun("xyxyxyxy"));
    }
    @Test
    public void testMaxRun_String3() {
        assertEquals(0, StringCode.maxRun(""));
    }

    //test stringIntersect:
    @Test
    public void testStringIntersect_1() {
        assertEquals(true, StringCode.StringIntersect("abc1def2ghi13", "abcdefghi123", 1));
        assertEquals(true, StringCode.StringIntersect("abc1def2ghi13", "abcdefghi123", 2));
        assertEquals(true, StringCode.StringIntersect("abc1def2ghi13", "abcdefghi123", 3));
        assertEquals(true, StringCode.StringIntersect("abc1def2ghi13", "abcdefghi123", 4));
        assertEquals(false, StringCode.StringIntersect("abc1def2ghi13", "abcdefghi123", 5));
    }
    @Test
    public void testStringIntersect_2() {
        assertEquals(true, StringCode.StringIntersect("wigwwnydtyo", "kwmmka", 1));
        assertEquals(false, StringCode.StringIntersect("wigwwnydtyo", "kwmmka", 2));
    }
    @Test
    public void testStringIntersect_3() {
        assertEquals(false, StringCode.StringIntersect("AGGTAB", "GXTXAY", 0));
        assertEquals(true, StringCode.StringIntersect("AGGTAB", "GXTXAY", 1));
        assertEquals(false, StringCode.StringIntersect("AGGTAB", "GXTXAY", 2));
    }

}
