package gold;

import java.awt.*;
import java.util.*;

public class ex_7576 {

    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        int[][] box = new int[N][M];
        int empty = 0;
        int ripeCnt = 0;
        int days = 0;
        Queue<Point> ripedIndex = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    ripedIndex.offer(new Point(i, j));
                    ripeCnt++;
                } else if (box[i][j] == -1) {
                    empty++;
                }
            }
        }

        while (true) {
            if (M * N - empty == ripeCnt) {
                break;
            }

            int s = ripedIndex.size();
            if (s == 0) {
                days = -1;
                break;
            }
            days++;
            for (int i = 0; i < s; i++) {
                assert ripedIndex.peek() != null;
                int x = ripedIndex.peek().x;
                int y = ripedIndex.peek().y;
                if (x != 0 && box[x - 1][y] == 0) {
                    box[x - 1][y] = 1;
                    ripedIndex.offer(new Point(x - 1, y));
                    ripeCnt++;
                }
                if (y != 0 && box[x][y - 1] == 0) {
                    box[x][y - 1] = 1;
                    ripedIndex.offer(new Point(x, y - 1));
                    ripeCnt++;
                }
                if (x != N - 1 && box[x + 1][y] == 0) {
                    box[x + 1][y] = 1;
                    ripedIndex.offer(new Point(x + 1, y));
                    ripeCnt++;
                }
                if (y != M - 1 && box[x][y + 1] == 0) {
                    box[x][y + 1] = 1;
                    ripedIndex.offer(new Point(x, y + 1));
                    ripeCnt++;
                }
                ripedIndex.poll();
            }
        }
        System.out.println(days);
    }
}
