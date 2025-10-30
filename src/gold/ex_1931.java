package gold;

import java.util.*;

public class ex_1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] sc = new int[n][2];
        for (int i = 0; i < n; i++) {
            sc[i][0] = scanner.nextInt();
            sc[i][1] = scanner.nextInt();
        }

        Arrays.sort(sc, (s1, s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            }

            return s1[1] - s2[1];
        });

        int cnt = 0;
        int time = 0;

        for (int[] s : sc) {
            if (time <= s[0]) {
                time = s[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
