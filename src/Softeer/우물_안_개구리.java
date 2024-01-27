package Softeer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 우물_안_개구리 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int people = Integer.parseInt(st.nextToken());
            int relationship = Integer.parseInt(st.nextToken());
            Set<Integer> s = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < people; i++) {
                s.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < relationship; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int f1 = Integer.parseInt(st.nextToken());
                int f2 = Integer.parseInt(st.nextToken());
                s.remove(f1);
            }
            bw.write(String.valueOf(s.size()));
        }
    }
}
