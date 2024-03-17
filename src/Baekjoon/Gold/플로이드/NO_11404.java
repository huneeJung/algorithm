package Baekjoon.Gold.플로이드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11404 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var cityCnt = Integer.parseInt(br.readLine());
            var busCnt = Integer.parseInt(br.readLine());

            int[][] priceArr = new int[cityCnt + 1][cityCnt + 1];

            for (int i = 1; i <= cityCnt; i++) {
                Arrays.fill(priceArr[i], Integer.MAX_VALUE);
                priceArr[i][i] = 0;
            }
            for (int i = 0; i < busCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var start = Integer.parseInt(st.nextToken());
                var end = Integer.parseInt(st.nextToken());
                var price = Integer.parseInt(st.nextToken());
                priceArr[start][end] = Math.min(priceArr[start][end], price);
            }

            for (int i = 1; i <= cityCnt; i++) {
                for (int j = 1; j <= cityCnt; j++) {
                    for (int k = 1; k <= cityCnt; k++) {
                        if (priceArr[j][i] == Integer.MAX_VALUE || priceArr[i][k] == Integer.MAX_VALUE) continue;
                        priceArr[j][k] = Math.min(priceArr[j][k], priceArr[j][i] + priceArr[i][k]);
                    }
                }
            }
            for (int i = 1; i <= cityCnt; i++) {
                for (int j = 1; j <= cityCnt; j++) {
                    priceArr[i][j] = priceArr[i][j] == Integer.MAX_VALUE ? 0 : priceArr[i][j];
                    bw.write(priceArr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
    }
}