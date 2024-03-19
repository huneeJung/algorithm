package Baekjoon.Gold.컬러볼;

import java.io.*;
import java.util.*;

public class NO_10800 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var ballCnt = Integer.parseInt(br.readLine());
            List<int[]> ballList = new ArrayList<>();
            Map<Integer, Integer> sum = new HashMap<>();
            for (int i = 0; i < ballCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var no = i;
                var color = Integer.parseInt(st.nextToken());
                var size = Integer.parseInt(st.nextToken());
                ballList.add(new int[]{no, color, size});
                if (sum.containsKey(color)) continue;
                sum.put(color, 0);
            }
            ballList.sort((a, b) -> a[2] - b[2]);
            int[] answer = new int[ballCnt];
            int total = 0;
            int beforeSize = 0;
            int beforeColor = -1;
            int same = 0;
            for (int[] ball : ballList) {
                var no = ball[0];
                var color = ball[1];
                var size = ball[2];
                answer[no] = total - sum.get(color);
                if (beforeSize == size) {
                    same++;
                    if (beforeColor != color) {
                        answer[no] -= size * same;
                    }
                } else {
                    same = 0;
                }
                total += size;
                sum.merge(color, size, Integer::sum);
                beforeSize = size;
                beforeColor = color;
            }
            for (int num : answer) {
                bw.write(num + "\n");
            }
        }
    }
}