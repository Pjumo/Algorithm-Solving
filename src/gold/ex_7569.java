package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_7569 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, H, ripedCnt;
    static int[][][] box;
    static Queue<Point> ripedIndex;

    public static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void ripe(Point p) {
        if (p.x < 0 || p.y < 0 || p.z < 0 || p.x >= H || p.y >= N || p.z >= M) return;
        if (box[p.x][p.y][p.z] == 0) {
            box[p.x][p.y][p.z] = 1;
            ripedIndex.offer(p);
            ripedCnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        ripedIndex = new LinkedList<>();
        int blankCnt = 0;
        ripedCnt = 0;
        int days = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        ripedIndex.offer(new Point(i, j, k));
                        ripedCnt++;
                    } else if (box[i][j][k] == -1) {
                        blankCnt++;
                    }
                }
            }
        }

        while (true) {
            if (blankCnt + ripedCnt == N * M * H) break;
            int s = ripedIndex.size();
            if (s == 0) {
                days = -1;
                break;
            }

            for (int i = 0; i < s; i++) {
                Point p = ripedIndex.poll();
                ripe(new Point(p.x - 1, p.y, p.z));
                ripe(new Point(p.x + 1, p.y, p.z));
                ripe(new Point(p.x, p.y - 1, p.z));
                ripe(new Point(p.x, p.y + 1, p.z));
                ripe(new Point(p.x, p.y, p.z - 1));
                ripe(new Point(p.x, p.y, p.z + 1));
            }
            days++;
        }
        sb.append(days);
        System.out.println(sb);
    }
}
