package Baekjoon.Bronze.소수_찾기;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1978 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var cnt = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            var answer = 0;
            for (int i = 0; i < cnt; i++) {
                var num = 2;
                var value = Integer.parseInt(st.nextToken());
                if (value == 1) continue;
                var flag = true;
                while (num < value) {
                    if (value % num == 0) {
                        flag = false;
                        break;
                    }
                    num++;
                }
                if (flag) {
                    answer++;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}