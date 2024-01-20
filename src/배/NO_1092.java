package 배;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1092 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var craneCnt = Integer.parseInt(br.readLine());
            List<Integer> craneList = new ArrayList<>();
            var st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < craneCnt; i++) {
                craneList.add(Integer.parseInt(st.nextToken()));
            }
            craneList.sort((a, b) -> b.compareTo(a));
            var containerCnt = Integer.parseInt(br.readLine());
            List<Integer> containerList = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < containerCnt; i++) {
                containerList.add(Integer.parseInt(st.nextToken()));
            }
            containerList.sort((a, b) -> b.compareTo(a));
            var minute = 0;
            while (!containerList.isEmpty()) {
                var flag = false;
                var craneIndex = 0;
                var iterator = containerList.iterator();
                while (iterator.hasNext()) {
                    var container = iterator.next();
                    var crane = craneList.get(craneIndex);
                    if (crane >= container) {
                        iterator.remove();
                        flag = true;
                        craneIndex++;
                        if (craneIndex == craneCnt) {
                            break;
                        }
                    }
                }
                if (!flag) {
                    minute = -1;
                    break;
                }
                minute++;
            }
            bw.write(String.valueOf(minute));
        }
    }
}