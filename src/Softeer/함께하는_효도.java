package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class 함께하는_효도 {

    private static int[][] map;
    private static int mapSize;
    private static int[][] people;
    private static int peopleCnt;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            mapSize = Integer.parseInt(st.nextToken());
            peopleCnt = Integer.parseInt(st.nextToken());
            map = new int[mapSize][mapSize];
            visited = new boolean[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            people = new int[peopleCnt][2];
            for (int i = 0; i < peopleCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                people[i][0] = Integer.parseInt(st.nextToken());
                people[i][1] = Integer.parseInt(st.nextToken());
            }
            dfs(new int[]{people[0][0] - 1, people[0][1] - 1}, 0, 0);
            bw.write(String.valueOf(answer));
        }
    }

    private static void dfs(int[] before, int depth, int amount) {
        if (depth == peopleCnt * 4) {
            if (answer < amount) {
                answer = amount;
            }
            return;
        }
        before = depth % 4 == 0 ? new int[]{people[depth / 4][0] - 1, people[depth / 4][1] - 1} : before;
        for (int i = 0; i < 4; i++) {
            int nowX = before[0];
            int nowY = before[1];
            if (nowX < 0 || nowY < 0 || nowX > mapSize - 1 || nowY > mapSize - 1 || visited[nowX][nowY]) continue;
            visited[nowX][nowY] = true;
            int x2 = nowX + dx[i];
            int y2 = nowY + dy[i];
            dfs(new int[]{x2, y2}, depth + 1, amount + map[nowX][nowY]);
            visited[before[0]][before[1]] = false;
        }
    }
}
