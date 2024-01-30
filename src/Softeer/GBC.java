package Softeer;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GBC {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> limitQueue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                limitQueue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            int[][] speed = new int[m][2];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                speed[i][0] = Integer.parseInt(st.nextToken());
                speed[i][1] = Integer.parseInt(st.nextToken());
            }
            int i = 0;
            int answer = 0;
            while (!limitQueue.isEmpty()) {
                int[] limit = limitQueue.poll();
                while (limit[0] != 0 && i < m) {
                    int oriLimit = limit[0];
                    limit[0] = Math.max(limit[0] - speed[i][0], 0);
                    speed[i][0] = Math.max(speed[i][0] - oriLimit, 0);
                    int difference = speed[i][1] - limit[1];
                    answer = Math.max(difference, answer);
                    if (speed[i][0] == 0) {
                        i++;
                    }
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}
