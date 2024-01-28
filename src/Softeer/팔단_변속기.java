package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class 팔단_변속기 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int beforeGear = Integer.parseInt(st.nextToken());
            int afterGear = Integer.parseInt(st.nextToken());
            String key;
            if (beforeGear - 1 == afterGear) {
                key = "descending";
            } else {
                key = "ascending";
            }
            for (int i = 2; i < 8; i++) {
                int gear = Integer.parseInt(st.nextToken());
                if (key.equals("descending")) {
                    if (afterGear - 1 != gear) {
                        key = "mixed";
                        break;
                    }
                } else {
                    if (afterGear != gear - 1) {
                        key = "mixed";
                        break;
                    }
                }
                afterGear = gear;
            }
            bw.write(key);
        }
    }
}
