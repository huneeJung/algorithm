package Baekjoon.Gold.가장_가까운_공통_조상;

import java.io.*;
import java.util.*;

public class NO_3584 {

    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            while (caseCnt > 0) {
                map = new HashMap<>();
                var cnt = Integer.parseInt(br.readLine());
                for (int i = 0; i < cnt - 1; i++) {
                    var st = new StringTokenizer(br.readLine(), " ");
                    var num1 = Integer.parseInt(st.nextToken());
                    var num2 = Integer.parseInt(st.nextToken());
                    map.put(num2, num1);
                }
                var st = new StringTokenizer(br.readLine(), " ");
                var num1 = Integer.parseInt(st.nextToken());
                var num2 = Integer.parseInt(st.nextToken());
                List<Integer> list1 = new ArrayList<>(num1);
                List<Integer> list2 = new ArrayList<>(num2);
                dfs(list1, num1);
                dfs(list2, num2);
                list1.add(0, num1);
                list2.add(0, num2);
                var exist = false;
                var answer = 0;
                for (int num1_ : list1) {
                    for (int num2_ : list2) {
                        if (num1_ == num2_) {
                            answer = num1_;
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        break;
                    }
                }
                bw.write(String.valueOf(answer));
                bw.newLine();
                caseCnt--;
            }
        }
    }

    private static void dfs(List<Integer> list, int num) {
        if (!map.containsKey(num)) {
            return;
        }
        var parent = map.get(num);
        list.add(parent);
        dfs(list, parent);
    }
}