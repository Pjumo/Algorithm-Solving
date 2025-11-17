package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_6549 {
    static StringBuilder sb = new StringBuilder();

    public static long getLargestT(int n, StringTokenizer st) {
        Stack<Integer> s = new Stack<>();
        long maxArea = 0, h, w;
        int[] histogram = new int[n];
        for (int i = 0; i < n; i++) {
            histogram[i] = Integer.parseInt(st.nextToken());
            while (!s.isEmpty() && histogram[s.peek()] >= histogram[i]) {
                h = histogram[s.pop()];
                w = s.isEmpty() ? i : i - s.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            h = histogram[s.pop()];
            w = s.isEmpty() ? n : n - s.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            System.out.println(getLargestT(n, st));
        }
    }
}
