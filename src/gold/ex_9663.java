package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9663 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int cnt = 0;

    public static void queen(int level, int[] point) {
        if (level == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            point[level] = i;
            boolean clear = true;
            for (int j = 0; j < level; j++) {
                if (i == point[j] || Math.abs(point[j] - i) == level - j) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                queen(level + 1, point);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen(0, new int[N]);
        sb.append(cnt);
        System.out.println(sb);
    }
}