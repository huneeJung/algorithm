package Baekjoon.Gold.가스관;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.StringTokenizer;

public class NO_2931 {
    // 오른쪽,왼쪽,아래,위
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    // 왼쪽,오른쪽,위,아래
    private static final Map<Character, boolean[]> blockMap = Map.of(
            '|', new boolean[]{false, false, true, true},
            '-', new boolean[]{true, true, false, false},
            '+', new boolean[]{true, true, true, true},
            '1', new boolean[]{false, true, false, true},
            '2', new boolean[]{false, true, true, false},
            '3', new boolean[]{true, false, true, false},
            '4', new boolean[]{true, false, false, true}
    );
    private static int row;
    private static int col;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] answerLo = new int[2];
    private static char answerName = ' ';

    public static void main(String[] args) throws IOException {

        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            visited = new boolean[row][col];

            int[] start = new int[2];

            for (int i = 0; i < row; i++) {
                var str = br.readLine();
                for (int j = 0; j < col; j++) {
                    var c = str.charAt(j);
                    if (c == 'M') {
                        start[0] = i;
                        start[1] = j;
                        visited[i][j] = true;
                    }
                    map[i][j] = c;
                }
            }
            bfs(start);
            bw.write((answerLo[0] + 1) + " " + (answerLo[1] + 1) + " " + answerName);
        }
    }

    private static void bfs(int[] start) {
        var q = new ArrayDeque<int[]>();
        q.add(start);

        while (!q.isEmpty()) {
            var lo = q.poll();
            var cnt = 0;
            // 오른쪽,왼쪽,아래,위
            for (int i = 0; i < 4; i++) {
                var x = lo[0] + dx[i];
                var y = lo[1] + dy[i];
                if (x < 0 || y < 0 || x >= row || y >= col || map[x][y] == '.' || visited[x][y])
                    continue;
                if (map[x][y] == 'Z') {
                    cnt++;
                    continue;
                }
                var block = map[x][y];
                var funcArr = blockMap.get(block);
                if (funcArr[i]) {
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                    cnt++;
                }
            }
            if (cnt == 0) {
                search(lo);
                return;
            }
        }
    }

    private static void search(int[] lo) {
        var possibleArr = blockMap.get(map[lo[0]][lo[1]]);
        // 오른쪽,왼쪽,아래,위
        for (int i = 0; i < 4; i++) {
            var x = lo[0] + dx[i];
            var y = lo[1] + dy[i];
            var index = i % 2 == 1 ? i - 1 : i + 1;
            if (!possibleArr[index] || visited[x][y]) continue;
            boolean[] funcArr = new boolean[4];
            funcArr[i] = true;
            check(new int[]{x, y}, funcArr);
        }
    }

    private static void check(int[] start, boolean[] funcArr) {
        var q = new ArrayDeque<int[]>();
        q.add(start);

        while (!q.isEmpty()) {
            var lo = q.poll();
            boolean flag = false;
            // 오른쪽,왼쪽,아래,위
            for (int i = 0; i < 4; i++) {
                var x = lo[0] + dx[i];
                var y = lo[1] + dy[i];
                var funcIndex = i % 2 == 1 ? i - 1 : i + 1;
                if (x < 0 || y < 0 || x >= row || y >= col || map[x][y] == '.'
                        || map[x][y] == 'Z' || map[x][y] == 'M' || funcArr[funcIndex])
                    continue;
                var block = map[x][y];
                var inFuncArr = blockMap.get(block);
                if (inFuncArr[i]) {
                    var index = i % 2 == 1 ? i - 1 : i + 1;
                    funcArr[index] = true;
                    flag = true;
                }
            }
            if (flag) {
                for (Map.Entry<Character, boolean[]> entry : blockMap.entrySet()) {
                    var funcArr2 = entry.getValue();
                    var flag2 = true;
                    for (int i = 0; i < 4; i++) {
                        if (!(funcArr2[i] == funcArr[i])) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag2) {
                        answerLo = lo;
                        answerName = entry.getKey();
                        return;
                    }
                }
            }
        }
    }
}