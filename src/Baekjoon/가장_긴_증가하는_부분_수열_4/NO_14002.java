package Baekjoon.가장_긴_증가하는_부분_수열_4;

import java.io.*;
import java.util.StringTokenizer;

public class NO_14002 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var len = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            int[] numArr = new int[len];
            for (int i = 0; i < len; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            String[] dp = new String[len];
            dp[0] = numArr[0] + " ";
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[i] == null) {
                        dp[i] = numArr[i] + " ";
                    }
                    if (numArr[i] > numArr[j]) {
                        var str = dp[j] + numArr[i] + " ";
                        if (dp[i].split(" ").length < str.split(" ").length) {
                            dp[i] = str;
                        }
                    }
                }
            }
            String answer = "";
            for (int i = 0; i < len; i++) {
                if (answer.split(" ").length <= dp[i].split(" ").length) {
                    answer = dp[i];
                }
            }
            bw.write(answer.split(" ").length + "\n");
            bw.write(answer.trim());
        }
    }
}