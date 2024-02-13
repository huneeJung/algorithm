package Softeer.Lv_1;

import java.io.*;
import java.util.StringTokenizer;

public class AplusB {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int cnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                bw.write("Case #" + (i + 1) + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
                bw.write("\n");
            }
        }
    }
}
