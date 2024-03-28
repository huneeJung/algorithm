package Baekjoon.Gold.가장_가까운_공통_조상;

import java.io.*;
import java.util.*;

public class NO_3584 {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            while (caseCnt > 0) {
                var cnt = Integer.parseInt(br.readLine());
                for (int i = 0; i < cnt - 1; i++) {
                    var st = new StringTokenizer(br.readLine(), " ");
                    var num1 = Integer.parseInt(st.nextToken());
                    var num2 = Integer.parseInt(st.nextToken());
                    if (map.containsKey(num2)) {
                        var list = map.get(num2);
                        list.add(num1);
                    } else {
                        var list = new ArrayList<Integer>();
                        list.add(num1);
                        map.put(num2, list);
                    }
                }
                var st = new StringTokenizer(br.readLine(), " ");
                var num1 = Integer.parseInt(st.nextToken());
                var num2 = Integer.parseInt(st.nextToken());
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                dfs(list1, num1);
                dfs(list2, num2);
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
                caseCnt--;
            }
        }
    }

    private static void dfs(List<Integer> list, int num) {
        if (!map.containsKey(num)) {
            return;
        }
        var parentList = map.get(num);
        for (int parent : parentList) {
            list.add(parent);
            dfs(list, parent);
        }
    }
}