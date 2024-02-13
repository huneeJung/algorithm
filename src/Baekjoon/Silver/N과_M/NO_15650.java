package Baekjoon.Silver.N과_M;

import java.io.*;
import java.util.StringTokenizer;

public class NO_15650 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[m];
            dfs(0, 0);
            bw.write(sb.toString());
        }
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1, i + 1);
        }
    }
}