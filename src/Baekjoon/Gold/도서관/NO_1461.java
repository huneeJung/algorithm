package Baekjoon.Gold.도서관;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_1461 {

    private static int limit;
    private static PriorityQueue<Integer> rightQ;
    private static PriorityQueue<Integer> leftQ;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var bookCnt = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            rightQ = new PriorityQueue<>(Collections.reverseOrder());
            leftQ = new PriorityQueue<>();

            var right = 0;
            var left = 0;

            for (int i = 0; i < bookCnt; i++) {
                var location = Integer.parseInt(st.nextToken());
                if (location > 0) {
                    rightQ.add(location);
                    right = Math.max(right, location);
                } else {
                    leftQ.add(location);
                    left = Math.min(left, location);
                }
            }

            var totalDistance = 0;
            if (Math.abs(left) < right) {
                totalDistance += organize(leftQ);
                totalDistance += organize(rightQ);
            } else {
                totalDistance += organize(rightQ);
                totalDistance += organize(leftQ);
            }
            bw.write(String.valueOf(totalDistance));
        }
    }

    private static int organize(PriorityQueue<Integer> q) {
        if (q.isEmpty()) {
            return 0;
        }
        var totalDistance = 0;
        if (leftQ.isEmpty() || rightQ.isEmpty()) {
            totalDistance += Math.abs(q.poll());
            for (int i = 1; i < limit && !q.isEmpty(); i++) {
                q.poll();
            }
        }
        while (!q.isEmpty()) {
            totalDistance += (Math.abs(q.poll()) * 2);
            for (int i = 1; i < limit && !q.isEmpty(); i++) {
                q.poll();
            }
        }
        return totalDistance;
    }
}