package Softeer.Lv_2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 금고털이 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int bagWeight = Integer.parseInt(st.nextToken());
            int metalCnt = Integer.parseInt(st.nextToken());
            Queue<int[]> metalQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for (int i = 0; i < metalCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                metalQueue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            int[] bag = {bagWeight, 0};
            while (!metalQueue.isEmpty()) {
                int[] metal = metalQueue.poll();
                if (bag[0] >= metal[0]) {
                    bag[1] += metal[0] * metal[1];
                    bag[0] -= metal[0];
                } else {
                    bag[1] += bag[0] * metal[1];
                    bag[0] = 0;
                    break;
                }
            }
            bw.write(String.valueOf(bag[1]));
        }
    }
}
