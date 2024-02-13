package Baekjoon.Silver.계단오르기;

import java.io.*;

public class NO_2579 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var stairCnt = Integer.parseInt(br.readLine());
            int[] dp = new int[301];
            int[] stair = new int[301];
            for (int i = 0; i < stairCnt; i++) {
                stair[i] = Integer.parseInt(br.readLine());
            }
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[0], stair[1]) + stair[2];
            for (int i = 3; i < stairCnt; i++) {
                dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
            }
            bw.write(String.valueOf(dp[stairCnt - 1]));
        }
    }
}