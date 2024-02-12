package Baekjoon.구간_합_구하기_5;

import java.io.*;
import java.util.StringTokenizer;

public class NO_11660 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var mapSize = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());
            int[][] map = new int[mapSize + 1][mapSize + 1];
            for (int i = 1; i <= mapSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= mapSize; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1] + Integer.parseInt(st.nextToken()) - map[i - 1][j - 1];
                }
            }
            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var r1 = Integer.parseInt(st.nextToken());
                var c1 = Integer.parseInt(st.nextToken());
                var r2 = Integer.parseInt(st.nextToken());
                var c2 = Integer.parseInt(st.nextToken());
                var answer = map[r2][c2] - map[r1 - 1][c2] - map[r2][c1 - 1] + map[r1 - 1][c1 - 1];
                bw.write(answer + "\n");
            }
        }
    }
}