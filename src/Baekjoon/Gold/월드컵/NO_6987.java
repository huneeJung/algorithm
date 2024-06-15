package Baekjoon.Gold.월드컵;

import java.io.*;
import java.util.*;

public class NO_6987{
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            boolean [] impossible = new boolean[4];
            int [] winLossCal = new int[4];
            int [] drawCal = new int [4];
            for(int i = 0 ; i < 4 ; i++){
                var st = new StringTokenizer(br.readLine()," ");
                int [] rowSum = new int[18];
                for(int j = 0 ; j < 18 ; j++){
                    var num = Integer.parseInt(st.nextToken());
                    var country = j/3;
                    var isWinIndex = j%3==0;
                    var isDrawIndex = j%3==1;
                    var isLossIndex = j%3==2;

                    // 나라별 5번씩 경기가 진행되었는가?
                    rowSum[country] += num;
                    if(isLossIndex&&rowSum[country]!=5) impossible[i] = true;

                    // 조별 모든 승패의 합이 0 인가?
                    if(isWinIndex) winLossCal[i] += num;
                    if(isLossIndex) winLossCal[i] -= num;

                    // 무승부값이 유효한가?
                    if(isDrawIndex) {
                        if(drawCal[i] == 0){
                            drawCal[i] += num;
                        }else{
                            drawCal[i] -= num;
                        }
                    }

                }
            }
            var sb = new StringBuilder();
            for(int i = 0 ; i < 4 ; i++){
                if(!impossible[i] && winLossCal[i]==0 && drawCal[i]==0){
                    sb.append("1 ");
                }else{
                    sb.append("0 ");
                }
            }
            bw.write(sb.toString());
        }
    }
}