package Baekjoon.Silver.물병;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1052 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var water = Integer.parseInt(st.nextToken());
            var bitCnt = Integer.bitCount(water);
            var remaining = water;
            var bottle = Integer.parseInt(st.nextToken());
            int check = 2 << 23;
            var answer = 0;
            if (bottle < bitCnt) {
                while (check != 0) {
                    if ((check & water) != 0) {
                        if (bottle == 1) break;
                        if (bottle > 1) {
                            remaining -= check;
                            bottle--;
                        }
                    }
                    check = check >> 1;
                }
                answer = (check << 1) - remaining;
            }
            bw.write(String.valueOf(answer));
        }
    }
}
