package Baekjoon.Silver.구간_합_구하기_4;

import java.io.*;
import java.util.StringTokenizer;

public class NO_11659_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            var numCnt = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());

            var arr = new int[numCnt + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= numCnt; i++) {
                var num = Integer.parseInt(st.nextToken());
                arr[i] = num + arr[i - 1];
            }

            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine());
                var start = Integer.parseInt(st.nextToken());
                var end = Integer.parseInt(st.nextToken());
                var result = arr[end] - arr[start - 1];
                bw.write(result + "\n");
            }
        }
    }
}