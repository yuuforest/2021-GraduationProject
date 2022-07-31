package 스터디과제.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Stack

public class Prob10773 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        // OPTION 1 : 23244KB 268ms  ///////////////////////////////////////////

        for (int testCase = 0; testCase < K; testCase++) {
            
            int num = Integer.parseInt(br.readLine());

            if (num == 0) stack.pop();
            else stack.push(num);
        }

        for (Integer integer : stack) {
            sum += integer;    
        }

        // OPTION 2 : 23644Kb 252ms ///////////////////////////////////////////

        for (int testCase = 0; testCase < K; testCase++) {
            
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                int pop = stack.pop();
                sum -= pop;
            }
            else {
                stack.push(num);
                sum += num;
            }
        }

        ///////////////////////////////////////////////////////////////////////

        sb.append(sum);
        System.out.println(sb);
    }
}
