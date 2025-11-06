package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_2206 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] map;
    static int[][][] visited;

    public static class Node {
        int x, y;
        int cnt;
        boolean isBreak;

        public Node(int x, int y, int cnt, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }

    public static void search() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(new Node(0, 0, 1, false));
        int[] nx = {1, -1, 0, 0};
        int[] ny = {0, 0, 1, -1};
        visited[0][0][0] = 1;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.x == N - 1 && node.y == M - 1) {
                sb.append(node.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = nx[i] + node.x;
                int newY = ny[i] + node.y;
                if (newX < 0 || newX == N || newY == M || newY < 0) {
                    continue;
                }
                if (visited[newX][newY][0] == 1) {
                    continue;
                }
                if (!node.isBreak) {
                    if (map[newX][newY] == 0) {
                        visited[newX][newY][0] = 1;
                        nodes.add(new Node(newX, newY, node.cnt + 1, false));
                    } else if (map[newX][newY] == 1 && visited[newX][newY][1] == 0) {
                        visited[newX][newY][1] = 1;
                        nodes.add(new Node(newX, newY, node.cnt + 1, true));
                    }
                } else {
                    if (map[newX][newY] == 0 && visited[newX][newY][1] == 0) {
                        visited[newX][newY][1] = 1;
                        nodes.add(new Node(newX, newY, node.cnt + 1, true));
                    }
                }
            }
        }
        sb.append(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        search();
        System.out.println(sb);
    }
}
