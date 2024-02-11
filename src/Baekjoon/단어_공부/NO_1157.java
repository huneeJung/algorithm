package Baekjoon.단어_공부;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class NO_1157 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var s = br.readLine();
            s = s.toUpperCase();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                map.merge(c, 1, Integer::sum);
            }
            var answer = ' ';
            var afterCnt = 0;
            var beforeCNt = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= afterCnt) {
                    beforeCNt = afterCnt;
                    afterCnt = entry.getValue();
                    answer = entry.getKey();
                }
            }
            if (afterCnt == beforeCNt) {
                bw.write("?");
            } else {
                bw.write(answer);
            }
        }
    }
}