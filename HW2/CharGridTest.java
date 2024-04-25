import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CharGridTest {

    //test charArea:
    @Test
    public void CharArea_char1() {
        char[][] chargrid = new char[][] {
                {'c', 'a', 'x'},
                {'b', ' ', 'b'},
                {' ', ' ', 'a'},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(1, test.charArea('c'));
        assertEquals(6, test.charArea('a'));
        assertEquals(1, test.charArea('x'));
        assertEquals(3, test.charArea('b'));
        assertEquals(4, test.charArea(' '));
    }
    @Test
    public void CharArea_char2() {
        char[][] chargrid = new char[][] {
                {'a', 'b', 'c', 'd'},
                {'a', ' ', 'c', 'd'},
                {'x', 'b', 'c', 'a'},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(3, test.charArea('c'));
        assertEquals(12, test.charArea('a'));
        assertEquals(1, test.charArea('x'));
        assertEquals(3, test.charArea('b'));
        assertEquals(2, test.charArea('d'));
        assertEquals(1, test.charArea(' '));
    }
    @Test
    public void CharArea_char3() {
        char[][] chargrid = new char[][] {
                {'-', 'b', 'a', '.'},
                {'b', 'a', '-', '.'},
                {'a', 'b', 'b', '.'},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(6, test.charArea('-'));
        assertEquals(9, test.charArea('a'));
        assertEquals(3, test.charArea('.'));
        assertEquals(9, test.charArea('b'));
    }

    //test countPlus:

    @Test
    public void CountPlus_char1() {
        char[][] chargrid = new char[][] {
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
                {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
                {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
                {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
                {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
                {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(2, test.countPlus());
    }
    @Test
    public void CountPlus_char2() {
        char[][] chargrid = new char[][] {
                {'a', 'c', 'h', 'a', 'e', 'b', 'c', 'l', 'a'},
                {'b', 'h', 'h', 'h', 'e', 'a', 'l', 'l', 'l'},
                {'c', 'b', 'h', 'b', 'e', 'c', 'c', 'l', 'b'},
                {'a', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'c'},
                {'b', 'l', 'a', 'c', 'e', 'a', 'o', 'b', 'a'},
                {'l', 'l', 'l', 'a', 'e', 'o', 'o', 'o', 'b'},
                {'c', 'l', 'c', 'b', 'e', 'b', 'o', 'a', 'c'},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(5, test.countPlus());
    }
    @Test
    public void CountPlus_char3() {
        char[][] chargrid = new char[][] {
                {'a', 'a'},
                {'a', 'b'},
        };
        CharGrid test = new CharGrid(chargrid);
        assertEquals(0, test.countPlus());
    }

}
