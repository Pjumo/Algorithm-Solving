package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1753 {
    static StringBuilder sb = new StringBuilder();
    static int V, E, K;
    static ArrayList<Node>[] arr;
    static int[] cost;
    static int[] completeNode;

    static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

    static void path(int n) {
        completeNode[n] = 1;
        for (Node node : arr[n]) {
            if (cost[n] + node.weight < cost[node.end]) {
                cost[node.end] = cost[n] + node.weight;
            }
        }
        int lowCost = Integer.MAX_VALUE;
        int nextNode = n;
        for (int i = 1; i <= V; i++) {
            if (cost[i] != 0 && completeNode[i] == 0 && lowCost > cost[i]) {
                lowCost = cost[i];
                nextNode = i;
            }
        }
        if (nextNode == n) return;
        path(nextNode);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        cost = new int[V + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        completeNode = new int[V + 1];

        arr = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, weight));
        }
        cost[K] = 0;
        path(K);

        for (int i = 1; i <= V; i++) {
            if(cost[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            } else {
                sb.append(cost[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
