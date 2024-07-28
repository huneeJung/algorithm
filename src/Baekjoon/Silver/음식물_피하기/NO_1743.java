package Baekjoon.Silver.음식물_피하기;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1743 {

    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};
    private static boolean[][] map;
    private static boolean[][] visited;
    private static int rowLen;
    private static int colLen;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            rowLen = Integer.parseInt(st.nextToken());
            colLen = Integer.parseInt(st.nextToken());
            var cnt = Integer.parseInt(st.nextToken());

            map = new boolean[rowLen][colLen];
            visited = new boolean[rowLen][colLen];

            var trashList = new ArrayList<int[]>();
            for (int i = 0; i < cnt; i++) {
                st = new StringTokenizer(br.readLine());
                var row = Integer.parseInt(st.nextToken()) - 1;
                var col = Integer.parseInt(st.nextToken()) - 1;
                map[row][col] = true;
                trashList.add(new int[]{row, col});
            }

            var result = dfs(trashList);
            bw.write(String.valueOf(result));
        }
    }

    private static int dfs(List<int[]> trashList) {
        var result = 0;
        for (int[] trash : trashList) {
            if (visited[trash[0]][trash[1]]) continue;
            visited[trash[0]][trash[1]] = true;
            result = Math.max(result, bfs(trash));
        }
        return result;
    }

    private static int bfs(int[] start) {
        var result = 1;
        var q = new ArrayDeque<int[]>();
        q.add(start);
        while (!q.isEmpty()) {
            var trash = q.poll();
            for (int i = 0; i < 4; i++) {
                var row = trash[0] + dr[i];
                var col = trash[1] + dc[i];
                if (row < 0 || col < 0 || row >= rowLen || col >= colLen
                        || visited[row][col] || !map[row][col]) continue;
                visited[row][col] = true;
                result++;
                q.add(new int[]{row, col});
            }
        }
        return result;
    }

}