package Baekjoon.Gold.미로만들기;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_2665_RETRY {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                var st = new StringTokenizer(br.readLine());
                var arr = st.nextToken().toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j] - 48;
                }
            }
            var result = bfs();
            bw.write(String.valueOf(result));
        }
    }

    public static int bfs() {
        var q = new PriorityQueue<Lo>((lo1, lo2) -> (lo1.brokeCnt - lo2.brokeCnt));
        q.add(new Lo(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            var lo = q.poll();
            for (int i = 0; i < 4; i++) {
                var x = lo.x + dx[i];
                var y = lo.y + dy[i];
                var brokeCnt = lo.brokeCnt;
                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                if (x == n - 1 && y == n - 1) return brokeCnt;
                if (map[x][y] == 0) {
                    q.add(new Lo(x, y, brokeCnt + 1));
                } else {
                    q.add(new Lo(x, y, brokeCnt));
                }
            }
        }
        return 0;
    }
}

class Lo {
    public int x;
    public int y;
    public int brokeCnt;

    public Lo(int x, int y, int brokeCnt) {
        this.x = x;
        this.y = y;
        this.brokeCnt = brokeCnt;
    }
}