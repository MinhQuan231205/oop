public class CharGrid {
    private char[][] grid;
    
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }
    
    int char Area(char ch) {
        int n = grid.length;
        int m = grid[0].length;
        int s=0, fou=0, up=n, down=1, left=m, right=1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (grid[i][j] == ch) {
                    fou = 1;
                    if (i < up) up = i;
                    if (i > down) down = i;
                    if (j < left) left = j;
                    if (j > right) right = j;
                }

            }
        }
        if (fou == 0)
            s = 0;
        else if (fou == 1)
            s = (right-left+1) * (down-up+1);
        return s;
    }

    int countPlus() {
        int n = grid.length;
        int m = grid[0].length;
        int countplus = 0;
        if (n < 3 || m < 3)
            return countplus;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                int bra = 1, cnt = 0, check = 0;
                char ck = grid[i][j];
                while(true) {
                    if (j+bra < m+1) {
                        if (grid[i][j+bra] == ck) 
                            cnt++;
                    }
                    if (j-bra >= 1) {
                        if (grid[i][j-bra] == ck) 
                            cnt++;
                    }
                    if (i+bra < n+1) {
                        if (grid[i+bra][j] == ck) 
                            cnt++;
                    }
                    if (i-bra >= 1) {
                        if (grid[i-bra][j] == ck) 
                            cnt++;
                    }

                    if (cnt == 4) {
                        cnt=0;
                        check = 1;
                        bra++;
                    }
                    else if (cnt == 0 && check == 1) {
                        countplus++;
                        break;
                    }
                    else if (cnt >= 0 && cnt <= 3) 
                        break;
                }
            }
        }
        return countplus;
    }
}
