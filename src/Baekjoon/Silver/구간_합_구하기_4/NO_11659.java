package Baekjoon.Silver.구간_합_구하기_4;

import java.io.*;
import java.util.*;

public class NO_11659{
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var st = new StringTokenizer(br.readLine()," ");
            var numSize = Integer.parseInt(st.nextToken());
            var caseCnt = Integer.parseInt(st.nextToken());
            int [] num = new int[numSize+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 1 ; i <= numSize ; i++){
                num[i] = num[i-1] + Integer.parseInt(st.nextToken());
            }
            for(int i = 0 ; i < caseCnt ; i++){
                st = new StringTokenizer(br.readLine()," ");
                var start = Integer.parseInt(st.nextToken());
                var end = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(num[end] - num[start-1])+"\n");
            }
        }
    }
}