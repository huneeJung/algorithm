package Baekjoon.Gold.행렬_제곱;

import java.io.*;
import java.util.StringTokenizer;

public class NO_10830 {
    private static long[][] oriMatrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            var exponent = Long.parseLong(st.nextToken());
            oriMatrix = new long[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    oriMatrix[i][j] = Long.parseLong(st.nextToken()) % 1000;
                }
            }
            long[][] result = divisionProcess(exponent);
            for (long[] r : result) {
                for (long c : r) {
                    bw.write(c + " ");
                }
                bw.write("\n");
            }
        }
    }

    private static long[][] divisionProcess(long exponent) {
        if (exponent == 1) {
            return oriMatrix;
        }
        long[][] temp = divisionProcess(exponent / 2);
        if (exponent % 2 == 1) {
            return multiply(multiply(temp, temp), oriMatrix);
        }
        return multiply(temp, temp);
    }

    private static long[][] multiply(long[][] matrixA, long[][] matrixB) {
        long[][] arr = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[i][j] += (matrixA[i][k] * matrixB[k][j]);
                }
                arr[i][j] %= 1000;
            }
        }
        return arr;
    }
}