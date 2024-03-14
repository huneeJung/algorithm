package Baekjoon.Gold.신기한_소수;

import java.io.*;
import java.util.*;

public class NO_2023{
    private static StringBuilder sb = new StringBuilder();
    private static int length;
    public static void main(String [] args)throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            length = Integer.parseInt(br.readLine());
            dfs(1,0);
            bw.write(sb.toString());
        }
    }
    public static void dfs(int len, int n){
        if(len > length){
            sb.append(n).append("\n");
            return;
        }
        for(int i = 1 ; i < 10 ; i++){
            var num = n *10 + i;
            if(num>=2&&check(num)) dfs(len+1,num);
        }
    }
    public static boolean check(int num){
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}