package Baekjoon.Gold.나의_인생에는_수학과_함께;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class NO_17265 {
    private static Set<String> operationKey = Set.of("+", "-", "*");
    private static String[][] map;
    private static int n;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            map = new String[n][n];
            for (int i = 0; i < n; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken();
                }
            }
            bfs();
            bw.write(max + " " + min);
        }
    }

    private static void bfs() {
        Queue<Location> q = new ArrayDeque<>();
        q.add(new Location(0, 0, null, Integer.parseInt(map[0][0])));
        while (!q.isEmpty()) {
            var location = q.poll();
            for (int i = 0; i < 2; i++) {
                var x = location.x + dx[i];
                var y = location.y + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= n) continue;
                var key = map[x][y];
                if (operationKey.contains(key)) {
                    q.add(new Location(x, y, key, location.value));
                } else {
                    Location newLocation;
                    if (location.operation.equals("+")) {
                        newLocation = new Location(x, y, null, location.value + Integer.parseInt(key));
                    } else if (location.operation.equals("-")) {
                        newLocation = new Location(x, y, null, location.value - Integer.parseInt(key));
                    } else {
                        newLocation = new Location(x, y, null, location.value * Integer.parseInt(key));
                    }
                    if (x == n - 1 && y == n - 1) {
                        max = Math.max(max, newLocation.value);
                        min = Math.min(min, newLocation.value);
                    } else {
                        q.add(newLocation);
                    }
                }
            }
        }
    }
}

class Location {
    public int x;
    public int y;
    public String operation;
    public int value;

    public Location(int x, int y, String operation, int value) {
        this.x = x;
        this.y = y;
        this.operation = operation;
        this.value = value;
    }
}