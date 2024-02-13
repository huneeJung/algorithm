package Baekjoon.Silver.일로_만들기;

import java.io.*;

public class NO_1463 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var num = Integer.parseInt(br.readLine());
            int[] dp = new int[1000001];
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= num; i++) {
                if (i % 6 == 0) {
                    dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
                } else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            bw.write(String.valueOf(dp[num]));
        }
    }
}