
public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int i = 1;
        int dir = 1, cnt=0;
        while (Math.abs(x) <= n && Math.abs(y) <= n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
//            double r = Math.random();
//            if      (r < 0.25) x--;
//            else if (r < 0.50) x++;
//            else if (r < 0.75) y--;
//            else if (r < 1.00) y++;

            //điều kiện điều chỉnh hướng 
            if (cnt == i) {
                dir += 2;
                if (dir > 8) {
                    dir = 1;
                }
            }
            if (cnt == 2*i) {
                dir += 2;
                if (dir > 8) {
                    dir = 1;
                }
                i++; cnt=0;
            }

            if (dir < 2) {
                x--;
                cnt++;
            }
            else if (dir < 4) {
                y--;
                cnt++;
            }
            else if (dir < 6) {
                x++;
                cnt++;
            }
            else if (dir < 8) {
                y++;
                cnt++;
            }
            steps++;
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);
        }
        StdOut.println("Total steps = " + steps);
    }

}