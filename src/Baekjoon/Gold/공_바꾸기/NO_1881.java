package Baekjoon.Gold.공_바꾸기;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NO_1881 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var ballCnt = Integer.parseInt(br.readLine());
            var ballMap = new HashMap<Integer, Integer>();
            var ballList = new ArrayList<Integer>();
            var st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < ballCnt; i++) {
                var num = Integer.parseInt(st.nextToken());
                ballMap.merge(num, 1, Integer::sum);
                ballList.add(num);
            }
            var ballSet = new HashSet<Integer>();
            var changeCnt = 0;
            for (int num : ballList) {
                if (!ballSet.contains(num) && ballSet.size() == 4) {
                    var amt = 100;
                    var minNo = -1;
                    for (int no : ballSet) {
                        if (ballMap.get(no) <= amt) {
                            amt = ballMap.get(no);
                            minNo = no;
                        }
                    }
                    ballSet.remove(minNo);
                    ballSet.add(num);
                    changeCnt++;
                }
                ballSet.add(num);
            }
            bw.write(String.valueOf(ballSet.size() + changeCnt));
        }
    }
}