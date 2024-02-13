package Baekjoon.Silver.유기농_배추;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_1012 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static int xSize;
    private static int ySize;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            for (int c = 0; c < caseCnt; c++) {

                var earthWormCnt = 0;
                var st = new StringTokenizer(br.readLine(), " ");
                xSize = Integer.parseInt(st.nextToken());
                ySize = Integer.parseInt(st.nextToken());
                var napaCabbageCnt = Integer.parseInt(st.nextToken());
                map = new int[xSize][ySize];
                for (int n = 0; n < napaCabbageCnt; n++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
                }

                for (int i = 0; i < xSize; i++) {
                    for (int j = 0; j < ySize; j++) {
                        if (map[i][j] == 1) {
                            bfs(new int[]{i, j});
                            earthWormCnt++;
                        }
                    }
                }
                bw.write(earthWormCnt + "\n");

            }
        }
    }

    private static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = location[0] + dx[i];
                var y = location[1] + dy[i];
                if (x < 0 || y < 0 || x >= xSize || y >= ySize || map[x][y] == 0) continue;
                map[x][y] = 0;
                q.offer(new int[]{x, y});
            }
        }
    }
}