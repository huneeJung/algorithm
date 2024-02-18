package Baekjoon.Gold.감시_피하기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_18428 {
    private static int n;
    private static String[][] map;
    private static List<int[]> teacherList = new ArrayList<>();
    private static boolean isOK = false;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            map = new String[n][n];
            for (int i = 0; i < n; i++) {
                var st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken();
                    if (map[i][j].equals("T")) {
                        teacherList.add(new int[]{i, j});
                    }
                }
            }
            dfs(0);
            if (isOK) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
        }
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    dfs(depth + 1);
                    if (isOK) return;
                    map[i][j] = "X";
                }
            }
        }
    }

    private static void bfs() {
        for (int[] teacherLocation : teacherList) {
            for (int i = 0; i < 4; i++) {
                var x = teacherLocation[0];
                var y = teacherLocation[1];
                while (true) {
                    x += dx[i];
                    y += dy[i];
                    if (x < 0 || y < 0 || x >= n || y >= n || map[x][y].equals("O")) break;
                    if (map[x][y].equals("S")) {
                        return;
                    }
                }
            }
        }
        isOK = true;
    }
}