package Baekjoon.좋은수열;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NO_2661 {
    private static List<String> list = new ArrayList<>();
    private static int len;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            len = Integer.parseInt(br.readLine());
            dfs(0, new StringBuilder());
            Collections.sort(list);
            bw.write(list.get(0));
        }
    }

    private static void dfs(int depth, StringBuilder sb) {
        if (!list.isEmpty() || check(sb)) {
            return;
        }
        if (depth == len) {
            list.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            dfs(depth + 1, new StringBuilder(sb).append(i));
        }
    }

    private static boolean check(StringBuilder sb) {
        int maxLen = sb.length();
        int startLen = 1;
        while (startLen * 2 <= sb.length()) {
            var lastStr = sb.substring(maxLen - startLen, maxLen);
            var compareStr = sb.substring(Math.max(maxLen - 2 * startLen, 0), maxLen - startLen);
            if (lastStr.equals(compareStr)) {
                return true;
            }
            startLen++;
        }
        return false;
    }
}