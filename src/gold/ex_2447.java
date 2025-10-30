package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_2447 {
    static StringBuilder sb = new StringBuilder();
    static char[][] star;

    public static void drawStar(int n, int x, int y) {
        if (n == 1) {
            star[x][y] = '*';
            return;
        }
        int m = n / 3;
        drawStar(m, x - m * 2, y - m * 2);
        drawStar(m, x - m * 2, y - m);
        drawStar(m, x - m * 2, y);
        drawStar(m, x - m, y - m * 2);
        drawStar(m, x - m, y);
        drawStar(m, x, y - m * 2);
        drawStar(m, x, y - m);
        drawStar(m, x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        star = new char[N + 1][N + 1];
        drawStar(N, N, N);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (star[i][j] == '*') {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
