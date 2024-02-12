package Baekjoon.토마토;

import java.io.*;
import java.util.*;

public class NO_7576 {
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int colSize;
    private static int rowSize;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());
            map = new int[rowSize][colSize];
            List<int[]> startList = new ArrayList<>();
            for (int i = 0; i < rowSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < colSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        startList.add(new int[]{i, j});
                    }
                }
            }
            int time = bfs(startList);
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (map[i][j] == 0) {
                        bw.write("-1");
                        return;
                    }
                }
            }
            bw.write(String.valueOf(time));
        }
    }

    private static int bfs(List<int[]> startList) {
        Queue<List<int[]>> q = new LinkedList<>();
        q.add(startList);
        var time = 0;
        while (!q.isEmpty()) {
            var locationList = q.poll();
            var newLocationList = new ArrayList<int[]>();
            for (int[] location : locationList) {
                for (int i = 0; i < 4; i++) {
                    var x = location[0] + dx[i];
                    var y = location[1] + dy[i];
                    if (x < 0 || y < 0 || x >= rowSize || y >= colSize || map[x][y] != 0) continue;
                    newLocationList.add(new int[]{x, y});
                    map[x][y] = 1;
                }
            }
            if (newLocationList.isEmpty()) continue;
            q.add(newLocationList);
            time++;
        }
        return time;
    }
}