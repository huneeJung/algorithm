package Baekjoon.Gold.컵라면;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_1781 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var taskCnt = Integer.parseInt(br.readLine());
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < taskCnt; i++) {
                var st = new StringTokenizer(br.readLine(), " ");
                taskList.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            taskList.sort((task1, task2) -> {
                if (task1.deadLine == task2.deadLine) {
                    return task2.noodleCnt - task1.noodleCnt;
                }
                return task1.deadLine - task2.deadLine;
            });
            PriorityQueue<Task> q = new PriorityQueue<>((task1, task2) -> task1.noodleCnt - task2.noodleCnt);
            for (Task task : taskList) {
                if (q.size() >= task.deadLine) {
                    var amt = q.peek().noodleCnt;
                    if (amt < task.noodleCnt) {
                        q.poll();
                        q.add(task);
                    }
                } else {
                    q.add(task);
                }
            }
            var total = 0;
            while (!q.isEmpty()) {
                total += q.poll().noodleCnt;
            }
            bw.write(String.valueOf(total));
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