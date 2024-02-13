package Baekjoon.Gold.토마토;

import java.io.*;
import java.util.*;

public class NO_7569 {
    private static int[][][] map;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static int colSize;
    private static int rowSize;
    private static int highSize;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());
            highSize = Integer.parseInt(st.nextToken());
            map = new int[highSize][rowSize][colSize];
            List<int[]> startList = new ArrayList<>();
            for (int i = 0; i < highSize; i++) {
                for (int j = 0; j < rowSize; j++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    for (int k = 0; k < colSize; k++) {
                        map[i][j][k] = Integer.parseInt(st.nextToken());
                        if (map[i][j][k] == 1) {
                            startList.add(new int[]{i, j, k});
                        }
                    }
                }
            }
            int time = bfs(startList);
            for (int i = 0; i < highSize; i++) {
                for (int j = 0; j < rowSize; j++) {
                    for (int k = 0; k < colSize; k++) {
                        if (map[i][j][k] == 0) {
                            bw.write("-1");
                            return;
                        }
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
                for (int i = 0; i < 6; i++) {
                    var high = location[0] + dz[i];
                    var x = location[1] + dx[i];
                    var y = location[2] + dy[i];
                    if (x < 0 || y < 0 || high < 0 ||
                            x >= rowSize || y >= colSize || high >= highSize || map[high][x][y] != 0) continue;
                    newLocationList.add(new int[]{high, x, y});
                    map[high][x][y] = 1;
                }
            }
            if (newLocationList.isEmpty()) continue;
            q.add(newLocationList);
            time++;
        }
        return time;
    }
}