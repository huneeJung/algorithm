package Baekjoon.Gold.신기한_소수;

import java.io.*;

public class NO_2023 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var n = Integer.parseInt(br.readLine());
            int size = (int) Math.pow(10, n);
            for (int i = (int) Math.pow(10, n - 1); i < size; i++) {
                var str = String.valueOf(i);
                var flag = true;
                for (int j = str.length(); j > 0; j--) {
                    if (!search(Integer.parseInt(str.substring(0, j)))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sb.append(i).append("\n");
            }
            bw.write(sb.toString());
        }
    }

    private static boolean search(int num) {
        if (num < 2) return false;
        var flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}