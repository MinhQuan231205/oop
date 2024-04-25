public class StringCode {
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
    public static boolean StringIntersect(String a, String b, int len) {
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
}
