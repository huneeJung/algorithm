package 암호만들기;

import java.io.*;
import java.util.*;

public class NO_1759 {
    private static int cnt;
    private static int len;
    private static String[] arr;
    private static final Set<String> ANSWER = new LinkedHashSet<>();
    private static final Map<String, Boolean> MAP = Map.of("a", true, "e", true, "i", true, "o", true, "u", true);

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            len = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            arr = new String[cnt];
            for (int i = 0; i < cnt; i++) {
                arr[i] = st.nextToken();
            }
            Arrays.sort(arr);
            dfs(0, "", false);
            for (String ans : ANSWER) {
                var check = 0;
                for (int i = 0; i < ans.length(); i++) {
                    var c = ans.substring(i, i + 1);
                    if (!MAP.containsKey(c)) {
                        check++;
                    }
                    if (check == 2) {
                        bw.write(ans + "\n");
                        break;
                    }
                }
            }
        }
    }

    private static void dfs(int index, String str, boolean flag) {
        if (flag && str.length() == len) {
            ANSWER.add(str);
            return;
        }
        for (int i = index; i < cnt; i++) {
            var c = arr[i];
            if (MAP.containsKey(c)) {
                dfs(i + 1, str + c, true);
            }
            dfs(i + 1, str + c, flag);
        }
    }
}
