import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Distance {
    public static void main(String[] args) {
        int x, y;
        Scanner sc1 = new Scanner(System.in);
        x = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        y = sc2.nextInt();
        double dis = sqrt(x*x + y*y);
        System.out.println("the Euclidean distance from the point (" + x + ", " + y + ") to the origin (0, 0): " + dis);
    }
}