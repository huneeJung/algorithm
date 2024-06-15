package Baekjoon.Gold.흩날리는_시험지_속에서_내_평점이_느껴진거야;

import java.io.*;
import java.util.StringTokenizer;

public class NO_17951 {

    private static int paperCnt;
    private static int groupCnt;
    private static int[] paperArr;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            paperCnt = Integer.parseInt(st.nextToken());
            groupCnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            paperArr = new int[paperCnt];
            var sum = 0;
            for (int i = 0; i < paperCnt; i++) {
                paperArr[i] = Integer.parseInt(st.nextToken());
                sum += paperArr[i];
            }
            var result = binarySearch(0, sum);
            bw.write(String.valueOf(result));
        }
    }

    private static int binarySearch(int start, int end) {
        while (start <= end) {
            var mid = (start + end) / 2;
            var sum = 0;
            var cnt = 0;
            for (int i = 0; i < paperCnt; i++) {
                sum += paperArr[i];
                if (mid <= sum) {
                    cnt++;
                    sum = 0;
                }
            }
            if (groupCnt <= cnt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}