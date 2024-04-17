import java.util.*;
import java.lang.*;

public class MaxRun {
    public static int maxRun(String str) {
        int n = str.length();
        int cnt = 1, kq = 1;
        char[] a = str.toCharArray();

        //tìm độ dài chuỗi con giống nhau liên tiếp dài nhất
        for (int i=0; i<n-1; i++) {
            if (a[i] == a[i+1]) {
                cnt++;
            }
            else {
                if (cnt > kq) kq = cnt;
                cnt = 1;
            }
        }

        return kq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int KQ = maxRun(s);

        System.out.println(KQ);
    }
}
