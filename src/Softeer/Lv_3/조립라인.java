package Softeer.Lv_3;

import java.io.*;
import java.util.StringTokenizer;

public class 조립라인 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int cnt = Integer.parseInt(br.readLine());
            int[] aFactory = new int[cnt];
            int[] bFactory = new int[cnt];
            int[] moveToB = new int[cnt - 1];
            int[] moveToA = new int[cnt - 1];
            for (int i = 0; i < cnt - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                aFactory[i] = Integer.parseInt(st.nextToken());
                bFactory[i] = Integer.parseInt(st.nextToken());
                moveToB[i] = Integer.parseInt(st.nextToken());
                moveToA[i] = Integer.parseInt(st.nextToken());
            }
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            aFactory[cnt - 1] = Integer.parseInt(st.nextToken());
            bFactory[cnt - 1] = Integer.parseInt(st.nextToken());
            int[] dpA = new int[cnt];
            dpA[0] = aFactory[0];
            int[] dpB = new int[cnt];
            dpB[0] = bFactory[0];
            for (int i = 1; i < cnt; i++) {
                dpA[i] = Math.min(dpA[i - 1], dpB[i - 1] + moveToA[i - 1]) + aFactory[i];
                dpB[i] = Math.min(dpB[i - 1], dpA[i - 1] + moveToB[i - 1]) + bFactory[i];
            }
            bw.write(String.valueOf(Math.min(dpA[cnt - 1], dpB[cnt - 1])));
        }
    }
}
