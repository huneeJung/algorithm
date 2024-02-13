package Baekjoon.Gold.미친_로봇;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO_1405 {

    private static int moveCnt;
    private static boolean[][] visited;
    private static double[] per;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};
    private static double answer = 0;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            moveCnt = Integer.parseInt(st.nextToken());
            per = new double[4];
            for (int i = 0; i < 4; i++) {
                per[i] = Integer.parseInt(st.nextToken()) * 0.01;
            }
            visited = new boolean[30][30];
            dfs(new int[]{15, 15}, 0, 1);
            bw.write(String.valueOf(answer));
        }
    }

    private static void dfs(int[] start, int depth, double sum) {
        if (depth == moveCnt) {
            answer += sum;
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] location = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = location[0] + dx[i];
                var y = location[1] + dy[i];
                if (x < 0 || y < 0 || x > 29 || y > 29 || visited[x][y]) continue;
                dfs(new int[]{x, y}, depth + 1, sum * per[i]);
                visited[x][y] = false;
            }
        }
    }
}