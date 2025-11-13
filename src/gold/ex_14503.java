package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14503 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int r, c, d;
    static boolean isOperation = true;
    static int[][] room;
    static int[][] front = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int cleanCnt = 0;

    public static boolean isCleanable() {
        return room[r][c - 1] == 0 || room[r][c + 1] == 0 || room[r - 1][c] == 0 || room[r + 1][c] == 0;
    }

    public static void robot() {
        if (room[r][c] == 0) {
            room[r][c] = -1;
            cleanCnt++;
            return;
        }
        if (!isCleanable()) {
            if (room[r - front[d][0]][c - front[d][1]] == -1) {
                r = r - front[d][0];
                c = c - front[d][1];
            } else {
                isOperation = false;
            }
            return;
        }
        d = d - 1;
        if (d == -1) d = 3;
        if (room[r + front[d][0]][c + front[d][1]] == 0) {
            r = r + front[d][0];
            c = c + front[d][1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (isOperation) {
            robot();
        }

        sb.append(cleanCnt);
        System.out.println(sb);
    }
}
