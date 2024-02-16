package Baekjoon.Gold.녹색_옷_입은_애가_젤다지;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_4485 {
    private static int n;
    private static int[][] map;
    private static int[][] costArr;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    static class Info {
        public int x;
        public int y;
        public int cost;

        public Info(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var index = 1;
            while (true) {
                System.gc();
                n = Integer.parseInt(br.readLine());
                if (n == 0) {
                    break;
                }
                map = new int[n][n];
                costArr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    var st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                        costArr[i][j] = Integer.MAX_VALUE;
                    }
                }
                bfs(map, costArr);
                bw.write("Problem " + index + ": " + costArr[n - 1][n - 1] + "\n");
                index++;
            }
        }
    }

    private static void bfs(int[][] map, int[][] costArr) {
        PriorityQueue<Info> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        q.add(new Info(0, 0, map[0][0]));
        while (!q.isEmpty()) {
            var info = q.poll();
            map[info.x][info.y] = -1;
            for (int i = 0; i < 4; i++) {
                var x = info.x + dx[i];
                var y = info.y + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == -1) continue;
                var totalCost = map[x][y] + info.cost;
                if (totalCost > costArr[x][y]) continue;
                costArr[x][y] = totalCost;
                if (x == n - 1 && y == n - 1) {
                    q.clear();
                    break;
                }
                q.add(new Info(x, y, totalCost));
            }
        }
    }
}