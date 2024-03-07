package Baekjoon.Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_2589 {
    private static char[][] map;
    private static int[][] visited;
    private static int xSize;
    private static int ySize;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            xSize = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());
            map = new char[xSize][ySize];
            var lList = new ArrayList<int[]>();
            for (int i = 0; i < xSize; i++) {
                var str = br.readLine();
                for (int j = 0; j < ySize; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'L') {
                        lList.add(new int[]{i, j});
                    }
                }
            }
            for (int[] l : lList) {
                visited = new int[xSize][ySize];
                bfs(l);
            }
            bw.write(String.valueOf(answer - 1));
        }
    }

    private static void bfs(int[] l) {
        Queue<int[]> q = new LinkedList<>();
        visited[l[0]][l[1]] = 1;
        q.add(l);
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = location[0] + dx[i];
                var y = location[1] + dy[i];
                if (x < 0 || y < 0 || x >= xSize || y >= ySize || visited[x][y] != 0 || map[x][y] == 'W') continue;
                visited[x][y] = visited[location[0]][location[1]] + 1;
                answer = Math.max(answer, visited[x][y]);
                q.add(new int[]{x, y});
            }
        }
    }
}