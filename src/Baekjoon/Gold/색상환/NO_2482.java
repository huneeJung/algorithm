package Baekjoon.Gold.색상환;

import java.io.*;

public class NO_2482 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            long n = Long.parseLong(br.readLine());
            long cnt = Long.parseLong(br.readLine());
            long half = n / 2;
            if (cnt > half) {
                bw.write("0");
                return;
            }
            long total = 1L;
            long divide = 1L;
            for (long i = cnt; i > 0; i--) {
                total *= half;
                divide *= i;
                total = total % 1000000003;
                divide = divide % 1000000003;
                half--;
            }
            total = total / divide;
            total *= 2;
            if (n % 2 == 1) {
                total *= n;
            }
            total = total % 1000000003;
            bw.write(String.valueOf(total));
        }
    }
}