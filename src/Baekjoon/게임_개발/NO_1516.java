package Baekjoon.게임_개발;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1516 {

    private static List<Integer>[] needs;
    private static int[] hourArr;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var buildingCnt = Integer.parseInt(br.readLine());
            hourArr = new int[buildingCnt + 1];
            needs = new List[buildingCnt + 1];
            needs[0] = List.of();
            for (int i = 1; i <= buildingCnt; i++) {
                var st = new StringTokenizer(br.readLine());
                String condition = null;
                var need = new ArrayList<Integer>();
                need.add(i); // 0 : 내 건물 번호
                var index = 0;
                while (!(condition = st.nextToken()).equals("-1")) {
                    if (index == 0) {
                        hourArr[i] = Integer.parseInt(condition); // 시간
                    } else {
                        need.add(Integer.parseInt(condition)); // 1~: 필요 건물번호들
                    }
                    index++;
                }
                needs[i] = need;
            }
            Arrays.sort(needs, (list1, list2) -> Integer.compare(list1.size(), list2.size()));
            int[] answer = new int[buildingCnt + 1];
            for (int i = 1; i <= buildingCnt; i++) {
                var need = needs[i];
                var buildIndex = need.get(0);
                answer[buildIndex] = hourArr[buildIndex];
                for (int j = 1; j < need.size(); j++) {
                    answer[buildIndex] += dfs(0, need.get(j));
                }
            }
            for (int h : answer) {
                bw.write(h + "\n");
            }
        }
    }

    private static int dfs(int hour, int buildingNum) {
        var need = needs[buildingNum];
        if (need.size() == 1) {
            hour += hourArr[need.get(0)];
            return hour;
        }
        for (int i = 1; i < need.size(); i++) {
            hour += dfs(hour, need.get(i));
        }
        return hour;
    }
}