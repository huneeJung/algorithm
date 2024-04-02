package Baekjoon.Gold.회전_초밥;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NO_15961 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine());
            var plateCnt = Integer.parseInt(st.nextToken());
            var plateNoLimit = Integer.parseInt(st.nextToken());
            var eventAmount = Integer.parseInt(st.nextToken());
            var eventPlateNo = Integer.parseInt(st.nextToken());

            int[] plateArr = new int[plateCnt + eventAmount - 1];
            for (int i = 0; i < plateCnt; i++) {
                plateArr[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < eventAmount - 1; i++) {
                plateArr[plateCnt + i] = plateArr[i];
            }

            var after = 0;
            var before = 0;
            var plateInfo = new PlateInfo(eventPlateNo);
            var answer = 0;
            while (after <= plateArr.length) {
                if (plateInfo.plateCnt == eventAmount) {
                    answer = Math.max(answer, plateInfo.getPlateNoSetSize());
                    plateInfo.removePlateNo(plateArr[before]);
                    before++;
                }
                if (after == plateArr.length) break;
                while (plateInfo.plateCnt < eventAmount) {
                    plateInfo.addPlateNo(plateArr[after]);
                    after++;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}

class PlateInfo {
    public final int eventPlateNo;
    public int plateCnt;
    public Map<Integer, Integer> plateNoMap = new HashMap<>();

    public PlateInfo(int eventPlateNo) {
        this.eventPlateNo = eventPlateNo;
        this.plateCnt = 0;
    }

    public void addPlateNo(int plateNo) {
        plateNoMap.merge(plateNo, 1, Integer::sum);
        plateCnt++;
    }

    public void removePlateNo(int plateNo) {
        if (plateNoMap.get(plateNo) == 1) {
            plateNoMap.remove(plateNo);
        } else {
            plateNoMap.merge(plateNo, -1, Integer::sum);
        }
        plateCnt--;
    }

    public int getPlateNoSetSize() {
        var size = plateNoMap.size();
        if (plateNoMap.containsKey(eventPlateNo)) {
            return size;
        }
        return size + 1;
    }
}