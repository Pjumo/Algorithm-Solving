package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ex_5430 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void ac(String p, Deque<Integer> deque) {
        boolean isFront = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                isFront = !isFront;
            } else {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (isFront) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        sb.append('[');
        if (deque.isEmpty()) {
            sb.append(']').append('\n');
            return;
        }
        if (isFront) sb.append(deque.pollFirst());
        else sb.append(deque.pollLast());
        while (!deque.isEmpty()) {
            if (isFront) sb.append(',').append(deque.pollFirst());
            else sb.append(',').append(deque.pollLast());
        }
        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String p;
        int s;
        Deque<Integer> deque;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            deque = new ArrayDeque<>();
            p = br.readLine();
            s = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < s; j++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            ac(p, deque);
        }
        System.out.println(sb);
    }
}
