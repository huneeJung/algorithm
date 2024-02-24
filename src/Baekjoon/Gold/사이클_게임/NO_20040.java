package Baekjoon.Gold.사이클_게임;

import java.io.*;
import java.util.*;

public class NO_20040 {
    private static List<Map<Integer, Integer>> list;
    private static int n;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            Map<Integer, Integer> m = new HashMap<>();
            list.add(m);
            var cnt = Integer.parseInt(st.nextToken());
            var answer = 0;
            var breakFlag = false;
            for (int i = 0; i < cnt; i++) {
                answer++;
                st = new StringTokenizer(br.readLine(), " ");
                var num1 = Integer.parseInt(st.nextToken());
                var num2 = Integer.parseInt(st.nextToken());
                var num1Flag = false;
                var num2Flag = false;
                for (Map<Integer, Integer> map : list) {
                    if (map.containsKey(num1) && map.containsKey(num2) &&
                            (map.get(num1) == num2 || map.get(num2) == num1)) {
                        breakFlag = true;
                        break;
                    }
                    var compareNum1 = map.getOrDefault(num1, -1);
                    var compareNum2 = map.getOrDefault(num2, -1);
                    if (compareNum1 == -1) {
                        map.put(num1, compareNum2 == -1 ? num2 : compareNum2);
                        num1Flag = true;
                    }
                    if (compareNum2 == -1) {
                        map.put(num2, compareNum1 == -1 ? num1 : compareNum1);
                        num2Flag = true;
                    }
                }
                if (breakFlag) break;
                if (num1Flag || num2Flag) {
                    Map<Integer, Integer> newMap = new HashMap<>();
                    newMap.put(num1, num2);
                    newMap.put(num2, num1);
                    list.add(newMap);
                }
            }
            if (breakFlag) {
                bw.write(String.valueOf(answer));
            } else {
                bw.write("0");
            }
        }
    }
}