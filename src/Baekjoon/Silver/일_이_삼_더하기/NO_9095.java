package Baekjoon.Silver.일_이_삼_더하기;

import java.io.*;

public class NO_9095 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            int[] arr = new int[caseCnt];
            for (int i = 0; i < caseCnt; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int[] dp = new int[11];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for (int i = 3; i < 11; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            for (int num : arr) {
                bw.write(dp[num - 1] + "\n");
            }
        }
    }
}