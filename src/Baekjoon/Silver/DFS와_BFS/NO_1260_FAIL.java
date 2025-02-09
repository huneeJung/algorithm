package Baekjoon.Silver.DFS와_BFS;

import java.io.*;
import java.util.*;

public class NO_1260_FAIL {

    private static final Map<Integer, TreeSet<Integer>> graph = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var node = Integer.parseInt(st.nextToken());
            var branch = Integer.parseInt(st.nextToken());
            Integer startNode = Integer.parseInt(st.nextToken());

            visited = new boolean[node + 1];

            for (int i = 0; i < branch; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // DFS
            Integer next = startNode;
            bw.write(next.toString());
            while (true) {
                bw.write(" ");
                next = dfs(next);
                if (next == null || visited[next]) break;
                bw.write(next.toString());
            }
            bw.newLine();

            visited = new boolean[node + 1];
            // BFS
            var result = bfs(startNode);
            bw.write(result.toString());

        }
    }

    private static Integer dfs(Integer startNode) {
        visited[startNode] = true;
        var result = graph.get(startNode);
        if (result == null) return null;
        var data = result.stream().filter((v) -> !visited[v]).findFirst();
        return data.orElse(null);
    }

    private static StringBuilder bfs(Integer startNode) {

        var sb = new StringBuilder();
        var q = new ArrayDeque<Integer>();
        q.add(startNode);

        while (!q.isEmpty()) {
            var node = q.poll();
            if (!visited[node]) {
                visited[node] = true;
                sb.append(node).append(" ");
            } else {
                continue;
            }
            var value = graph.get(node);
            for (int n : value) {
                if (visited[n]) continue;
                q.add(n);
            }
        }
        return sb;
    }

    private static void put(Integer start, Integer end) {
        graph.computeIfAbsent(start, v -> new TreeSet<Integer>()).add(end);
        graph.computeIfAbsent(end, v -> new TreeSet<Integer>()).add(start);
    }

}