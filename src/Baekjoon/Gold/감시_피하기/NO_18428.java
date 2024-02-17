package Baekjoon.Gold.감시_피하기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_18428 {
    private static int n;
    private static String[][] map;
    private static boolean[][] visited;
    private static List<int[]> studentList;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            n = Integer.parseInt(br.readLine());
            map = new String[n][n];
            visited = new boolean[n][n];
            studentList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken();
                    if (map[i][j].equals("S")) {
                        studentList.add(new int[]{i, j});
                    }
                }
            }
            bw.write(bfs());
        }
    }

    private static String bfs() {
        var obstacleCnt = 0;
        for (int[] studentLocation : studentList) {
            for (int i = 0; i < 4; i++) {
                var flag = false;
                var x = studentLocation[0];
                var y = studentLocation[1];
                while (true) {
                    x += dx[i];
                    y += dy[i];
                    if (x < 0 || y < 0 || x > n - 1 || y > n - 1 || visited[x][y]) break;
                    if (map[x][y].equals("T")) {
                        if (map[x - dx[i]][y - dy[i]].equals("S")) return "NO";
                        x = studentLocation[0];
                        y = studentLocation[1];
                        while (true) {
                            x += dx[i];
                            y += dy[i];
                            if (x < 0 || y < 0 || x > n - 1 || y > n - 1) break;
                            if (map[x][y].equals("X")) {
                                visited[x][y] = true;
                            }
                        }
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    obstacleCnt++;
                }
            }
        }
        System.out.println(obstacleCnt);
        return obstacleCnt <= 3 ? "YES" : "NO";
    }
}