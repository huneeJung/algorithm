package Baekjoon.Silver.수_정렬하기_2;

import java.io.*;
import java.util.Arrays;

public class NO_2751 {
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
            for (int n : arr) {
                bw.write(n + "\n");
            }
        }
    }
}