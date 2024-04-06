package Baekjoon.Gold.가장_큰_정사각형;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1915 {
    private static int[] dx = {-1, -1, 0};
    private static int[] dy = {-1, 0, -1};

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var row = Integer.parseInt(st.nextToken());
            var col = Integer.parseInt(st.nextToken());
            int[][] map = new int[row][col];
            for (int i = 0; i < row; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = (int) arr[j] - '0';
                }
            }
            var max = 0;
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (map[i][j] == 0) continue;
                    var sum = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        var x = i + dx[k];
                        var y = j + dy[k];
                        if (x < 0 || y < 0 || x >= row || y >= col) continue;
                        sum = Math.min(sum, map[x][y] + map[i][j]);
                    }
                    map[i][j] = sum;
                    max = Math.max(max, sum);
                }
            }
            if (max == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] == 1) {
                            max = 1;
                            break;
                        }
                    }
                    if (max == 1) {
                        break;
                    }
                }
            }
            bw.write(String.valueOf(max * max));
        }
    }
}