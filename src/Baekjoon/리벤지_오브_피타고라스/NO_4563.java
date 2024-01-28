package Baekjoon.리벤지_오브_피타고라스;

import java.io.*;

public class NO_4563 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            while (true) {
                int a = Integer.parseInt(br.readLine());
                if (a == 0) {
                    break;
                }
                var cnt = 0;
                long aPow = (long) Math.pow(a, 2);
                for (long i = 1; i <= a; i++) {
                    if (aPow % i == 0) {
                        long cmb = i;
                        long cpb = aPow / i;
                        long bpb = cpb - cmb;
                        long cpc = cpb + cmb;
                        // b > a 보다 크고, b, c의 값이 자연수인지 검증
                        if (bpb / 2 > a && bpb % 2 == 0 && cpc % 2 == 0) {
                            cnt++;
                        }
                    }
                }
                bw.write(cnt + "\n");
            }
        }
    }
}
