package Baekjoon.Silver.구간_합_구하기_5;

import java.io.*;
import java.util.StringTokenizer;

public class NO_11660_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            var arrSize = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());

            var arr = new int[arrSize + 1][arrSize + 1];
            for (int i = 1; i <= arrSize; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= arrSize; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine());
                var x1 = Integer.parseInt(st.nextToken());
                var y1 = Integer.parseInt(st.nextToken());
                var x2 = Integer.parseInt(st.nextToken());
                var y2 = Integer.parseInt(st.nextToken());
                var result = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
                bw.write(result + "\n");
            }
        }
    }
}