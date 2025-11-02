package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1074 {
    static int N, r, c;
    static int v = 0;

    public static int findQuad(int n, int x, int y) {
        int quad = 1;
        if (Math.pow(2, n - 1) + x <= r) {
            quad += 2;
        }
        if (Math.pow(2, n - 1) + y <= c) {
            quad += 1;
        }
        return quad;
    }

    public static void draw(int n, int x, int y) {
        if (n == 0) {
            return;
        }
        int quadCnt = (int) Math.pow(2, n - 1) * (int) Math.pow(2, n - 1);
        if (findQuad(n, x, y) == 1) {
            draw(n - 1, x, y);
        } else if (findQuad(n, x, y) == 2) {
            v += quadCnt;
            draw(n - 1, x, y + (int) Math.pow(2, n - 1));
        } else if (findQuad(n, x, y) == 3) {
            v += quadCnt * 2;
            draw(n - 1, x + (int) Math.pow(2, n - 1), y);
        } else {
            v += quadCnt * 3;
            draw(n - 1, x + (int) Math.pow(2, n - 1), y + (int) Math.pow(2, n - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        r += 1;
        c += 1;

        draw(N, 1, 1);
        System.out.println(v);
    }
}
