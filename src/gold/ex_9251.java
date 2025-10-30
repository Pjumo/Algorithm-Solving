package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9251 {
    static StringBuilder sb = new StringBuilder();
    static String FirstString;
    static String SecondString;
    static int[][] dp;

    public static void lcs() {
        for (int i = 1; i <= FirstString.length(); i++) {
            for (int j = 1; j <= SecondString.length(); j++) {
                if (FirstString.charAt(i - 1) == SecondString.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FirstString = br.readLine();
        SecondString = br.readLine();
        dp = new int[FirstString.length() + 1][SecondString.length() + 1];
        lcs();
        sb.append(dp[FirstString.length()][SecondString.length()]);
        System.out.println(sb);
    }
}
