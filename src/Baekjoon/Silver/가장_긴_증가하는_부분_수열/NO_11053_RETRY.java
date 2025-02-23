package Baekjoon.Silver.가장_긴_증가하는_부분_수열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11053_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var numCnt = Integer.parseInt(br.readLine());
            var numArr = new int[numCnt];

            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            var dp = new int[numCnt];
            for (int i = 0; i < numCnt; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (numArr[i] > numArr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            Arrays.sort(dp);
            bw.write(String.valueOf(dp[numCnt - 1]));
        }
    }
}