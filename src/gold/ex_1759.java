package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_1759 {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] al;
    static final char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    public static void findPwd(int n, Stack<Character> pwd) {
        if (pwd.size() == L) {
            int vCnt = 0;
            for (char c : vowel) {
                if (pwd.contains(c)) vCnt++;
            }
            if (vCnt >= 1 && pwd.size() - vCnt >= 2) {
                for (Character c : pwd) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }
        for (int i = n; i <= C - L + pwd.size(); i++) {
            pwd.push(al[i]);
            findPwd(i + 1, pwd);
            pwd.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        al = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            al[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(al);

        findPwd(0, new Stack<>());
        System.out.println(sb);
    }
}
