package Baekjoon.Silver.계단오르기;

import java.io.*;

public class NO_2579_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var stairCnt = Integer.parseInt(br.readLine());

            int[] scoreArr = new int[301];
            for (int i = 1; i <= stairCnt; i++) {
                scoreArr[i] = Integer.parseInt(br.readLine());
            }

            int[] dp = new int[301];
            dp[1] = scoreArr[1];
            dp[2] = scoreArr[1] + scoreArr[2];
            for (int i = 3; i <= stairCnt; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + scoreArr[i - 1]) + scoreArr[i];
            }

            bw.write(String.valueOf(dp[stairCnt]));
        }
    }
}