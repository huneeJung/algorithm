package Baekjoon.Gold.N으로_만들기;

import java.io.*;
import java.util.*;

public class NO_17255{
    private static char [] arr;
    private static Set<String> set = new HashSet<>();
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var num = br.readLine();
            arr = num.toCharArray();
            for(int i = 0 ; i < arr.length ; i++){
                var str = arr[i]+"";
                dfs(i,i,str,str);
            }
            bw.write(String.valueOf(set.size()));
        }
    }
    private static void dfs(int leftIndex, int rightIndex, String str, String path){
        if(leftIndex == 0 && rightIndex == arr.length-1){
            set.add(path);
            return;
        }
        if(leftIndex>0){
            var nextNum = arr[leftIndex-1]+str;
            dfs(leftIndex-1,rightIndex,nextNum,path+" "+nextNum);
        }
        if(rightIndex<arr.length-1){
            var nextNum = str+arr[rightIndex+1];
            dfs(leftIndex,rightIndex+1,nextNum,path+" "+nextNum);
        }
    }
}