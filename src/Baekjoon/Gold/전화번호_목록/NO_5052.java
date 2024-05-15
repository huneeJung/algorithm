package Baekjoon.Gold.전화번호_목록;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class NO_5052 {

    public static void main(String[] args) throws IOException {
        try (
                var br = new BufferedReader(new InputStreamReader(System.in));
                var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            var caseCnt = Integer.parseInt(br.readLine());

            while (caseCnt > 0) {
                var numCnt = Integer.parseInt(br.readLine());
                var rootNode = new TrieNode();
                boolean isNotValid = false;
                for (int i = 0; i < numCnt; i++) {
                    var num = br.readLine();
                    if (isNotValid) continue;
                    isNotValid = save(rootNode, num);
                }
                if (isNotValid) {
                    bw.write("NO\n");
                } else {
                    bw.write("YES\n");
                }
                caseCnt--;
            }
        }
    }

    private static boolean save(TrieNode node, String str) {
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);

            if (node.childNode.containsKey(c)) {
                node = node.childNode.get(c);
                if (i == str.length() - 1 || node.terminal) {
                    return true;
                }
            } else {
                node.childNode.put(c, new TrieNode());
                node = node.childNode.get(c);
                if (i == str.length() - 1) {
                    node.terminal = true;
                }
            }
        }
        return false;
    }
}

class TrieNode {

    public Map<Character, TrieNode> childNode;
    public boolean terminal;

    public TrieNode() {
        this.childNode = new HashMap<>();
        this.terminal = false;
    }

}