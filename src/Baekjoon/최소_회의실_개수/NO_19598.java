package Baekjoon.최소_회의실_개수;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_19598 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            List<int[]> scrumList = new ArrayList<>();
            for (int i = 0; i < caseCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                scrumList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            scrumList.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            List<Integer> endTimeOfRoom = new ArrayList<>();
            endTimeOfRoom.add(scrumList.get(0)[1]);
            for (int i = 1; i < scrumList.size(); i++) {
                var scrum = scrumList.get(i);
                boolean flag = false;
                for (int j = 0; j < endTimeOfRoom.size(); j++) {
                    var endTime = endTimeOfRoom.get(j);
                    if (scrum[0] >= endTime) {
                        flag = true;
                        endTimeOfRoom.remove(j);
                        endTimeOfRoom.add(scrum[1]);
                        break;
                    }
                }
                if (!flag) {
                    endTimeOfRoom.add(scrum[1]);
                }
            }
            bw.write(String.valueOf(endTimeOfRoom.size()));
        }
    }
}