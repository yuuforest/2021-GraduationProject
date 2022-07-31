package 스터디과제.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Deque

public class Prob10866 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // OPTIN 1 : 19868KB 248ms  ///////////////////////////////////////////

        Deque<Integer> inDeque = new LinkedList<>();

        for (int testCase = 0; testCase < N; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    inDeque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    inDeque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (inDeque.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inDeque.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if (inDeque.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inDeque.removeLast() + "\n");
                    break;
                case "size":
                    sb.append(inDeque.size() + "\n");
                    break;
                case "empty":
                    if(inDeque.size() == 0) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if(inDeque.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inDeque.peekFirst() + "\n");
                    break;
                case "back":
                    if(inDeque.size() == 0) sb.append(-1 + "\n");
                    else sb.append(inDeque.peekLast() + "\n");
                    break;
            }
        }

        ///////////////////////////////////////////////////////////////////////
        
        System.out.println(sb);
    }
}
