package Baekjoon.Gold.뮤탈리스크;

import java.io.*;
import java.util.*;

public class NO_12869{
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){

            var svcCnt = Integer.parseInt(br.readLine());
            var q = new PriorityQueue<Integer>(Collections.reverseOrder());
            var tempQ = new ArrayDeque<Integer>();

            var st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < svcCnt ; i++){
                q.add(Integer.parseInt(st.nextToken()));
            }

            var attackCnt = 0;
            while(!q.isEmpty()){
                attackCnt++;
                var damage = 9;
                for(int i = 0 ; i < 3; i++){
                    if(q.isEmpty()) break;
                    var scv = q.poll() - damage;
                    tempQ.add(scv);
                    damage /= 3;
                }
                while(!tempQ.isEmpty()){
                    var scv = tempQ.poll();
                    if(scv>0) q.add(scv);
                }
            }
            bw.write(String.valueOf(attackCnt));
        }
    }
}