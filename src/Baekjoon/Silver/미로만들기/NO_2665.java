package Baekjoon.Silver.미로만들기;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class NO_2665 {
    private static char[][] map;
    private static int[][] drill;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var mapSize = Integer.parseInt(br.readLine());
            map = new char[mapSize][mapSize];
            drill = new int[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                var c = br.readLine();
                map[i] = c.toCharArray();
                for (int j = 0; j < mapSize; j++) {
                    drill[i][j] = 2501;
                }
            }
            Queue<Location> q = new LinkedList<>();
            drill[0][0] = map[0][0] == '1' ? 0 : 1;
            q.add(new Location(0, 0, drill[0][0]));
            while (!q.isEmpty()) {
                var location = q.poll();
                for (int i = 0; i < 4; i++) {
                    var x = location.x + dx[i];
                    var y = location.y + dy[i];
                    if (x < 0 || y < 0 || x >= mapSize || y >= mapSize) {
                        continue;
                    }
                    if (map[x][y] == '1' && location.drill >= drill[x][y]) {
                        continue;
                    }
                    if (map[x][y] == '0' && location.drill + 1 >= drill[x][y]) {
                        continue;
                    }
                    if (map[x][y] == '1') {
                        q.add(new Location(x, y, location.drill));
                        drill[x][y] = location.drill;
                    } else {
                        q.add(new Location(x, y, location.drill + 1));
                        drill[x][y] = location.drill + 1;
                    }
                }
            }
            bw.write(String.valueOf(drill[mapSize - 1][mapSize - 1]));
        }
    }
}

class Location {
    public int x;
    public int y;
    public int drill;

    public Location(int x, int y, int drill) {
        this.x = x;
        this.y = y;
        this.drill = drill;
    }
}
