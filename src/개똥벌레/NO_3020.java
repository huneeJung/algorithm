package 개똥벌레;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_3020 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var cnt = Integer.parseInt(st.nextToken());
            var maxHeight = Integer.parseInt(st.nextToken());
            Queue<Integer> bottomQ = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> topQ = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < cnt; i++) {
                if (i % 2 == 0) {
                    bottomQ.add(Integer.parseInt(br.readLine()));
                } else {
                    topQ.add(Integer.parseInt(br.readLine()));
                }
            }
            int[] bottomCntArr = new int[maxHeight];
            for (int i = maxHeight; i >= 1; i--) {
                var breakingCnt = 0;
                while (!bottomQ.isEmpty()) {
                    if (bottomQ.peek() == i) {
                        breakingCnt++;
                        bottomQ.poll();
                    } else {
                        break;
                    }
                }
                if (i == maxHeight) {
                    bottomCntArr[i - 1] = breakingCnt;
                } else {
                    bottomCntArr[i - 1] = bottomCntArr[i] + breakingCnt;
                }
            }
            int[] topCntArr = new int[maxHeight];
            for (int i = 0; i < maxHeight; i++) {
                var breakingCnt = 0;
                while (!topQ.isEmpty()) {
                    if (maxHeight - topQ.peek() == i) {
                        breakingCnt++;
                        topQ.poll();
                    } else {
                        break;
                    }
                }
                if (i == 0) {
                    topCntArr[i] = breakingCnt;
                } else {
                    topCntArr[i] = topCntArr[i - 1] + breakingCnt;
                }
            }
            int[] answer = {200001, 0};
            for (int i = 0; i < maxHeight; i++) {
                var breakingCnt = topCntArr[i] + bottomCntArr[i];
                if (answer[0] > breakingCnt) {
                    answer = new int[]{breakingCnt, 1};
                } else if (answer[0] == breakingCnt) {
                    answer[1] += 1;
                }
            }
            bw.write(answer[0] + " " + answer[1]);
        }
    }
}