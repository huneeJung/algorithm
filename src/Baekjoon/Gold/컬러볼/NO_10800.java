package Baekjoon.Gold.컬러볼;

import java.io.*;
import java.util.*;

class Ball {
    public int no;
    public int color;
    public int size;

    public Ball(int no, int color, int size) {
        this.no = no;
        this.color = color;
        this.size = size;
    }
}

public class NO_10800 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var ballCnt = Integer.parseInt(br.readLine());
            List<Ball> ballList = new ArrayList<>();
            Map<Integer, Integer> sum = new HashMap<>();
            for (int i = 0; i < ballCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var no = i;
                var color = Integer.parseInt(st.nextToken());
                var size = Integer.parseInt(st.nextToken());
                ballList.add(new Ball(no, color, size));
                if (sum.containsKey(color)) continue;
                sum.put(color, 0);
            }
            ballList.sort((a, b) -> a.size - b.size);
            int[] answer = new int[ballCnt];
            int total = 0;
            int index = 0;
            for (Ball ball : ballList) {
                var before = ballList.get(index);
                while (before.size < ball.size) {
                    total += before.size;
                    sum.merge(before.color, before.size, Integer::sum);
                    before = ballList.get(++index);
                }
                answer[ball.no] = total - sum.get(ball.color);
            }
            for (int num : answer) {
                bw.write(num + "\n");
            }
        }
    }
}