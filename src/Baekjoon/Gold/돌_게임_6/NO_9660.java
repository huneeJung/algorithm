package Baekjoon.Gold.돌_게임_6;

import java.io.*;

public class NO_9660 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var num = Long.parseLong(br.readLine()) % 7;

            if (num != 0 && num != 2) {
                bw.write("SK");
            } else {
                bw.write("CY");
            }
        }
    }
}