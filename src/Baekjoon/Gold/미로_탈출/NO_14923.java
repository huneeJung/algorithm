package Baekjoon.Gold.미로_탈출;

import java.io.*;
import java.util.*;

public class NO_14923{
    private static int xSize;
    private static int ySize;
    private static int [] de;
    private static int [][] map;
    private static boolean [][][] visited;
    private static int [] dx = {1,-1,0,0};
    private static int [] dy = {0,0,1,-1};
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ){
            var st = new StringTokenizer(br.readLine()," ");
            xSize = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());
            map = new int[xSize][ySize];
            visited = new boolean[2][xSize][ySize];
            st = new StringTokenizer(br.readLine());
            int [] lo = new int[]{
                    Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1
            };
            st = new StringTokenizer(br.readLine());
            de = new int[]{
                    Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1
            };
            for(int i = 0 ; i < xSize ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < ySize ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            var distance = bfs(lo);
            bw.write(String.valueOf(distance));
        }
    }

    private static int bfs(int [] start){
        Queue<Location> q = new ArrayDeque<>();
        visited[0][start[0]][start[1]] = true;
        q.add(new Location(start[0],start[1],0,0));
        while(!q.isEmpty()){
            var cu = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                var x = cu.x + dx[i];
                var y = cu.y + dy[i];
                if(x<0 || y<0 || x>=xSize || y>=ySize || visited[cu.broke][x][y]) continue;
                if(map[x][y] == 1){
                    if(cu.broke==1) continue;
                    visited[cu.broke][x][y] = true;
                    q.add(new Location(x,y,cu.distance+1,1));
                }else{
                    visited[cu.broke][x][y] = true;
                    q.add(new Location(x,y,cu.distance+1,cu.broke));
                }
                if(x==de[0] && y==de[1]){
                    return cu.distance + 1;
                }
            }
        }
        return -1;
    }

}
class Location{
    public int x;
    public int y;
    public int distance;
    public int broke;

    public Location(int x, int y, int distance, int broke){
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.broke = broke;
    }
}
