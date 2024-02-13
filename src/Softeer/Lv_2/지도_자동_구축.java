package Softeer.Lv_2;

import java.io.*;

public class 지도_자동_구축 {
    // i + (i-1)
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int stepLimit = Integer.parseInt(br.readLine());
            int step = 0;
            int num = 2;
            while (step < stepLimit) {
                num = 2 * num - 1;
                step++;
            }
            bw.write(String.valueOf(num * num));
        }
    }
}
