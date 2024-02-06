package Baekjoon.RGB거리;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1149 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var houseCnt = Integer.parseInt(br.readLine());
            int[][] dp = new int[houseCnt][3];
            int[] colorCost = new int[3];
            for (int i = 0; i < houseCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 3; j++) {
                    colorCost[j] = Integer.parseInt(st.nextToken());
                }
                if (i == 0) {
                    dp[i][0] = colorCost[0];
                    dp[i][1] = colorCost[1];
                    dp[i][2] = colorCost[2];
                } else {
                    dp[i][0] = colorCost[0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                    dp[i][1] = colorCost[1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                    dp[i][2] = colorCost[2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
            bw.write(Math.min(Math.min(dp[houseCnt - 1][0], dp[houseCnt - 1][1]), dp[houseCnt - 1][2]) + "");
        }
    }
}