package Baekjoon.Silver.설탕_배달;

import java.io.*;

public class NO_2839 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var num = Integer.parseInt(br.readLine());
            int startNum = num / 5;
            while (startNum >= 0) {
                var value = num - 5 * startNum;
                if (value % 3 == 0) {
                    bw.write(String.valueOf(startNum + value / 3));
                    return;
                }
                startNum--;
            }
            bw.write("-1");
        }
    }
}