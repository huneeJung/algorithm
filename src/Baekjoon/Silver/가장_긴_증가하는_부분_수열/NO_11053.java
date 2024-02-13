package Baekjoon.Silver.가장_긴_증가하는_부분_수열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11053 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var size = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[size];
            for (int i = 0; i < size; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            Arrays.sort(dp);
            bw.write(String.valueOf(dp[size - 1]));
        }
    }
}