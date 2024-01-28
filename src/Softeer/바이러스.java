package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class 바이러스 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long virusCnt = Integer.parseInt(st.nextToken());
            long mul = Integer.parseInt(st.nextToken());
            long second = Integer.parseInt(st.nextToken());
            while (0 < second) {
                virusCnt = (virusCnt * mul) % 1000000007;
                second--;
            }
            bw.write(String.valueOf(virusCnt));
        }
    }
}
