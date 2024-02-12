package Baekjoon.AC;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NO_5430 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var caseCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < caseCnt; i++) {
                var command = br.readLine();
                var arrSize = Integer.parseInt(br.readLine());
                var str = br.readLine();
                var arrStr = str.substring(1, str.length() - 1);
                String[] arr = arrStr.split(",");
                List<String> list = new ArrayList<>(Arrays.asList(arr));
                var flag = false;
                var reverseYN = false;
                for (int j = 0; j < command.length(); j++) {
                    if (command.charAt(j) == 'R') {
                        reverseYN = !reverseYN;
                    } else {
                        if (list.isEmpty() || list.get(0).isEmpty()) {
                            flag = true;
                            bw.write("error\n");
                            break;
                        }
                        if (reverseYN) {
                            list.remove(list.size() - 1);
                        } else {
                            list.remove(0);
                        }
                    }
                }
                if (reverseYN) {
                    Collections.reverse(list);
                }
                if (flag) continue;
                var sb = new StringBuilder();
                sb.append("[");
                for (String s : list) {
                    sb.append(s).append(",");
                }
                if (!list.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
                bw.write(sb.toString() + "\n");
            }
        }
    }
}