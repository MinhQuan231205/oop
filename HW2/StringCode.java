import java.util.HashSet;
import java.util.Set;

public class StringCode {
    public static String blowup(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        String[] kq = new String[n];

        for (int i=0; i<n; i++) {
            if (a[i] == '0')
                kq[i] = "-1";
            else if (a[i] >= '1' && a[i] <= '9') {
                if (i == n-1)
                    kq[i] = "-1";
                else {
                    String s0 = String.valueOf(a[i+1]);
                    int cnt = a[i] - '0';
                    kq[i] = s0.repeat(cnt);
                }
            }
            else
                kq[i] = String.valueOf(a[i]);
        }

        String fin = new String();
        for (int i=0; i<n; i++) {
            if (kq[i] != "-1")
                fin += kq[i];
        }
        return fin;
    }

    public static int maxRun(String str) {
        int n = str.length();
        int cnt = 1, kq = 1;
        char[] a = str.toCharArray();

        for (int i=0; i<n-1; i++) {
            if (a[i] == a[i+1])
                cnt++;
            else {
                if (cnt > kq)
                    kq = cnt;
                cnt = 1;
            }
        }
        return kq;
    }

    public static boolean StringIntersect(String a, String b, int len) {
        if (len < 1)
            return false;
        int n = a.length();
        int m = b.length();
        Set<String> a0 = new HashSet<>();
        Set<String> b0 = new HashSet<>();

        for (int i=0; i<n-len+1; i++)
            a0.add(a.substring(i, i+len));
        for (int j=0; j<m-len+1; j++)
            b0.add(b.substring(j, j+len));

        a0.retainAll(b0);

        if (a0.isEmpty())
            return false;
        else
            return true;
    }
}
