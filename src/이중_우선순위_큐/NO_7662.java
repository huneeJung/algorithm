package 이중_우선순위_큐;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NO_7662 {

    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final int REMOVE_MIN = -1;
    private static final int REMOVE_MAX = 1;

    public static void main(String[] args) throws IOException {
        try(
            var br = new BufferedReader(new InputStreamReader(System.in));
            var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            var testCase = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < testCase ; i++){
                TreeMap<Integer,Integer> treeMap = new TreeMap<>();
                var cnt = Integer.parseInt(br.readLine());
                for(int j = 0 ; j < cnt ; j ++) {
                    var st = new StringTokenizer(br.readLine(), " ");
                    var command = st.nextToken();
                    var num = Integer.parseInt(st.nextToken());
                    if(command.equals(INSERT)) {
                        treeMap.merge(num, 1 , Integer::sum);
                    }
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    if(command.equals(DELETE)){
                        var key = num == REMOVE_MAX ? treeMap.lastKey() : treeMap.firstKey();
                        var numCnt = treeMap.get(key);
                        if(numCnt == 1){
                            treeMap.remove(key);
                        }else{
                            treeMap.merge(key,-1,Integer::sum);
                        }
                    }
                }
                if(treeMap.isEmpty()){
                    bw.write("EMPTY"+"\n");
                }else{
                    bw.write(treeMap.lastKey() + " " + treeMap.firstKey()+"\n");
                }
            }
        }
    }
}
