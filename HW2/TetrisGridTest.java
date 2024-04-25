import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TetrisGridTest {

    //test clearRows:
    @Test
    public void testClearRows_grid1() {
        boolean[][] tetrisgrid = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {true, false, false},
                {false, true, true},
                {true, true, true},
                {true, true, false},
                {true, true, true},
        };
        boolean[][] tetrisgrid_after = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {true, false, false},
                {false, true, true},
                {true, true, false},
        };
        TetrisGrid tg = new TetrisGrid(tetrisgrid);
        tg.clearRows();
        assertEquals(tetrisgrid_after, tg.getGrid());
    }

    @Test
    public void testClearRows_grid2() {
        boolean[][] tetrisgrid = new boolean[][] {
                {false, false, true},
                {true, true, false},
        };
        boolean[][] tetrisgrid_after = new boolean[][] {
                {false, false, true},
                {true, true, false},
        };
        TetrisGrid tg = new TetrisGrid(tetrisgrid);
        tg.clearRows();
        assertEquals(tetrisgrid_after, tg.getGrid());
    }

    @Test
    public void testClearRows_grid3() {
        boolean[][] tetrisgrid = new boolean[][] {
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, true, true},
        };
        boolean[][] tetrisgrid_after = new boolean[][] {
                {false, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
        };
        TetrisGrid tg = new TetrisGrid(tetrisgrid);
        tg.clearRows();
        assertEquals(tetrisgrid_after, tg.getGrid());
    }
}
