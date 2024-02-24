package Baekjoon.Gold.차트;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_1239 {

    private static int n;
    private static Integer[] arr;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            arr = new Integer[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (a, b) -> b - a);
            dfs(0, 0, 0);
            bw.write(String.valueOf(answer));
        }
    }

    private static void dfs(int index, int lineCnt, int numCnt) {
        if (n == numCnt) {
            answer = Math.max(answer, lineCnt);
            return;
        }
        var num = 0;
        for (int i = index; i < n; i++) {
            if (visited[i]) continue;
            if (num == 0) {
                visited[i] = true;
                num = arr[i];
                continue;
            }
            if (num == arr[i]) {
                visited[i] = true;
                dfs(index + 1, lineCnt + 1, numCnt + 2);
                visited[i] = false;
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (num == arr[i] + arr[j]) {
                    visited[i] = true;
                    visited[j] = true;
                    dfs(index + 1, lineCnt + 1, numCnt + 3);
                    visited[i] = false;
                    visited[j] = false;
                }
            }
        }
    }
}