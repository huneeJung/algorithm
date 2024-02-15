package Baekjoon.Gold.최소비용_구하기;

import java.io.*;
import java.util.*;

public class NO_1916{
    private static String end;
    private static Map<String,Integer> infoMap = new HashMap<String,Integer>();
    private static int cityCnt;
    private static int busCnt;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            cityCnt = Integer.parseInt(br.readLine());
            busCnt = Integer.parseInt(br.readLine());

            for(int i = 0 ; i < busCnt ; i++){
                var sb = new StringBuilder();
                var st = new StringTokenizer(br.readLine()," ");
                var city1 = Integer.parseInt(st.nextToken());
                var city2 = Integer.parseInt(st.nextToken());
                var price = Integer.parseInt(st.nextToken());
                infoMap.put(city1+"-"+city2,price);
            }
            var st = new StringTokenizer(br.readLine()," ");
            var start = st.nextToken();
            end = st.nextToken();
            dfs(start,0);
            bw.write(String.valueOf(answer));
        }
    }
    private static void dfs(String start,int totalPrice){
        if(answer <= totalPrice){
            return;
        }
        if(start.equals(end)){
            answer = totalPrice;
        }
        for(String key : infoMap.keySet()){
            String [] info = key.split("-");
            if(info[0].equals(start)){
                dfs(info[1],totalPrice+infoMap.get(key));
            }
        }
    }
}