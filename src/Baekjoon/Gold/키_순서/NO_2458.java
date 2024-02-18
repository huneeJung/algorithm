package Baekjoon.Gold.키_순서;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_2458 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var peopleCnt = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());
            int[][] dp = new int[peopleCnt][peopleCnt];
            for (int i = 0; i < peopleCnt; i++) {
                Arrays.fill(dp[i], 121);
            }
            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var a = Integer.parseInt(st.nextToken());
                var b = Integer.parseInt(st.nextToken());
                dp[a - 1][b - 1] = 1;
            }
            for (int n = 0; n < peopleCnt; n++) {
                for (int i = 0; i < peopleCnt; i++) {
                    for (int j = 0; j < peopleCnt; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][n] + dp[n][j]);
                    }
                }
            }
            var answer = 0;
            for (int i = 0; i < peopleCnt; i++) {
                var cnt = 0;
                for (int j = 0; j < peopleCnt; j++) {
                    if (dp[i][j] != 121 || dp[j][i] != 121) {
                        cnt++;
                    }
                }
                if (cnt == peopleCnt - 1) {
                    answer++;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}