package Softeer.미해결;

import java.io.*;
import java.util.*;

public class 사물인식_최소면적_산출_프로그램 {

    private static Map<Integer, List<int[]>> nodeMap;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeCnt = Integer.parseInt(st.nextToken());
            int colorCnt = Integer.parseInt(st.nextToken());
            nodeMap = new HashMap<>();
            for (int i = 0; i < nodeCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int[] node = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                int color = Integer.parseInt(st.nextToken());
                List<int[]> nodeList;
                if (nodeMap.containsKey(color)) {
                    nodeList = nodeMap.get(color);
                    nodeList.add(node);
                } else {
                    nodeList = new ArrayList<>();
                    nodeList.add(node);
                    nodeMap.put(color, nodeList);
                }
            }
            int answer = Integer.MAX_VALUE;
            for (Map.Entry<Integer, List<int[]>> entry : nodeMap.entrySet()) {
                Integer key = entry.getKey();
                List<int[]> nodeList = entry.getValue();
                for (Map.Entry<Integer, List<int[]>> entry2 : nodeMap.entrySet()) {
                    Integer key2 = entry2.getKey();
                    if (key.equals(key2)) continue;
                    List<int[]> nodeList2 = entry2.getValue();
                    for (int[] node : nodeList) {
                        for (int[] node2 : nodeList2) {
                            if (check(node, node2)) {
                                answer = Math.min(Math.abs(node[0] - node2[0]) * Math.abs(node[1] - node2[1]), answer);
                            }
                        }
                    }
                }
            }
            if (answer == Integer.MAX_VALUE) {
                bw.write("0");
                return;
            }
            bw.write(String.valueOf(answer));
        }
    }

    private static boolean check(int[] node1, int[] node2) {
        int minX = Math.min(node1[0], node2[0]);
        int maxX = Math.max(node1[0], node2[0]);
        int minY = Math.min(node1[1], node2[1]);
        int maxY = Math.max(node1[1], node2[1]);
        for (Map.Entry<Integer, List<int[]>> entry : nodeMap.entrySet()) {
            List<int[]> nodeList = entry.getValue();
            boolean flag = false;
            for (int[] node : nodeList) {
                if (node[0] >= minX && node[0] <= maxX && node[1] >= minY && node[1] <= maxY) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
