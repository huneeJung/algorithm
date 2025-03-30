package Baekjoon.Silver.두수의_합;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NO_3273_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var count = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine());

            var numbers = new int[count];
            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            var sum = Integer.parseInt(br.readLine());
            var result = 0;

            // 중복 확인을 위한 HashSet
            var seen = new HashSet<Integer>();

            for (int num : numbers) {
                // sum - num이 이미 처리한 숫자인지 확인
                if (seen.contains(sum - num)) {
                    result++;
                }
                // 현재 숫자를 HashSet에 추가
                seen.add(num);
            }

            bw.write(String.valueOf(result));
        }
    }
}