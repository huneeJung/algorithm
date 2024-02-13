package Baekjoon.Silver.숨바꼭질;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_1697 {
    private static long sister;
    private static long[] moveCntArr = new long[100001];
    private static long[] moveArr = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            long me = Long.parseLong(st.nextToken());
            sister = Long.parseLong(st.nextToken());
            moveCntArr[(int) me] = 0;
            bfs(me);
            bw.write(String.valueOf(moveCntArr[(int) sister]));
        }
    }

    public static void bfs(long me) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(me);
        if (me == sister) return;
        while (!queue.isEmpty()) {
            long now = queue.poll();
            for (long move : moveArr) {
                long after = move == 2 ? now * move : now + move;
                if (after < 0 || after > 100000 || moveCntArr[(int) after] != 0) continue;
                moveCntArr[(int) after] = moveCntArr[(int) now] + 1;
                if (after == sister) {
                    return;
                } else {
                    queue.add(after);
                }
            }
        }
    }
}
