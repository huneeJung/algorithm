package Baekjoon.Gold.우주_탐사선;

import java.io.*;
import java.util.*;

public class NO_17182{

    private static int planetCnt;
    private static boolean [] visited;
    private static int [][] costArr;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ){
            var st = new StringTokenizer(br.readLine()," ");
            planetCnt = Integer.parseInt(st.nextToken());
            var startRow = Integer.parseInt(st.nextToken());

            visited = new boolean[planetCnt];
            visited[startRow] = true;

            costArr = new int[planetCnt][planetCnt];
            for(int i = 0 ; i < planetCnt ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < planetCnt ; j++){
                    costArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int m = 0 ; m < planetCnt ; m++){
                for(int i = 0 ; i < planetCnt ; i++){
                    for(int j = 0 ; j < planetCnt ; j++){
                        costArr[i][j] = Math.min(costArr[i][j],costArr[i][m]+costArr[m][j]);
                    }
                }
            }

            dfs(startRow,1,0);
            bw.write(String.valueOf(answer));
        }
    }

    private static void dfs(int start, int depth, int sum){
        if(planetCnt == depth){
            answer = Math.min(answer,sum);
            return;
        }

        for(int i = 0; i < planetCnt ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i,depth+1,sum+costArr[start][i]);
            visited[i] = false;
        }
    }
}