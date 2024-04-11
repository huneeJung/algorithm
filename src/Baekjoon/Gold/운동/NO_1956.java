package Baekjoon.Gold.운동;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_1956 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[][] arr = new int[v + 1][v + 1];
            for (int[] row : arr) {
                Arrays.fill(row, 4000001);
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[a][b] = c;
            }

            for (int k = 1; k <= v; k++) {
                for (int i = 1; i <= v; i++) {
                    for (int j = 1; j <= v; j++) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }

            int answer = 4000001;
            for (int i = 1; i <= v; i++) {
                answer = Math.min(answer, arr[i][i]);
            }

            bw.write(answer == 4000001 ? "-1" : String.valueOf(answer));
        }
    }
}