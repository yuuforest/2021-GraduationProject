package 학교수업.실습;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Assignment1 {

    public static int[] initSkip(String pattern) {
        // pattern을 입력받는다. 
        // pattern과 text의 문자가 불일치하여 새로 pattern을 검색할때, 
        // 검색할 위치에 대한 정보를 제공하는 배열을 생성한다. 

        int M = pattern.length();   // pattern의 길이 

        int[] skip = new int[Character.MAX_VALUE + 1];  
        // 문자 뿐만 아니라 숫자와 특수기호도 검색할 수 있도록 하기 위하여 모든 Character의 값이 포함되도록 한다. 
        // Characte의 값 중 제일 큰 값까지 표현할 수 있도록 가장 큰 값에 +1을 하여 배열의 크기를 선언한다. 

        for (int i = 0; i < Character.MAX_VALUE; i++) {
            skip[i] = M;    // 배열의 모든 값을 pattern의 크기 값 M으로 정의한다. 
        }

        for (int i = 0; i < M; i++) {
            skip[pattern.charAt(i)] = M - i - 1;
            // pattern에 포함되는 문자에 해당하는 인덱스의 배열 값만 M - i - 1로 정의한다. 
            // 즉, 0부터 M - 1까지의 값으로 pattern의 문자 인덱스에 해당하는 배열 값들을 재정의한다. 
        }

        return skip;    // 배열을 반환한다. 
    }

    public static int MisChar(String pattern, String text, int start) {
        // 검색할 pattern, text, 그리고 text에서의 검색 시작 위치 start를 입력받는다.
        // 한 문장에서 여러 개의 pattern을 검색하기 위하여 검색 시작 위치가 필요하다. 

        int M = pattern.length();   // pattern의 길이
        int N = text.length();      // text의 길이
        int i, j;   // pattern과 text 안에서의 위치를 나타내는 변수

        int[] skip = initSkip(pattern);
        // 위에서 정의한 initSkip 함수로 skip 배열을 받아온다.

        if (N < M) {
            // text의 길이가 pattern의 길이보다 작을 경우 
            // pattern이 검색될 수 없기 때문에 검색을 하지않고 
            return N;   // text의 길이 N을 반환한다. 
        } else {
            // text에서 pattern을 검색한다. 
            for (i = start + M-1, j = M-1; j >= 0; i--, j--) {
                // Boyer-Moore Algorithm은 pattern의 뒤에서부터 검색을 하기 때문에 
                // i는 검색 시작 위치 start + M - 1로, j는 M-1로 시작한다. 

                // 검색을 시작해서 text와 pattern의 문자가 동일하다면 그대로 i와 j를 감소시키며 진행되지만, 
                // 문자가 다르다면 좀더 효율적인 방법으로 검색의 재시작 위치를 정의해야 한다. 
                while (text.charAt(i) != pattern.charAt(j)) {   // text와 pattern의 문자가 다르다면, 
                    int k = skip[text.charAt(i)];
                    // 인덱스는 text 문자의 Character 값으로, 이 인덱스에 해당하는 skip 배열의 값을 k로 정의한다.  

                    // text의 pattern 검색 위치를 재 정의한다. 
                    if (M-j > k) i = i + M - j;
                    // 재시작 위치가 이미 검색을 완료한 앞으로 다시 넘어가지 않게 하기 위해 
                    // text와 검색을 완료한 pattern 문자 개수가 k보다 큰 경우 (일치한 문자 개수 + 불일치 시작 문자 1개)
                    // 현재 text의 위치에 검색을 완료한 문자 개수를 더하여 재시작 위치를 정의한다.  
                    else i = i + k;
                    // text 현재 위치에 이동할 k를 더해 재시작 위치를 정의한다. 

                    if (i >= N) return N;
                    // 변수 i가 text의 길이보다 더 크다면 text의 마지막까지 검색을 완료 했다는 뜻이기 때문에 text의 길이 N을 반환한다.  
                    j = M - 1;
                    // 검색을 다시 하는 위치에서 pattern의 마지막 문자부터 다시 검색을 시작해야 하기 때문에 M - 1로 정의한다. 
                }
            }

            return i + 1;   
            // text 내에서 pattern을 찾은 경우, j가 -1의 상태에서 for문이 실행 종료되는 것이기 때문에
            // pattern의 시작 위치 그 전에서 i와 j가 종료된다. 그렇기 때문에 pattern의 위치를 반환할때는
            // text의 위치를 가리키는 i에 +1을 해서 검색한 pattern의 시작 위치를 반환한다.  
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        // 주어진 텍스트 파일의 내용을 읽어온다. 
        InputStream file = new FileInputStream("C:\\Users\\Yu\\Desktop\\학교\\과제1\\RFC2616_modified.txt");
        Scanner sc = new Scanner(file);

        String text = "";
        // pattern을 검색할 text는 텍스트 파일의 한 줄씩 읽어서 
        // 그때마다 새로 정의해야 하기 때문에 text 변수를 선언하고 초기화한다.   

        // 과제에서 주어진 Pattern 5개 
        // String pattern = "similar";              // 5개
        // String pattern = "UA -----v";            // 2개
        // String pattern = "HTTP/1.1,";            // 1개
        // String pattern = "letter \"A\"..\"Z\"";  // 1개
        // String pattern = "[50]";                    // 0개

        // 한 문장에서 여러개의 pattern을 찾을 수 있음을 보이기 위한 추가 pattern
        String pattern = "HTTP/1.1";             // 23개

        int line = 0;       // 텍스트 파일의 몇번째 줄인지 정의
        int pstart = 0;     // text에서 검색을 시작할 위치
        int number = 0;     // 검색된 pattern의 개수

        boolean check = false;  
        // 찾은 pattern이 있다면 treu로 다시 정의되고 
        // 찾은 pattern이 없어 check가 false로 계속 유지되면 검색된 pattern이 없다고 출력한다. 

        while(sc.hasNextLine()) {   
            // 받아올 다음 줄의 내용이 있다면 while문이 실행되고
            // 텍스트 파일이 끝나서 받아올 다음 줄의 내용이 없다면 while문이 실행되지 않는다.  

            line += 1;      // 첫번째 줄 1부터 시작하여 받아온 text가 텍스트의 몇번째 줄인지 정의한다.  

            text = sc.nextLine();   // 텍스트 파일의 다음 줄의 내용을 받아온다. 
            pstart = MisChar(pattern, text, 0); 
            // 새로운 줄의 내용을 받아왔다면 문장의 처음부터 pattern을 검색해야 하기 때문에
            // 시작 위치를 0으로 하고 pattern과 text를 MisChar 함수에 입력해 
            // 함수를 실행해서 text에서 찾은 pattern의 시작 위치를 받아온다.   

            while (pstart < text.length()) {
                // text의 길이보다 pattern의 시작 위치가 작아야 한다.
                // 문장의 마지막까지 pattern을 검색하기 위해 
                // pattern의 시작 위치가 text보다 크거나 같을 때까지 while문이 실행된다.   

                check = true;   // pattern을 찾았기 때문에 check는 true로 다시 정의한다. 
                number++;       // pattern을 하나 찾았기 때문에 number 수를 하나 더한다. 

                System.out.format("%3d. %4d줄:%4d번  ", number, line, pstart);
                // 몇번째로 찾은 pattern인지, 텍스트 파일의 몇번째 줄의 어느 위치한 pattern인지에 대해
                // 찾은 pattern의 정보를 한 문장으로 출력한다. 

                for (int i = pstart; i < pstart + pattern.length(); i++) {
                    // MisChar 함수로 받은 pattern의 시작 위치부터 pattern의 크기만큼 for문을 실행하여
                    // 입력받은 위치의 문자가 pattern이 맞는지 확인한다. 
                    System.out.print(text.charAt(i));   // 해당하는 위치의 문자를 출력한다. 
                }

                System.out.println();

                // 문장 안에 또 다른 pattern이 있을수도 있기 때문에 위치를 파악해서 함수를 실행 여부를 결정한다. 
                if (pstart + pattern.length() < text.length()) pstart = MisChar(pattern, text, pstart + 1);
                // pattern의 시작 위치에 pattern의 길이를 합한 위치가 text의 길이보다 작다면
                // 또 다른 pattern이 있을 수가 있기 때문에 pattern의 그 다음 위치를 (+1)
                // 검색 시작위치로 하여 MisChar 함수를 다시 실행해 새로운 pattern 시작 위치를 받는다.   
                else break;
                // pattern의 시작 위치에 pattern의 길이를 합한 위치가 text의 길이보다 크다면
                // 또 다른 pattern이 있을 수가 없기 때문에 while문 실행을 멈추고 break를 실행한다. 
            }

        }

        System.out.println();

        if (check) { // check가 true란 의미는 pattern이 검색되었다는 의미이기 때문에
            System.out.println("총 " + number + "개의 \"" + pattern + "\"이 검색되었습니다. ");
            // 총 몇개의 pattern이 검색되었는지 출력한다. 
        } else {    // check가 false란 의미는 검색된 pattern이 없다는 의미이기 때문에
            System.out.println("검색된 \"" + pattern + "\"이 없습니다. "); 
            // 검색된 pattern이 없다고 출력한다. 
        }

        System.out.println();
        sc.close();
    }
}

