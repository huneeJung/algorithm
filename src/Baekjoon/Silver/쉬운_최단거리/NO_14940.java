package Baekjoon.Silver.쉬운_최단거리;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_14940 {
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new int[n][m];
            int[] startIndex = new int[2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        startIndex[0] = i;
                        startIndex[1] = j;
                    }
                }
            }
            bfs(startIndex);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) bw.write("-1 ");
                    else bw.write(visited[i][j] + " ");
                }
                bw.write("\n");
            }
        }
    }

    private static void bfs(int[] startIndex) {
        Queue<int[]> q = new LinkedList<>();
        q.add(startIndex);
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = location[1] + dx[i];
                var y = location[0] + dy[i];
                if (x < 0 || y < 0 || x >= m || y >= n ||
                        map[y][x] == 0 || (startIndex[0] == y && startIndex[1] == x)) {
                    continue;
                }
                map[y][x] = 0;
                visited[y][x] = visited[location[0]][location[1]] + 1;
                q.add(new int[]{y, x});
            }
        }
    }
}