package Baekjoon.Gold.캐슬_디펜스;

import java.io.*;
import java.util.*;

public class NO_17135{
    private static int [][] map;
    private static int xSize;
    private static int ySize;
    private static int range;
    private static Set<String> [] dp;
    private static int [] dx = {-1,0,0};
    private static int [] dy = {0,-1,1};
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var st = new StringTokenizer(br.readLine()," ");
            xSize = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());
            range = Integer.parseInt(st.nextToken());
            map = new int[xSize][ySize];
            for(int i = 0 ; i < xSize ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < ySize ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            attack();
            Arrays.sort(dp,(o1, o2) -> o2.size()-o1.size());
            bw.write(String.valueOf(dp[0].size() + dp[1].size() + dp[2].size()));
        }
    }
    private static void attack(){
        dp = new HashSet[ySize];
        var x = xSize-1;
        while(x>0){
            for(int i = 0 ; i < ySize ; i++){
                bfs(new int[]{x,i,1});
            }
            x--;
            for(int k = 0 ; k < xSize ; k++){
                for(int j = 0 ; j < ySize ; j++){
                    System.out.print(map[k][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    private static void bfs(int [] start){
        Queue<int []> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            var location = q.poll();
            for(int i = 0 ; i < 3 ; i++){
                var x = location[0] + dx[i];
                var y = location[1] + dy[i];
                if(x<0 || y<0 || x>=xSize || y>=ySize || location[2]>range) continue;
                if(map[x][y] == 1){
                    map[x][y] = 0;
                    dp[y].add(x+"_"+y);
                    return;
                }
                q.add(new int[]{x,y,location[2]+1});
            }
        }
    }
}