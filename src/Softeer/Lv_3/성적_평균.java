package Softeer.Lv_3;

import java.io.*;
import java.util.StringTokenizer;

public class 성적_평균 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numCnt = Integer.parseInt(st.nextToken());
            int caseCnt = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] numArr = new int[numCnt];
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < caseCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int minIndex = Integer.parseInt(st.nextToken()) - 1;
                int maxIndex = Integer.parseInt(st.nextToken()) - 1;
                int sum = 0;
                for (int j = minIndex; j <= maxIndex; j++) {
                    sum += numArr[j];
                }
                double avg = (double) sum / (double) (maxIndex - minIndex + 1);
                bw.write(String.format("%.2f", avg));
                bw.write("\n");
            }
        }
    }
}
