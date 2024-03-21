package Baekjoon.Gold.공격;

import java.io.*;
import java.util.*;

public class NO_1430{
    private static int [] dx = {1,-1,0,0};
    private static int [] dy = {0,0,1,-1};
    private static Set<String> towerKeySet = new HashSet<>();
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var st = new StringTokenizer(br.readLine()," ");
            var towerCnt = Integer.parseInt(st.nextToken());
            var range = Integer.parseInt(st.nextToken());
            var energy = Integer.parseInt(st.nextToken());
            var x = Integer.parseInt(st.nextToken());
            var y = Integer.parseInt(st.nextToken());

            int [][] towerArr = new int[towerCnt][2];
            for(int i = 0 ; i < towerCnt ; i++){
                st = new StringTokenizer(br.readLine()," ");
                towerKeySet.add(st.nextToken()+"_"+st.nextToken());
            }
            bfs(energy,x,y);
        }
    }
    private static void bfs(int initEnergy, int startX, int startY){
        PriorityQueue<Energy> q = new PriorityQueue<>((a,b)->b.amount-a.amount);
        Energy energy = new Energy(initEnergy,startX,startY);
        q.add(energy);
        while(!q.isEmpty()){
            var info = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                var x = info.x + dx[i];
                var y = info.y + dy[i];
                if(x<0||y<0||x>=1000||y>=1000||!towerKeySet.contains(x+"_"+y)) continue;

            }
        }
    }
}

class Energy {

    public final int initValue;
    public int x;
    public int y;
    public int amount;
    public int moveCnt;

    public Energy(int initValue, int x, int y){
        this.initValue = initValue;
        this.amount = initValue;
        this.x = x;
        this.y = y;
        this.moveCnt = 0;
    }

}