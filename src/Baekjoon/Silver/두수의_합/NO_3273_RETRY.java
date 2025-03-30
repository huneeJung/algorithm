package Baekjoon.Silver.두수의_합;

import java.io.*;
import java.util.ArrayList;
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
            var arr = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            var sum = Integer.parseInt(br.readLine());

            var arrSet = new HashSet<Integer>();
            var result = 0;
            for (Integer num1 : arr) {
                if (arrSet.contains(sum - num1)) {
                    result++;
                }
                arrSet.add(num1);
            }
            bw.write(String.valueOf(result));
        }
    }
}