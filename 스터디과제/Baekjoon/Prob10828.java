package 스터디과제.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.util.Stack;

// Stack

public class Prob10828 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // OPTION 1 : 19400Kb 364ms  ///////////////////////////////////////////

        ArrayList<Integer> stack = new ArrayList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (stack.size() == 0) System.out.println(-1);
                else {
                    System.out.println(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                if (stack.size() == 0) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("top")) {
                if (stack.size() == 0) System.out.println(-1);
                else System.out.println(stack.get(stack.size()-1));
            }
        }

        // OPTION 2 : 19880KB 236ms  ///////////////////////////////////////////

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (stack.size() == 0) sb.append(-1 + "\n");
                else {
                    sb.append(stack.get(stack.size()-1) + "\n");
                    stack.remove(stack.size()-1);
                }
            } else if (command.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (command.equals("empty")) {
                if (stack.size() == 0) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if (command.equals("top")) {
                if (stack.size() == 0) sb.append(-1 + "\n");
                else sb.append(stack.get(stack.size()-1) + "\n");
            }
        }

        // OPTION 3 : 18620KB 236ms  ///////////////////////////////////////////

        Stack<Integer> inStack = new Stack<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                inStack.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (inStack.size() == 0) sb.append(-1 + "\n");
                else sb.append(inStack.pop() + "\n");
            } else if (command.equals("size")) {
                sb.append(inStack.size() + "\n");
            } else if (command.equals("empty")) {
                if (inStack.size() == 0) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if (command.equals("top")) {
                if (inStack.size() == 0) sb.append(-1 + "\n");
                else sb.append(inStack.peek() + "\n");
            }
        }

        ///////////////////////////////////////////////////////////////////////
        
        System.out.println(sb);
    }
}
