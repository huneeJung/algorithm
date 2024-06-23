package Baekjoon.Gold.연산자_끼워넣기_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NO_15659 {

    private static final char[] operationArr = {'+', '-', '*', '/'};
    private static final Map<Character, Integer> operationMap = new HashMap<>();
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int numCnt;
    private static int[] numArr;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            numCnt = Integer.parseInt(br.readLine());
            numArr = new int[numCnt];

            var st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            // + , - , * , /
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                operationMap.put(operationArr[i], Integer.parseInt(st.nextToken()));
            }
            dfs(numArr[0], 1, "");
            bw.write(max + "\n" + min);
        }
    }

    private static void dfs(int beforeNum, int curIndex, String str) {
        if (numCnt == curIndex) {
            operate(str + beforeNum);
            return;
        }

        var curNum = numArr[curIndex];

        for (int i = 0; i < 4; i++) {
            var key = operationArr[i];
            var value = operationMap.get(key);
            if (value == 0) continue;
            operationMap.put(key, value - 1);
            if (key == '*' || key == '/') {
                if (key == '*') {
                    dfs(beforeNum * curNum, curIndex + 1, str);
                } else {
                    dfs(beforeNum / curNum, curIndex + 1, str);
                }
            } else {
                dfs(curNum, curIndex + 1, str + beforeNum + key);
            }
            operationMap.put(key, value);
        }
    }

    private static void operate(String str) {
        var splitArr1 = str.split("\\+");
        var total1 = 0;
        for (String ele1 : splitArr1) {
            var splitArr2 = ele1.split("-");
            var total2 = Integer.parseInt(splitArr2[0]);
            for (int i = 1; i < splitArr2.length; i++) {
                total2 -= Integer.parseInt(splitArr2[i]);
            }
            total1 += total2;
        }
        min = Math.min(min, total1);
        max = Math.max(max, total1);
    }
}