package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class 비밀_메뉴 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var secretLen = Integer.parseInt(st.nextToken());
            var buttonCnt = Integer.parseInt(st.nextToken());
            var secretLimitNum = Integer.parseInt(st.nextToken());
            var sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < secretLen; i++) {
                sb.append(st.nextToken());
            }
            String secretKey = sb.toString();
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < buttonCnt; i++) {
                sb.append(st.nextToken());
                if (sb.length() == secretLen) {
                    if (secretKey.equals(sb.toString())) {
                        bw.write("secret");
                        return;
                    } else {
                        sb.deleteCharAt(0);
                    }
                }
            }
            bw.write("normal");
        }
    }
}
