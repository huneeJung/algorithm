package Baekjoon.Silver.최대_힙;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class NO_11279 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var cnt = Integer.parseInt(br.readLine());
            Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < cnt; i++) {
                var num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    if (q.isEmpty()) {
                        bw.write("0\n");
                    } else {
                        bw.write(q.poll() + "\n");
                    }
                } else {
                    q.add(num);
                }
            }
        }
    }
}