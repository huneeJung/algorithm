// 틀린 코드
//public class Main{
//    private static String end;
//    private static Map<String,Integer> infoMap = new HashMap<String,Integer>();
//    private static int cityCnt;
//    private static int busCnt;
//    private static int answer = Integer.MAX_VALUE;
//    public static void main(String [] args) throws IOException{
//        try(
//                var br = new BufferedReader(new InputStreamReader(System.in));
//                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
//        ){
//            cityCnt = Integer.parseInt(br.readLine());
//            busCnt = Integer.parseInt(br.readLine());
//
//            for(int i = 0 ; i < busCnt ; i++){
//                var st = new StringTokenizer(br.readLine()," ");
//                var city1 = Integer.parseInt(st.nextToken());
//                var city2 = Integer.parseInt(st.nextToken());
//                var price = Integer.parseInt(st.nextToken());
//                infoMap.put(city1+"-"+city2,price);
//            }
//            var st = new StringTokenizer(br.readLine()," ");
//            var start = st.nextToken();
//            end = st.nextToken();
//            dfs(start,0);
//            bw.write(String.valueOf(answer));
//        }
//    }
//    private static void dfs(String start,int totalPrice){
//        if(answer <= totalPrice){
//            return;
//        }
//        if(start.equals(end)){
//            answer = totalPrice;
//        }
//        for(String key : infoMap.keySet()){
//            String [] info = key.split("-");
//            if(info[0].equals(start)){
//                var price = infoMap.get(key);
//                dfs(info[1],totalPrice+price);
//            }
//        }
//    }
//}

package Baekjoon.Gold.최소비용_구하기;

import java.io.*;
import java.util.*;

public class NO_1916 {
    private static List<List<int[]>> infoList = new ArrayList<>();
    private static boolean[] visited;
    private static int[] value;

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var cityCnt = Integer.parseInt(br.readLine());
            var busCnt = Integer.parseInt(br.readLine());
            visited = new boolean[cityCnt + 1];
            value = new int[cityCnt + 1];

            for (int i = 0; i <= cityCnt; i++) {
                infoList.add(new ArrayList<>());
            }

            for (int i = 0; i < busCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                var city1 = Integer.parseInt(st.nextToken());
                var city2 = Integer.parseInt(st.nextToken());
                var price = Integer.parseInt(st.nextToken());
                infoList.get(city1).add(new int[]{city2, price});
            }
            var st = new StringTokenizer(br.readLine(), " ");
            var start = Integer.parseInt(st.nextToken());
            var end = Integer.parseInt(st.nextToken());
            dfs(new int[]{start, 0});
            bw.write(String.valueOf(value[end]));
        }
    }

    private static void dfs(int[] start) {
        Arrays.fill(value, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(start);
        value[start[0]] = 0;
        while (!q.isEmpty()) {
            var location = q.poll();
            if (visited[location[0]]) continue;
            visited[location[0]] = true;
            for (int[] lo : infoList.get(location[0])) {
                if (value[lo[0]] > location[1] + lo[1]) value[lo[0]] = location[1] + lo[1];
                q.add(new int[]{lo[0], location[1] + lo[1]});
            }
        }
    }
}