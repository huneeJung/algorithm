package Baekjoon.Gold.내리막_길;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_1520 {
    private static int[][] map;
    private static int[][] visited;
    private static int xSize;
    private static int ySize;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            xSize = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());
            map = new int[xSize][ySize];
            visited = new int[xSize][ySize];
            for (int i = 0; i < xSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < ySize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int roadCnt = bfs();
            bw.write(String.valueOf(visited[xSize - 1][ySize - 1]));
        }
    }

    private static int bfs() {
        Queue<Location> q = new PriorityQueue<>((a, b) -> b.cost - a.cost);
        q.add(new Location(0, 0, map[0][0]));
        visited[0][0] = 1;
        var roadCnt = 0;
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = location.x + dx[i];
                var y = location.y + dy[i];
                if (x < 0 || y < 0 || x >= xSize || y >= ySize || location.cost <= map[x][y]) continue;
                if (visited[x][y] != 0 && location.cost > map[x][y]) {
                    visited[x][y] += visited[location.x][location.y];
                    continue;
                }

                q.add(new Location(x, y, map[x][y]));
                visited[x][y] += visited[location.x][location.y];
            }
        }
        return roadCnt;
    }
}

class Location {
    public Location(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int x;
    public int y;
    public int cost;
}