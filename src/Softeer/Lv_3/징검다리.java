package Softeer.Lv_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int cnt = Integer.parseInt(br.readLine());
            int[] arr = new int[cnt];
            int[] dp = new int[cnt];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = 1;
            }
            for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            Arrays.sort(dp);
            bw.write(String.valueOf(dp[dp.length - 1]));
        }
    }
}
