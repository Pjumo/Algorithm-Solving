package gold;

import java.util.Scanner;

public class ex_12865 {

    static int[] W;
    static int[] V;
    static int[][] dp;

    public static int calValue(int n, int k) {

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i <= n; i++) {
                if (W[i] <= j) {
                    if (i == 0) {
                        dp[i][j] = V[i];
                    } else {
                        dp[i][j] = Math.max(V[i] + dp[i - 1][j - W[i]], dp[i - 1][j]);
                    }
                } else {
                    if (i != 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = 0;
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        dp = new int[N][K + 1];
        W = new int[N];
        V = new int[N];

        for (int i = 0; i < N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        System.out.println(calValue(N - 1, K));
    }
}
