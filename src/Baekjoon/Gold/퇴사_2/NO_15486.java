package Baekjoon.Gold.퇴사_2;

import java.io.*;
import java.util.*;

public class NO_15486{
    public static void main(String [] args)throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var days = Integer.parseInt(br.readLine());
            int [] dp = new int[days+1];
            int [][] arr = new int[days+1][3];
            for(int i = 1 ; i <= days ; i++){
                var st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = i;
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }
        }
    }
}