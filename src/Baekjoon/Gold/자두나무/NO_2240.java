package Baekjoon.Gold.자두나무;

import java.io.*;
import java.util.StringTokenizer;

public class NO_2240 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var time = Integer.parseInt(st.nextToken());
            var cnt = Integer.parseInt(st.nextToken());
            int[] treeArr = new int[time + 1];
            int[][] dp = new int[time + 1][cnt + 1];
            for (int i = 1; i <= time; i++) {
                treeArr[i] = Integer.parseInt(br.readLine());
                for (int j = 0; j <= Math.min(i, cnt); j++) {
                    // 0번 이동했을때는, 이전의 이동 횟수로 갱신
                    if (j == 0) {
                        if (treeArr[i] == 1) {
                            dp[i][j] = dp[i - 1][j] + 1;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                        continue;
                    }
                    // 현재 위치랑 사과가 떨어지는 위치가 같을때,
                    if ((j % 2 == 0 && treeArr[i] == 1) || (j % 2 == 1 && treeArr[i] == 2)) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    }
                    // 현재 위치랑 사과가 떨어지는 위치가 다를때
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }
                }
            }
            var max = 0;
            for (int i = 0; i <= cnt; i++) {
                max = Math.max(max, dp[time][i]);
            }
            bw.write(String.valueOf(max));
        }
    }
}