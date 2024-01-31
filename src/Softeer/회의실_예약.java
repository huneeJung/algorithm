package Softeer;

import java.io.*;
import java.util.*;

public class 회의실_예약 {

    private static Map<String, List<int[]>> roomInfo = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var roomCnt = Integer.parseInt(st.nextToken());
            var scrumCnt = Integer.parseInt(st.nextToken());
            String[] roomNameArr = new String[roomCnt];
            for (int i = 0; i < roomCnt; i++) {
                roomNameArr[i] = br.readLine();
                roomInfo.put(roomNameArr[i], new ArrayList<>());
            }
            for (int i = 0; i < scrumCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var roomName = st.nextToken();
                var startTime = Integer.parseInt(st.nextToken());
                var endTime = Integer.parseInt(st.nextToken());
                List<int[]> scrumList = roomInfo.get(roomName);
                scrumList.add(new int[]{startTime, endTime});
            }
            Arrays.sort(roomNameArr);
            for (String roomName : roomNameArr) {
                List<int[]> scrumList = roomInfo.get(roomName);
                scrumList.sort((a, b) -> Integer.compare(a[0], b[0]));
                List<String> availableList = new ArrayList<>();
                var startTime = 9;
                for (int[] scrum : scrumList) {
                    if (startTime < scrum[0]) {
                        String c = startTime < 10 ? "0" : "";
                        availableList.add(c + "" + startTime + "-" + scrum[0]);
                    }
                    startTime = scrum[1];
                }
                if (startTime < 18) {
                    String c = startTime < 10 ? "0" : "";
                    availableList.add(c + "" + startTime + "-" + 18);
                }
                bw.write("Room " + roomName + ":\n");
                if (!availableList.isEmpty()) {
                    bw.write(availableList.size() + " available:\n");
                    for (String str : availableList) {
                        bw.write(str + "\n");
                    }
                } else {
                    bw.write("Not available\n");
                }
                if (!roomNameArr[roomCnt - 1].equals(roomName)) {
                    bw.write("-----\n");
                }
            }
        }
    }
}
