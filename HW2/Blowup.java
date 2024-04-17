import java.util.*;
import java.lang.*;

public class Blowup {
    public static String blowup(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        String[] kq = new String[n];

        //biến đổi xâu 
        for (int i=0; i<n; i++) {
            if (a[i] == '0') {
                kq[i] = "-1";
            }
            else if (a[i] >= '1' && a[i] <= '9') {
                if (i == n-1) {
                    kq[i] = "-1";
                }
                else {
                    String s0 = String.valueOf(a[i+1]);
                    int cnt = a[i] - '0';
                    kq[i] = s0.repeat(cnt);
                }
            }
            else {
                kq[i] = String.valueOf(a[i]);
            }
        }

        //gộp xâu
        String fin = new String();
        for (int i=0; i<n; i++) {
            if (kq[i] != "-1") {
                fin += kq[i];
            }
        }
        return fin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String KQ = new String(blowup(s));

        System.out.println(KQ);
    }
}
