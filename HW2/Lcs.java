import java.util.*;
import java.lang.*;

public class Lcs {

    static Boolean lcs(String a, String b, int len) {
        if (len < 1)
            return false;
        int n = a.length();
        int m = b.length();
        int[][] L = new int[n+1][m+1];
        char[] a0 = a.toCharArray();
        char[] b0 = b.toCharArray();

        for (int i=0; i<=n; i++)
            L[i][0] = 0;
        for (int j=0; j<=m; j++)
            L[0][j] = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (a0[i-1] == b0[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else {
                    if (L[i][j-1] >= L[i-1][j])
                        L[i][j] = L[i][j-1];
                    else
                        L[i][j] = L[i-1][j];

                }
            }
        }

        if (len <= L[n][m])
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = new String(sc.nextLine());
        String s2 = new String(sc.nextLine());
        int len = sc.nextInt();

        System.out.println(lcs(s1, s2, len));
    }
}
