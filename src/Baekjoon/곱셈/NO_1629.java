package Baekjoon.곱셈;

import java.io.*;
import java.util.StringTokenizer;

public class NO_1629 {

    private static long num2;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            long num = Long.parseLong(st.nextToken());
            long exponent = Long.parseLong(st.nextToken());
            num2 = Long.parseLong(st.nextToken());
            var result = divisionProcess(num, exponent);
            bw.write(String.valueOf(result));
        }
    }

    private static long divisionProcess(long num, long exponent) {
        if (exponent == 1) {
            return num % num2;
        }
        var temp = divisionProcess(num, exponent / 2);
        if (exponent % 2 == 1) {
            return (temp * temp % num2) * num % num2;
        }
        return ((temp % num2) * (temp % num2)) % num2;
    }
}