package Baekjoon.Gold.회문;

import java.io.*;

public class NO_17609 {
    private static String str;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var cnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < cnt; i++) {
                str = br.readLine();
                var start = 0;
                var end = str.length() - 1;
                var diff = recursive(start, end, 0);
                if (diff == 0) {
                    bw.write("0\n");
                } else if (diff == 1) {
                    bw.write("1\n");
                } else {
                    bw.write("2\n");
                }
            }
        }
    }

    private static int recursive(int start, int end, int diff) {
        if (start >= end || diff >= 2) {
            return diff;
        }
        if (str.charAt(start) != str.charAt(end)) {
            diff++;
            var result1 = Integer.MAX_VALUE;
            var result2 = Integer.MAX_VALUE;
            if (str.charAt(start + 1) == str.charAt(end)) {
                result1 = recursive(start + 1, end, diff);
            }
            if (str.charAt(start) == str.charAt(end - 1)) {
                result2 = recursive(start, end - 1, diff);
            }
            diff = Math.min(result1, result2);
        } else {
            diff = recursive(start + 1, end - 1, diff);
        }
        return diff;
    }
}