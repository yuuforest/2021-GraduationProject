package 스터디과제.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.util.LinkedList;
import java.util.Queue;

// Queue

public class Prob18258 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // OPTION 1 : 시간초과  //////////////////////////////////////////////

        ArrayList<Integer> queue = new ArrayList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (queue.size() == 0) sb.append(-1 + "\n");
                else {
                    sb.append(queue.get(0) + "\n");
                    queue.remove(0);
                }
            } else if (command.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (command.equals("empty")) {
                if (queue.size() == 0) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if (command.equals("front")) {
                if (queue.size() == 0) sb.append(-1 + "\n");
                else sb.append(queue.get(0) + "\n");
            } else if (command.equals("back")) {
                if (queue.size() == 0) sb.append(-1 + "\n");
                else sb.append(queue.get(queue.size()-1) + "\n");
            }
        }

        // OPTION 2 : 시간초과  //////////////////////////////////////////////

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken())); 
                    break;
                case "pop":
                    if (queue.size() == 0) sb.append(-1 + "\n");
                    else {
                        sb.append(queue.get(0) + "\n");
                        queue.remove(0);
                    } break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.size() == 0) sb.append(1 + "\n");
                    else sb.append(0 + "\n"); 
                    break;
                case "front":
                    if (queue.size() == 0) sb.append(-1 + "\n");
                    else sb.append(queue.get(0) + "\n");
                    break;
                case "back":
                    if (queue.size() == 0) sb.append(-1 + "\n");
                    else sb.append(queue.get(queue.size()-1) + "\n");
                    break;
            }
        }

        // OPTION 3 : 349108KB 1568ms  ///////////////////////////////////////////
        // OPTION 4 : 349412KB 1484ms  ///////////////////////////////////////////

        Queue<Integer> inQueue = new LinkedList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    inQueue.add(Integer.parseInt(st.nextToken())); 
                    break;
                case "pop":
                    if (inQueue.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inQueue.poll() + "\n");
                    break;
                case "size":
                    sb.append(inQueue.size() + "\n");
                    break;
                case "empty":
                    if (inQueue.size() == 0) sb.append(1 + "\n");
                    else sb.append(0 + "\n"); 
                    break;
                case "front":
                    if (inQueue.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inQueue.peek() + "\n");
                    break;
                case "back":
                    if (inQueue.size() == 0) sb.append(-1 + "\n");
                    else sb.append(((LinkedList<Integer>) inQueue).get(inQueue.size()-1) + "\n");
                    break;
            }
        }

        ///////////////////////////////////////////////////////////////////////
        
        System.out.println(sb);
    }
}
