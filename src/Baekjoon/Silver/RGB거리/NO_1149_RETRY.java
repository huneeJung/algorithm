package Baekjoon.Silver.RGB거리;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1149_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var houseCnt = Integer.parseInt(br.readLine());

            int[][] dp = new int[houseCnt + 1][3];
            for (int i = 1; i <= houseCnt; i++) {
                var st = new StringTokenizer(br.readLine());
                var r = Integer.parseInt(st.nextToken());
                var g = Integer.parseInt(st.nextToken());
                var b = Integer.parseInt(st.nextToken());

                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
            }
            bw.write(String.valueOf(Math.min(Math.min(dp[houseCnt][0], dp[houseCnt][1]), dp[houseCnt][2])));
        }
    }
}