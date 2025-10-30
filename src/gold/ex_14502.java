package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_14502 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] map;
    static LinkedList<Node> emptyPoint = new LinkedList<>();
    static Queue<Node> VirusPoint = new LinkedList<>();
    static int maxValue = 0;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void countSafetyZone(int[][] newMap) {
        Queue<Node> virusPoint = new ArrayDeque<>(VirusPoint);
        while (!virusPoint.isEmpty()) {
            Node node = virusPoint.poll();
            if (node.x != 0 && newMap[node.x - 1][node.y] == 0) {
                newMap[node.x - 1][node.y] = 2;
                virusPoint.offer(new Node(node.x - 1, node.y));
            }
            if (node.y != 0 && newMap[node.x][node.y - 1] == 0) {
                newMap[node.x][node.y - 1] = 2;
                virusPoint.offer(new Node(node.x, node.y - 1));
            }
            if (node.x != N - 1 && newMap[node.x + 1][node.y] == 0) {
                newMap[node.x + 1][node.y] = 2;
                virusPoint.offer(new Node(node.x + 1, node.y));
            }
            if (node.y != M - 1 && newMap[node.x][node.y + 1] == 0) {
                newMap[node.x][node.y + 1] = 2;
                virusPoint.offer(new Node(node.x, node.y + 1));
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt > maxValue) {
            maxValue = cnt;
        }
    }

    static void makeMap(int cnt, int start) {
        for (int i = start; i < emptyPoint.size(); i++) {
            cnt++;
            Node node = emptyPoint.get(i);
            map[node.x][node.y] = 1;
            if (cnt == 3) {
                int[][] newMap = new int[N][M];
                for (int r = 0; r < N; r++) {
                    newMap[r] = map[r].clone();
                }
                countSafetyZone(newMap);
            } else {
                makeMap(cnt, i + 1);
            }
            map[node.x][node.y] = 0;
            cnt--;
        }
    }

    static void findEmptyPoint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    emptyPoint.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    VirusPoint.add(new Node(i, j));
                }
            }
        }

        makeMap(0, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findEmptyPoint();

        sb.append(maxValue);

        System.out.println(sb);
    }
}
