package Baekjoon.Gold.넴모넴모EASY;

import java.io.*;
import java.util.StringTokenizer;

public class NO_14712 {

    private static int n;
    private static int m;
    private static boolean[][] map;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new boolean[n][m];
            dfs(0, 0);
            bw.write(String.valueOf(answer));
        }
    }

    private static void dfs(int depth, int start) {
        answer += check();
        if (depth == n * m) return;

        for (int a = start; a < n * m; a++) {
            var i = a / m;
            var j = a % m;
            if (map[i][j]) continue;
            map[i][j] = true;
            dfs(depth + 1, a + 1);
            map[i][j] = false;
        }
    }

    private static int check() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}

