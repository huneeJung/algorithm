package Baekjoon.Gold.컵라면;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NO_1781 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var taskCnt = Integer.parseInt(br.readLine());
            List<Task> list = new ArrayList<>();
            for (int i = 1; i <= taskCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                list.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            list.sort((t1, t2) -> t2.noodleCnt - t1.noodleCnt);
            int[] indexArr = new int[taskCnt + 1];
            indexArr[0] = 1;
            var answer = 0;
            for (Task task : list) {
                var deadLine = task.deadLine;
                var noodleCnt = task.noodleCnt;
                var flag = false;
                if (indexArr[deadLine] == 0) {
                    indexArr[deadLine] = deadLine;
                    flag = true;
                } else {
                    var subDeadLine = indexArr[deadLine] - 1;
                    while (subDeadLine > 0) {
                        if (indexArr[subDeadLine] == 0) {
                            indexArr[subDeadLine] = subDeadLine;
                            flag = true;
                            break;
                        }
                        if (subDeadLine == 1) break;
                        indexArr[subDeadLine]--;
                        indexArr[deadLine] = indexArr[subDeadLine];
                        var newDeadLine = indexArr[subDeadLine - 1];
                        if (newDeadLine == 0) {
                            indexArr[subDeadLine - 1] = subDeadLine - 1;
                            flag = true;
                            break;
                        }
                        subDeadLine = newDeadLine;
                    }
                }
                if (flag) {
                    answer += noodleCnt;
                }
            }
            bw.write(String.valueOf(answer));
        }
    }
}

class Task {
    public int deadLine;
    public int noodleCnt;

    public Task(int deadLine, int noodleCnt) {
        this.deadLine = deadLine;
        this.noodleCnt = noodleCnt;
    }
}