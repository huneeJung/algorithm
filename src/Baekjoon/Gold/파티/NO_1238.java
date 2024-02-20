package Baekjoon.Gold.파티;

import java.io.*;
import java.util.*;

public class NO_1238 {

    private static Map<Integer, List<int[]>> roadMap = new HashMap<>();
    private static int townCnt;
    private static int destination;
    private static int returnPoint;
    private static int[] totalCost;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            townCnt = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());
            destination = Integer.parseInt(st.nextToken());
            totalCost = new int[townCnt + 1];
            Arrays.fill(totalCost, Integer.MAX_VALUE);
            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var start = Integer.parseInt(st.nextToken());
                var end = Integer.parseInt(st.nextToken());
                var cost = Integer.parseInt(st.nextToken());
                if (roadMap.containsKey(start)) {
                    roadMap.get(start).add(new int[]{end, cost});
                } else {
                    var list = new ArrayList<int[]>();
                    list.add(new int[]{end, cost});
                    roadMap.put(start, list);
                }
            }
            dijkstra();
            var answer = 0;
            for (int cost : totalCost) {
                if (cost == Integer.MAX_VALUE) continue;
                answer = Math.max(cost, answer);
            }
            bw.write(String.valueOf(answer));
        }
    }

    private static void dijkstra() {
        for (int i = 1; i <= townCnt; i++) {
            if (i == destination) continue;
            returnPoint = i;
            for (int[] road : roadMap.get(i)) {
                dfs(true, i, road);
            }
        }
    }

    private static void dfs(boolean isForward, int beforeStart, int[] start) {
        if (start[1] >= totalCost[returnPoint]) return;
        if (isForward && start[0] == destination) {
            dfs(false, beforeStart, start);
        }
        if (!isForward && start[0] == returnPoint) {
            totalCost[returnPoint] = Math.min(totalCost[returnPoint], start[1]);
            return;
        }
        for (int[] road : roadMap.get(start[0])) {
            if (beforeStart == road[0]) continue;
            dfs(isForward, start[0], new int[]{road[0], start[1] + road[1]});
        }
    }
}