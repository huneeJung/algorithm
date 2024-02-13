package Baekjoon.Silver.좌표_정렬하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11650 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][2];
            for (int i = 0; i < size; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });
            var sb = new StringBuilder();
            for (int[] ar : arr) {
                sb.append(ar[0]).append(" ").append(ar[1]).append("\n");
            }
            bw.write(sb.toString());
        }
    }
}