package Baekjoon.Gold.골목_대장_호석_기능성;

import java.io.*;
import java.util.StringTokenizer;

public class NO_20168 {

    private static int nodeCnt;
    private static int lineCnt;
    private static int startNode;
    private static int endNode;
    private static int priceLimit;
    private static boolean[] visited;
    private static int[][] priceArr;
    private static int answer = 1001;

    private static void dfs(int start, int max, int sum) {
        if (sum > priceLimit) return;
        if (start == endNode) {
            answer = Math.min(max, answer);
            return;
        }
        for (int node = 1; node <= nodeCnt; node++) {
            if (visited[node] || priceArr[start][node] == 0) continue;
            visited[node] = true;
            dfs(node, Math.max(max, priceArr[start][node]), sum + priceArr[start][node]);
            visited[node] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            nodeCnt = Integer.parseInt(st.nextToken());
            if (nodeCnt == 1) {
                bw.write("0");
            }
            lineCnt = Integer.parseInt(st.nextToken());
            startNode = Integer.parseInt(st.nextToken());
            endNode = Integer.parseInt(st.nextToken());
            priceLimit = Integer.parseInt(st.nextToken());

            visited = new boolean[nodeCnt + 1];

            priceArr = new int[nodeCnt + 1][nodeCnt + 1];
            for (int i = 0; i < lineCnt; i++) {
                st = new StringTokenizer(br.readLine());
                var node1 = Integer.parseInt(st.nextToken());
                var node2 = Integer.parseInt(st.nextToken());
                var price = Integer.parseInt(st.nextToken());
                priceArr[node1][node2] = price;
                priceArr[node2][node1] = price;
            }
            dfs(startNode, 0, 0);
            answer = answer == 1001 ? -1 : answer;
            bw.write(String.valueOf(answer));
        }
    }
}