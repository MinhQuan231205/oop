import java.util.Scanner;

public class KickBoxer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int[] weight = {
                0, 112, 115, 118, 122, 126, 130, 135, 140,
                147, 154, 160, 167, 174, 183, 189, 198, 209
        };
        String[] W_class = {
                "Fly Weight",
                "Super Fly Weight",
                "Bantam Weight",
                "Super Bantam Weight",
                "Feather Weight",
                "Super Feather Weight",
                "Light Weight",
                "Super Light Weight",
                "Welter Weight",
                "Super Welter Weight",
                "Middle Weight",
                "Super Middle Weight",
                "Light Heavy Weight",
                "Super Light Heavy Weight",
                "Cruiser Weight",
                "Super Cruiser Weight",
                "Heavy Weight",
                "Super Heavy Weight"
        };
        for (int i = weight.length-1; i >= 0; i--) {
            if (w >= weight[i]) {
                System.out.println(W_class[i]);
                break;
            }
        }
    }
}