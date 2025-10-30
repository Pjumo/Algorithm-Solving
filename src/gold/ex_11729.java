package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n - 1, start, end, mid);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, mid, start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
}
