package Baekjoon.사회망_서비스_SNS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_2533 {
    private static List<Integer>[] nodeInfo;
    private static int nodeCnt;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            nodeCnt = Integer.parseInt(br.readLine());
            dp = new int[nodeCnt + 1][2];
            nodeInfo = new List[nodeCnt + 1];
            visited = new boolean[nodeCnt + 1];

            for (int i = 0; i <= nodeCnt; i++) {
                nodeInfo[i] = new ArrayList<>();
            }
            for (int i = 0; i < nodeCnt - 1; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var parent = Integer.parseInt(st.nextToken());
                var child = Integer.parseInt(st.nextToken());
                nodeInfo[parent].add(child);
                nodeInfo[child].add(parent);
            }
            dfs(1);
            bw.write(String.valueOf(Math.min(dp[1][1], dp[1][0])));
        }
    }

    private static void dfs(int node) {
        dp[node][0] = 1;
        visited[node] = true;
        for (int child : nodeInfo[node]) {
            if (visited[child]) continue;
            dfs(child);
            dp[node][1] += dp[child][0];
            dp[node][0] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}