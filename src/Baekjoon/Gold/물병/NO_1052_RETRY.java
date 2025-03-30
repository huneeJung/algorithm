package Baekjoon.Gold.물병;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1052_RETRY {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            var water = Integer.parseInt(st.nextToken());
            var remaining = water;
            var bottle = Integer.parseInt(st.nextToken());

            var bitCount = Integer.bitCount(water);
            int check = 1 << 24;

            var answer = 0;
            if (bottle < bitCount) {
                while (check != 0) {
                    if ((check & water) != 0) {
                        if (bottle == 1) break;
                        bottle--;
                        remaining -= check;
                    }
                    check = check >> 1;
                }
                answer = (check << 1) - remaining;
            }
            bw.write(String.valueOf(answer));
        }
    }
}
