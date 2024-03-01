package Baekjoon.Gold.동전_분배;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1943 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var n = 0;
            while (n < 3) {
                n++;
                var caseCnt = Integer.parseInt(br.readLine());
                var priceArr = new boolean[100001];
                List<int[]> list = new ArrayList<>();
                var total = 0;
                for (int i = 0; i < caseCnt; i++) {
                    var st = new StringTokenizer(br.readLine());
                    var price = Integer.parseInt(st.nextToken());
                    var cnt = Integer.parseInt(st.nextToken());
                    list.add(new int[]{price, cnt});
                    total += price * cnt;
                }
                if (total % 2 != 0) {
                    bw.write("0\n");
                    continue;
                }
                var tot = 0;
                for (int[] arr : list) {
                    var price = arr[0];
                    var cnt = arr[1];
                    for (int j = 1; j <= cnt; j++) {
                        for (int k = Math.min(total / 2, tot + (j - 1) * price); k >= 1; k--) {
                            if (!priceArr[k]) continue;
                            priceArr[price + k] = true;
                            if (priceArr[total / 2]) {
                                break;
                            }
                        }
                        priceArr[price] = true;
                        if (priceArr[total / 2]) {
                            break;
                        }
                    }
                    tot += price * cnt;
                }
                if (priceArr[total / 2]) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
    }
}