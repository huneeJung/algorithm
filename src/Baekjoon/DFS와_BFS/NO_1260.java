package Baekjoon.DFS와_BFS;

import java.io.*;
import java.util.*;

public class NO_1260 {
    private static boolean[] visited;
    private static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var nodeSize = Integer.parseInt(st.nextToken());
            var trunkCnt = Integer.parseInt(st.nextToken());
            var startNum = Integer.parseInt(st.nextToken());
            map = new ArrayList[nodeSize + 1];
            visited = new boolean[nodeSize + 1];
            for (int i = 0; i < nodeSize + 1; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < trunkCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var num1 = Integer.parseInt(st.nextToken());
                var num2 = Integer.parseInt(st.nextToken());
                var nodeList1 = map[num1];
                nodeList1.add(num2);
                var nodeList2 = map[num2];
                nodeList2.add(num1);
            }
            var sb = new StringBuilder();
            Stack<Integer> s = new Stack<>();
            s.push(startNum);
            while (!s.isEmpty()) {
                var num = s.pop();
                if (visited[num]) continue;
                visited[num] = true;
                sb.append(num).append(" ");
                var nodeList = map[num];
                nodeList.sort(Collections.reverseOrder());
                for (int n : nodeList) {
                    if (!visited[n]) {
                        s.push(n);
                    }
                }
            }
            bw.write(sb.toString() + "\n");

            visited = new boolean[nodeSize + 1];
            sb = new StringBuilder();
            Queue<Integer> q = new LinkedList<>();
            q.add(startNum);
            while (!q.isEmpty()) {
                var num = q.poll();
                if (visited[num]) continue;
                visited[num] = true;
                sb.append(num).append(" ");
                var nodeList = map[num];
                Collections.sort(nodeList);
                for (int n : nodeList) {
                    if (!visited[n]) {
                        q.add(n);
                    }
                }
            }
            bw.write(sb.toString());
        }
    }
}