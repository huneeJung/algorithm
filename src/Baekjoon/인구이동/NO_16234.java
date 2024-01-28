package Baekjoon.인구이동;

import java.io.*;
import java.util.*;

public class NO_16234 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int mapSize;
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};
    private static List<int[]> union;
    private static int min, max;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            mapSize = Integer.parseInt(st.nextToken());
            map = new int[mapSize][mapSize];
            min = Integer.parseInt(st.nextToken());
            max = Integer.parseInt(st.nextToken());
            for (int i = 0; i < mapSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            var time = 0;
            while (true) {
                boolean isMoved = false;
                visited = new boolean[mapSize][mapSize];
                for (int i = 0; i < mapSize; i++) {
                    for (int j = 0; j < mapSize; j++) {
                        if (!visited[i][j]) {
                            int sum = bfs(i, j);
                            if (union.size() > 1) {
                                isMoved = true;
                                move(sum);
                            }
                        }
                    }
                }
                if (!isMoved) {
                    break;
                }
                time++;
            }
            bw.write(String.valueOf(time));
        }
    }

    private static int bfs(int indexR, int indexC) {
        Queue<int[]> q = new LinkedList<>();
        union = new ArrayList<>();
        union.add(new int[]{indexR, indexC});
        visited[indexR][indexC] = true;
        q.add(new int[]{indexR, indexC});
        var sum = map[indexR][indexC];
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = location[0] + di[i];
                int c = location[1] + dj[i];
                if (r < 0 || c < 0 || r >= mapSize || c >= mapSize
                        || visited[r][c]) {
                    continue;
                }
                int diff = Math.abs(map[location[0]][location[1]] - map[r][c]);
                if (diff < min || diff > max) {
                    continue;
                }
                sum += map[r][c];
                q.add(new int[]{r, c});
                union.add(new int[]{r, c});
                visited[r][c] = true;
            }
        }
        return sum;
    }

    private static void move(int sum) {
        var value = sum / union.size();
        for (int[] location : union) {
            map[location[0]][location[1]] = value;
        }
    }
}