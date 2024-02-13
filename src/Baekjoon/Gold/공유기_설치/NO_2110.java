package Baekjoon.Gold.공유기_설치;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_2110 {

    private static int houseCnt;
    private static int routerCnt;
    private static int[] houseArr;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            houseCnt = Integer.parseInt(st.nextToken());
            routerCnt = Integer.parseInt(st.nextToken());
            houseArr = new int[houseCnt];
            for (int i = 0; i < houseCnt; i++) {
                houseArr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(houseArr);
            var left = 1;
            var right = houseArr[houseArr.length - 1];
            while (left < right) {
                var mid = (left + right) / 2;
                if (binarySearch(mid) >= routerCnt) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 마지막에 서칭한 값을 체크
            if (binarySearch(left) < routerCnt) {
                left--;
            }
            bw.write(String.valueOf(left));
        }
    }

    private static int binarySearch(int distance) {
        var beforeLocation = houseArr[0];
        var installCnt = 1;
        for (int i = 1; i < houseCnt; i++) {
            if (houseArr[i] - beforeLocation >= distance) {
                beforeLocation = houseArr[i];
                installCnt++;
            }
        }
        return installCnt;
    }
}