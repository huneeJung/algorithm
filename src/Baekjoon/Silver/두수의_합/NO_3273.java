package Baekjoon.Silver.두수의_합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_3273 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var cnt = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            var target = Integer.parseInt(br.readLine());
            var answer = 0;
            var start = 0;
            var end = cnt - 1;
            while (start < end) {
                var sum = arr[start] + arr[end];
                if (sum == target) {
                    answer++;
                    start++;
                    end--;
                }
                if (sum > target) {
                    end--;
                }
                if (sum < target) {
                    start++;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}