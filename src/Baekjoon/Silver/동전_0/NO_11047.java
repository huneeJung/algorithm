package Baekjoon.Silver.동전_0;

import java.io.*;
import java.util.*;

public class NO_11047{
    public static void main(String [] args) throws IOException{
        try(
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var st = new StringTokenizer(br.readLine());
            var caseCnt = Integer.parseInt(st.nextToken());
            var targetPrice = Integer.parseInt(st.nextToken());
            int [] priceArr = new int[caseCnt];
            for(int i = 0 ; i < caseCnt ; i++){
                priceArr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(priceArr);
            var answer = 0;
            for(int i = caseCnt-1 ; i >=0 ; i--){
                var price = priceArr[i];
                if(price<=targetPrice){
                    answer = answer + targetPrice/price;
                    targetPrice %= price;
                }
                if(targetPrice==0){
                    break;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}