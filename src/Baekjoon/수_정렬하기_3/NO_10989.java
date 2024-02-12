package Baekjoon.수_정렬하기_3;

import java.io.*;
import java.util.Arrays;

public class NO_10989 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            var sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n).append("\n");
            }
            bw.write(sb.toString());
        }
    }
}