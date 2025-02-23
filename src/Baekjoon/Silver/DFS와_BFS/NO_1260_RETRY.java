package Baekjoon.Silver.DFS와_BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1260_RETRY {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] dfsVisited;
    private static boolean[] bfsVisited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            var node = Integer.parseInt(st.nextToken());
            var line = Integer.parseInt(st.nextToken());
            var startNode = Integer.parseInt(st.nextToken());

            dfsVisited = new boolean[node + 1];
            bfsVisited = new boolean[node + 1];

            for (int i = 0; i <= node; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                var node1 = Integer.parseInt(st.nextToken());
                var node2 = Integer.parseInt(st.nextToken());
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            for (int i = 0; i <= node; i++) graph.get(i).sort((a, b) -> a - b);
            dfs(startNode);
            bw.write(sb.toString());
            bw.write("\n");
            sb = new StringBuilder();
            bfs(startNode);
            bw.write(sb.toString());
        }
    }

    private static void dfs(int startNode) {
        if (dfsVisited[startNode]) return;
        dfsVisited[startNode] = true;
        sb.append(startNode).append(" ");
        var nodeGraph = graph.get(startNode);
        if (nodeGraph.isEmpty()) return;
        for (var node : nodeGraph) {
            if (dfsVisited[node]) continue;
            dfs(node);
        }
    }

    private static void bfs(int startNode) {
        var q = new ArrayDeque<Integer>();
        q.add(startNode);
        while (!q.isEmpty()) {
            startNode = q.poll();
            if (bfsVisited[startNode]) continue;
            bfsVisited[startNode] = true;
            sb.append(startNode).append(" ");
            var nodeGraph = graph.get(startNode);
            if (nodeGraph.isEmpty()) return;
            for (var node : nodeGraph) {
                if (bfsVisited[node]) continue;
                q.add(node);
            }
        }
    }
}