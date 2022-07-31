package 학교수업.Other_Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.programiz.com/dsa/huffman-coding

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

public class Huffman {
    
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && !(root.c.equals("_"))) {
            
            System.out.println(root.c + "   |  " + s);

            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {

        // OPTION 1
        String[] StringArray = { "A", "B", "C", "D"};
        int[] Stringfreq = { 5, 1, 6, 3 };
        int n = StringArray.length;

        // OPTION 2 
        // TO 문자열 자체로 주어졌을때 문자배열과 빈도수배열로 
        // String s = "ACCDDAACCAABCCD";

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = StringArray[i];
            hn.item = Stringfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = "-";
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }

        System.out.println(" Char | Huffman code ");
        System.out.println("--------------------");
        printCode(root, "");
    }
}
