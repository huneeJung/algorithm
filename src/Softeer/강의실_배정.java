package Softeer;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강의실_배정 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int cnt = Integer.parseInt(br.readLine());
            Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                q.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            int endTime = q.poll()[1];
            int answer = 1;
            while (!q.isEmpty()) {
                int[] scrum = q.poll();
                if (scrum[0] >= endTime) {
                    answer++;
                    endTime = scrum[1];
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}
