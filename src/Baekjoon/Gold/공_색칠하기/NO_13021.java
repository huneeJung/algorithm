package Baekjoon.Gold.공_색칠하기;

import java.io.*;
import java.util.StringTokenizer;

public class NO_13021 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            // N, M 입력 받기
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            // 입력 받은 범위에 대해 특정 값을 할당
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                for (int j = L - 1; j < R; j++) {
                    arr[j] = i + 1;
                }
            }

            var cnt = 0L;
            boolean[] visited = new boolean[51];
            for (int num : arr) {
                if (!visited[num] && num != 0) {
                    cnt++;
                    visited[num] = true;
                }
            }

            // 0이 아닌 고유 값의 개수에 대한 2의 거듭제곱 값 출력
            bw.write((long) Math.pow(2, cnt) + "");
        }
    }
}
