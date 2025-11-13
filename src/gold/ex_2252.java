package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_2252 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] noe;
    static Queue<Integer> line = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        noe = new int[N + 1];

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            noe[b]++;
        }
        while (line.size() != N) {
            for (int i = 1; i <= N; i++) {
                if (noe[i] == 0) {
                    noe[i] = -1;
                    line.offer(i);
                    for (Integer g : graph.get(i)) {
                        noe[g]--;
                    }
                }
            }
        }
        for (Integer l : line) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}
