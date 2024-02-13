package Softeer.Lv_3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 택배_마스터_광우 {
    private static int railCnt;
    private static int weightLimit;
    private static int moveCnt;
    private static int[] railArr;
    private static boolean[] checked;
    private static int minWeight = Integer.MAX_VALUE;
    private static LinkedList<Integer> railList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            railCnt = Integer.parseInt(st.nextToken());
            weightLimit = Integer.parseInt(st.nextToken());
            moveCnt = Integer.parseInt(st.nextToken());
            railArr = new int[railCnt];
            checked = new boolean[railCnt];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < railCnt; i++) {
                railArr[i] = Integer.parseInt(st.nextToken());
            }
            dfs();
            bw.write(String.valueOf(minWeight));
        }
    }

    private static void dfs() {
        if (railList.size() == railCnt) {
            work();
            return;
        }
        for (int i = 0; i < railCnt; i++) {
            if (checked[i]) continue;
            railList.addLast(railArr[i]);
            checked[i] = true;
            dfs();
            railList.pollLast();
            checked[i] = false;
        }
    }

    private static void work() {
        int weightTotal = 0;
        int weight = 0;
        int workCnt = 0;
        int index = 0;
        while (workCnt < moveCnt) {
            int boxWeight = railList.get(index);
            if (boxWeight + weight <= weightLimit) {
                weight += boxWeight;
            } else {
                weightTotal += weight;
                weight = boxWeight;
                workCnt++;
            }
            index = index == railCnt - 1 ? 0 : index + 1;
        }
        minWeight = Math.min(minWeight, weightTotal);
    }
}
