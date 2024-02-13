package Softeer.Lv_2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 장애물_인식_프로그램 {
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};
    private static char[][] map;
    private static int mapSize;
    private static boolean[][] visited;
    private static List<Integer> groupList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            mapSize = Integer.parseInt(br.readLine());
            map = new char[mapSize][mapSize];
            visited = new boolean[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                String str = br.readLine();
                map[i] = str.toCharArray();
            }
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (!visited[i][j] && map[i][j] == '1') {
                        bfs(i, j);
                    }
                }
            }
            bw.write(groupList.size() + "\n");
            groupList.sort((a, b) -> a - b);
            for (int cnt : groupList) {
                bw.write(cnt + "\n");
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int groupCnt = 0;
        while (!q.isEmpty()) {
            int[] location = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = location[0] + di[i];
                int y = location[1] + dj[i];
                if (x < 0 || y < 0 || x > mapSize - 1 || y > mapSize - 1 || visited[x][y]) {
                    continue;
                }
                if (map[x][y] == '1') {
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                    groupCnt++;
                }
            }
        }
        if (groupCnt == 0) {
            groupList.add(1);
        } else {
            groupList.add(groupCnt);
        }
    }
}
