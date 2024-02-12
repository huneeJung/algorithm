package Baekjoon.연결_요소의_개수;

import java.io.*;
import java.util.*;

public class NO_11724 {
    private static boolean[] existed;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var nodeCnt = Integer.parseInt(st.nextToken());
            var trunkCnt = Integer.parseInt(st.nextToken());
            existed = new boolean[nodeCnt + 1];
            existed[0] = true;
            List<Set<Integer>> graphList = new ArrayList<>();
            if (trunkCnt == 0) {
                bw.write(String.valueOf(nodeCnt));
                return;
            }
            for (int i = 0; i < trunkCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var node1 = Integer.parseInt(st.nextToken());
                var node2 = Integer.parseInt(st.nextToken());
                existed[node1] = true;
                existed[node2] = true;
                if (graphList.isEmpty()) {
                    var graph = new HashSet<Integer>();
                    graph.add(node1);
                    graph.add(node2);
                    graphList.add(graph);
                } else {
                    var addCnt = 0;
                    Set<Integer> beforeSet;
                    for (Set<Integer> graph : graphList) {
                        if (graph.contains(node1) || graph.contains(node2)) {
                            beforeSet = graph;
                            graph.add(node1);
                            graph.add(node2);
                            addCnt++;
                            if (addCnt > 1) {
                                beforeSet.addAll(graph);
                                graph.clear();
                            }
                        }
                    }
                    if (addCnt == 0) {
                        var graph = new HashSet<Integer>();
                        graph.add(node1);
                        graph.add(node2);
                        graphList.add(graph);
                    }
                }
            }
            var answer = 0;
            for (Set<Integer> graph : graphList) {
                if (!graph.isEmpty()) {
                    answer++;
                }
            }
            for (boolean flag : existed) {
                if (!flag) {
                    answer++;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}