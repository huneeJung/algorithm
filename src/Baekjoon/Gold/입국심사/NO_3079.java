package Baekjoon.Gold.입국심사;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class NO_3079 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var checkPointCnt = Integer.parseInt(st.nextToken());
            var peopleCnt = Integer.parseInt(st.nextToken());

            PriorityQueue<CheckPoint> q = new PriorityQueue<>((p1, p2) -> {
                if (p1.cnt == 0 && p2.cnt == 0) {
                    return p1.time - p2.time;
                } else {
                    return (p1.time * p1.cnt) - (p2.time * p2.cnt);
                }
            });
            for (int i = 0; i < checkPointCnt; i++) {
                var checkPoint = new CheckPoint(Integer.parseInt(br.readLine()));
                q.add(checkPoint);
            }

            var totalTime = -1;
            while (!q.isEmpty()) {
                var cp = q.poll();
                totalTime++;
                if (cp.time * cp.cnt <= totalTime) {
                    cp.cnt++;
                    if (peopleCnt <= 0) {
                        continue;
                    }
                    peopleCnt--;
                }
                q.add(cp);
            }
            bw.write(String.valueOf(totalTime));
        }
    }
}

class CheckPoint {
    public int time;
    public int cnt = 0;

    public CheckPoint(int time) {
        this.time = time;
    }
}