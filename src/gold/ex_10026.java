package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex_10026 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] pic;
    static boolean[][] confirm;
    static boolean[][] cbConfirm;
    static int trueZoneCnt = 0;
    static int cbZoneCnt = 0;

    public static boolean cbMatch(char a, char b) {
        if (a == 'B' && b == 'B') return true;
        else if (a != 'B' && b != 'B') return true;
        return false;
    }

    public static void findZone(int i, int j) {
        confirm[i][j] = true;
        if (i != 0 && pic[i][j] == pic[i - 1][j] && !confirm[i - 1][j]) {
            findZone(i - 1, j);
        }
        if (i != N - 1 && pic[i][j] == pic[i + 1][j] && !confirm[i + 1][j]) {
            findZone(i + 1, j);
        }
        if (j != 0 && pic[i][j] == pic[i][j - 1] && !confirm[i][j - 1]) {
            findZone(i, j - 1);
        }
        if (j != N - 1 && pic[i][j] == pic[i][j + 1] && !confirm[i][j + 1]) {
            findZone(i, j + 1);
        }
    }

    public static void findCbZone(int i, int j) {
        cbConfirm[i][j] = true;
        if (i != 0 && cbMatch(pic[i][j], pic[i - 1][j]) && !cbConfirm[i - 1][j]) {
            findCbZone(i - 1, j);
        }
        if (i != N - 1 && cbMatch(pic[i][j], pic[i + 1][j]) && !cbConfirm[i + 1][j]) {
            findCbZone(i + 1, j);
        }
        if (j != 0 && cbMatch(pic[i][j], pic[i][j - 1]) && !cbConfirm[i][j - 1]) {
            findCbZone(i, j - 1);
        }
        if (j != N - 1 && cbMatch(pic[i][j], pic[i][j + 1]) && !cbConfirm[i][j + 1]) {
            findCbZone(i, j + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pic = new char[N][N];
        confirm = new boolean[N][N];
        cbConfirm = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(confirm[i], false);
            Arrays.fill(cbConfirm[i], false);
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                pic[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!confirm[i][j]) {
                    findZone(i, j);
                    trueZoneCnt++;
                }
                if (!cbConfirm[i][j]) {
                    findCbZone(i, j);
                    cbZoneCnt++;
                }
            }
        }
        sb.append(trueZoneCnt).append("\n").append(cbZoneCnt);
        System.out.println(sb);
    }
}
