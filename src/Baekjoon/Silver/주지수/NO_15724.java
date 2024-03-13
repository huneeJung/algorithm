package Baekjoon.Silver.주지수;

import java.io.*;
import java.util.StringTokenizer;

public class NO_15724 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var xSize = Integer.parseInt(st.nextToken());
            var ySize = Integer.parseInt(st.nextToken());
            int[][] map = new int[xSize + 1][ySize + 1];
            for (int i = 1; i <= xSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= ySize; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
            var caseCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                var answer = map[end[0]][end[1]] - map[start[0] - 1][end[1]]
                        - map[end[0]][start[1] - 1] + map[start[0] - 1][start[1] - 1];
                bw.write(answer + "\n");
            }
        }
    }
}