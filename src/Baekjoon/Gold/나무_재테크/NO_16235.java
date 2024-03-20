package Baekjoon.Gold.나무_재테크;

import java.io.*;
import java.util.*;

public class NO_16235 {
    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var st = new StringTokenizer(br.readLine(), " ");
            var mapSize = Integer.parseInt(st.nextToken());
            var treeCnt = Integer.parseInt(st.nextToken());
            var period = Integer.parseInt(st.nextToken());

            var treeInvestment = new TreeInvestment(mapSize, period);
            treeInvestment.init();

            for (int i = 0; i < mapSize; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < mapSize; j++) {
                    treeInvestment.addNutrient(new Nutrient(i, j, Integer.parseInt(st.nextToken())));
                }
            }

            for (int i = 0; i < treeCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                var r = Integer.parseInt(st.nextToken());
                var c = Integer.parseInt(st.nextToken());
                var amount = Integer.parseInt(st.nextToken());
                treeInvestment.addSpringQueue(new Tree(r - 1, c - 1, amount));
            }

            treeInvestment.start();

            bw.write(String.valueOf(treeInvestment.alive()));
        }
    }
}

class Tree {
    public int r;
    public int c;
    public int age;

    public Tree(int r, int c, int age) {
        this.r = r;
        this.c = c;
        this.age = age;
    }
}

class Nutrient {
    public int r;
    public int c;
    public int amount;

    public Nutrient(int r, int c, int amount) {
        this.r = r;
        this.c = c;
        this.amount = amount;
    }
}

class TreeInvestment {

    private final int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
    private final int[] dc = {-1, 1, -1, 0, 1, -1, 0, 1};
    private final PriorityQueue<Tree> springQueue;
    private final Queue<Tree> summerQueue;
    private final Queue<Tree> autumnQueue;
    private final int[][] nutrientArr;
    private final int period;
    private final List<Nutrient> nutrientList;

    public TreeInvestment(int mapSize, int period) {
        this.springQueue = new PriorityQueue<>((tree1, tree2) -> tree1.age - tree2.age);
        this.summerQueue = new ArrayDeque<>();
        this.autumnQueue = new ArrayDeque<>();
        this.nutrientArr = new int[mapSize][mapSize];
        this.period = period;
        this.nutrientList = new ArrayList<>();
    }

    public void init() {
        for (int[] nutrientArr : nutrientArr) {
            Arrays.fill(nutrientArr, 5);
        }
    }

    public void addSpringQueue(Tree tree) {
        springQueue.add(tree);
    }

    public void addNutrient(Nutrient nutrient) {
        nutrientList.add(nutrient);
    }

    public void start() {
        var now = 0;
        while (now < period) {
            // Spring
            while (!springQueue.isEmpty()) {
                var tree = springQueue.poll();
                if (nutrientArr[tree.r][tree.c] >= tree.age) {
                    nutrientArr[tree.r][tree.c] -= tree.age;
                    tree.age++;
                    autumnQueue.add(tree);
                } else {
                    summerQueue.add(tree);
                }
            }
            // Summer
            while (!summerQueue.isEmpty()) {
                var tree = summerQueue.poll();
                nutrientArr[tree.r][tree.c] += tree.age / 2;
            }
            while (!autumnQueue.isEmpty()) {
                var tree = autumnQueue.poll();
                if (tree.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        var r = tree.r + dr[i];
                        var c = tree.c + dc[i];
                        if (r < 0 || c < 0 || r >= nutrientArr.length || c >= nutrientArr.length) continue;
                        springQueue.add(new Tree(r, c, 1));
                    }
                }
                springQueue.add(tree);
            }
            for (Nutrient nutrient : nutrientList) {
                nutrientArr[nutrient.r][nutrient.c] += nutrient.amount;
            }
            now++;
        }
    }

    public int alive() {
        return springQueue.size();
    }

}
