package Baekjoon.Gold.이세계_게임;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class NO_2314 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Map<String, Integer> visited = new HashMap<>();
    private static StringBuilder destination = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                var str = br.readLine();
                sb.append(str);
            }

            br.readLine();

            for (int i = 0; i < 4; i++) {
                destination.append(br.readLine());
            }

            Queue<String> q = new ArrayDeque<>();
            q.add(sb.toString());
            visited.put(sb.toString(), 0);

            var cnt = 0;
            while (!q.isEmpty()) {
                var keyword = q.poll();
                if (isSame(keyword)) {
                    cnt = visited.get(keyword);
                    break;
                }

                var frame = getFrame(keyword);

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 4; k++) {
                            var x = i + dx[k];
                            var y = j + dy[k];
                            if (x < 0 || y < 0 || x >= 4 || y >= 4 || frame[i][j] == frame[x][y]) continue;
                            var temp = frame[x][y];
                            frame[x][y] = frame[i][j];
                            frame[i][j] = temp;
                            var newKeyword = getKeyword(frame);
                            if (!visited.containsKey(newKeyword)) {
                                visited.put(newKeyword, visited.get(keyword) + 1);
                                q.add(newKeyword);
                            }
                            temp = frame[x][y];
                            frame[x][y] = frame[i][j];
                            frame[i][j] = temp;
                        }
                    }
                }
            }
            bw.write(String.valueOf(cnt));

        }
    }

    private static boolean isSame(String keyword) {
        return keyword.equals(destination.toString());
    }

    private static String getKeyword(char[][] frame) {
        var sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(frame[i][j]);
            }
        }
        return sb.toString();
    }

    private static char[][] getFrame(String keyword) {
        char[][] current = new char[4][4];
        current[0] = keyword.substring(0, 4).toCharArray();
        current[1] = keyword.substring(4, 8).toCharArray();
        current[2] = keyword.substring(8, 12).toCharArray();
        current[3] = keyword.substring(12, 16).toCharArray();
        return current;
    }

}
