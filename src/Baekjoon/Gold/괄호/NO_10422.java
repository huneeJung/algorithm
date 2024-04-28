package Baekjoon.Gold.괄호;

import java.io.*;

public class NO_10422 {

    public static void main(String[] args) throws IOException {
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            long[] dp = new long[2501];

            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= 2500; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[i - j] * dp[j - 1];
                    dp[i] %= 1000000007L;
                }
            }
            var caseCnt = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            for(int i = 0 ; i < caseCnt ; i++){
                var num = Integer.parseInt(br.readLine());
                if(num%2!=0){
                    sb.append("0");
                }else {
                    sb.append(dp[num/2]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
        }
    }
}
