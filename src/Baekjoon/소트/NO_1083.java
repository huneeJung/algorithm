package Baekjoon.소트;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1083 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var numCnt = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < numCnt; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            var changeCnt = Integer.parseInt(br.readLine());
            var j = 0;
            while (changeCnt > 0 && j < numCnt) {
                var lastIndex = j + changeCnt >= numCnt ? numCnt - 1 : j + changeCnt;
                var maxNum = 0;
                var maxIndex = -1;
                for (int i = j; i <= lastIndex; i++) {
                    if (maxNum < list.get(i)) {
                        maxNum = list.get(i);
                        maxIndex = i;
                    }
                }
                list.add(j, list.get(maxIndex));
                list.remove(maxIndex + 1);
                changeCnt = changeCnt - (maxIndex - j);
                j++;
            }
            var sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append(" ");
            }
            bw.write(sb.toString());
        }
    }
}
