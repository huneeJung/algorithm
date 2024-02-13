package Baekjoon.Silver.체스판_다시_칠하기;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1018 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var n = Integer.parseInt(st.nextToken());
            var m = Integer.parseInt(st.nextToken());
            char[][] puzzle = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] cArr = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    puzzle[i][j] = cArr[j];
                }
            }
            var answer = Integer.MAX_VALUE;
            for (int nd = 0; nd <= n - 8; nd++) {
                for (int md = 0; md <= m - 8; md++) {
                    for (int t = 0; t < 2; t++) {
                        var start = t == 0 ? 'B' : 'W';
                        var changeCnt = 0;
                        for (int i = nd; i < 8 + nd; i++) {
                            for (int j = md; j < 8 + md; j++) {
                                if (start == puzzle[i][j]) {
                                    changeCnt++;
                                }
                                start = start == 'B' ? 'W' : 'B';
                            }
                            start = start == 'B' ? 'W' : 'B';
                        }
                        answer = Math.min(changeCnt, answer);
                    }
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}