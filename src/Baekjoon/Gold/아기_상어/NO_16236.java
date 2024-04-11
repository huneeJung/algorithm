package Baekjoon.Gold.아기_상어;

import java.io.*;
import java.util.*;

public class NO_16236{
    private static int [] dx = {1,0,0,-1};
    private static int [] dy = {0,-1,1,0};
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var size = Integer.parseInt(br.readLine());
            int[][] map = new int[size][size];
            PriorityQueue<Fish> fishQ = new PriorityQueue<>((f1,f2)->{
                if(f1.size == f2.size){
                    if(f1.location[0] == f2.location[0]){
                        return f1.location[1] - f2.location[1];
                    }
                    return f1.location[0] - f2.location[0];
                }
                return f1.size-f2.size;
            });
            Shark shark = null;
            for(int i = 0 ; i < size ; i++){
                var st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < size ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0){
                        fishQ.add(new Fish(map[i][j],new int[]{i,j}));
                    }
                    if(map[i][j] == 9){
                        shark = new Shark(new int[]{i,j});
                    }
                }
            }

            List<Fish> tempList = new ArrayList<>();

            Fish target = null;
            Fish sameSizeTarget = null;
            var distance = Integer.MAX_VALUE;
            while(!fishQ.isEmpty()){
                var fish = fishQ.poll();
                if(fish.size > shark.size){
                    if(target!=null){
                        shark.time++;
                        fishQ.addAll(tempList);
                        target = null;
                        continue;
                    }else{
                        break;
                    }
                }
                // 사이즈가 같을 떄 코드 추가
                var diff = Math.abs(shark.location[0]-fish.location[0])
                        + Math.abs(shark.location[1]-fish.location[1]);
                if(distance > diff){
                    distance = diff;
                    if(target!=null) {
                        tempList.add(target);
                    }
                    target = fish;
                }else{
                    tempList.add(fish);
                }
            }
            bw.write(shark.time);

        }
    }
}

class Fish{
    public int size;
    public int [] location;

    public Fish(int size, int[] location){
        this.size = size;
        this.location = location;
    }
}

class Shark{
    public int size = 2;
    public int [] location;
    public int time = 0;

    public Shark(int[] location){
        this.location = location;
    }
}