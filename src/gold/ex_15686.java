package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_15686 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static LinkedList<Point> chickenPoint = new LinkedList<>();
    static LinkedList<Point> housePoint = new LinkedList<>();
    static Stack<Point> points = new Stack<>();
    static int[][] map;
    static int minDistance = Integer.MAX_VALUE;

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point p2) {
            return Math.abs(x - p2.x) + Math.abs(y - p2.y);
        }
    }

    public static int calShortChicken(Point house) {
        int sd = Integer.MAX_VALUE;
        for (Point point : points) {
            int d = house.distance(point);
            if (sd > d) sd = d;
        }
        return sd;
    }

    public static int calculateChicken() {
        int d = 0;
        for (Point point : housePoint) {
            d += calShortChicken(point);
        }
        return d;
    }

    public static void choosePoint(int m, int s) {
        if (m == M) {
            int distance = calculateChicken();
            if (minDistance > distance) minDistance = distance;
            return;
        }
        for (int i = s; i < chickenPoint.size(); i++) {
            points.push(chickenPoint.get(i));
            choosePoint(++m, i + 1);
            points.pop();
            m--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    housePoint.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chickenPoint.add(new Point(i, j));
                }
            }
        }

        choosePoint(0, 0);
        sb.append(minDistance);
        System.out.println(sb);
    }
}
