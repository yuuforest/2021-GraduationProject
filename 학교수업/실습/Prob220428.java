package 학교수업.실습;

import java.util.PriorityQueue;
import java.util.Comparator;

class HuffmanNode {
    int item;
    String c;
    HuffmanNode left;
    HuffmanNode right;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

// IMplementing the huffman algorithm
public class Prob220428 {
    public static void printCode(HuffmanNode root, String s) {
      
        if (root.left == null && root.right == null) {

            //  && !(root.c).equals("-")
            System.out.println(root.c + " " + s);

            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {

        // EX1
        // String[] stringArray = { "r", "A", "B", "C", "D", "E", "F"};
        // int[] stringfreq = { 27, 15, 12, 9, 5, 10, 11};
        // int n = stringArray.length;

        // EX2
        String[] stringArray = { "ROOT", "ABC", "ABCC", "AB", "A", "B", "BABA"};
        int[] stringfreq = { 27, 12, 7, 19, 35, 40, 15};
        int n = stringArray.length;

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        // 전체 내용 insert
        for (int i = 0; i < n; i++) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = stringArray[i];
            hn.item = stringfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            // remove
            HuffmanNode x = q.peek();
            q.poll();

            // remove
            HuffmanNode y = q.peek();
            q.poll();

            // new node
            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = "-";
            f.left = x;
            f.right = y;
            root = f;

            // insert
            q.add(f);
        }

        printCode(root, "");
    }
}
