package Softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 우물_안_개구리 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int people = Integer.parseInt(st.nextToken());
            int relationship = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < people; i++) {
                list.add(new int[]{Integer.parseInt(st.nextToken()), 1});
            }
            for (int i = 0; i < relationship; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int[] weight1 = list.get(Integer.parseInt(st.nextToken()) - 1);
                int[] weight2 = list.get(Integer.parseInt(st.nextToken()) - 1);
                if (weight1[0] > weight2[0]) {
                    weight2[1] = 0;
                } else if (weight1[0] < weight2[0]) {
                    weight1[1] = 0;
                } else {
                    weight1[1] = 0;
                    weight2[1] = 0;
                }
            }
            int answer = 0;
            for (int[] p : list) {
                if (p[1] == 1) answer++;
            }
            bw.write(String.valueOf(answer));
        }
    }
}
