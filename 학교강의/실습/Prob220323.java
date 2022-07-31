package 학교강의.실습;

import java.util.Random;

public class Prob220323 {
    
    // 증가식1: h = 3*h + 1     감소식: h = h/3
    static void Shell1(int unSorted[], int length) {

        int h = 0, v = 0, j = 0;

        for (h = 1; h < length; h = 3*h +1) {}  

        for ( ; h > 0; h = h/3) {              
            for (int i = h; i < length; i++) {  
                v = unSorted[i];
                j = i;

                while (j >= h && unSorted[j-h] > v) {
                    unSorted[j] = unSorted[j-h];
                    j -= h;
                }

                unSorted[j] = v;
            }
        }
    }

    // 증가식2: h = 3*h         감소식: h = h/3
    static void Shell2(int unSorted[], int length) {

        int h = 0, v = 0, j = 0;

        for (h = 1; h < length; h = 3*h) {}  

        for ( ; h > 0; h = h/3) {              
            for (int i = h; i < length; i++) {  
                v = unSorted[i];
                j = i;

                while (j >= h && unSorted[j-h] > v) {
                    unSorted[j] = unSorted[j-h];
                    j -= h;
                }

                unSorted[j] = v;
            }
        }
    }

    // 증가식3: h = 5*h + 1     감소식: h = h/5
    static void Shell3(int unSorted[], int length) {

        int h = 0, v = 0, j = 0;

        for (h = 1; h < length; h = 5*h +1) {}  

        for ( ; h > 0; h = h/5) {              
            for (int i = h; i < length; i++) {  
                v = unSorted[i];
                j = i;

                while (j >= h && unSorted[j-h] > v) {
                    unSorted[j] = unSorted[j-h];
                    j -= h;
                }

                unSorted[j] = v;
            }
        }
    }

    // 배열의 정렬 유무를 판단
    static void checkSort(int a[], int n) {
        boolean sorted = true;

        for (int i = 0; i < n-1; i++) {
            
            if (a[i] > a[i+1]) {    // 배열에서 앞의 수가 뒤의 수보다 크면
                sorted = false;     // 배열 오류 
            }

            if (!sorted) break;
        }

        if (sorted) {
            System.out.println("정렬 완료");
        } else {
            System.out.println("정렬 오류!!");
        }


    }
    public static void main(String[] args) {

        // 정렬할 배열의 크기를 설정한 배열
        int[] Ncount = {100000, 500000, 1000000, 5000000, 10000000};

        Random ran = new Random();

        long start = 0, end = 0;
        String sec = "";

        System.out.println();       // 깔끔한 출력을 위한  띄어쓰기

        // Ncount 배열 안에 있는 모든 크기에 대해서 실행
        for (int N : Ncount) {

            int[] RandomArray = new int[N];

            for (int i = 0; i < N; i++) {
                RandomArray[i] = ran.nextInt(N) + 1;    // 1부터 N까지의 난수 발생
            }

            // 시간 측정 시작
            start = System.currentTimeMillis();

            // 정렬
            Shell1(RandomArray, N);     // 증가식1: h = 3*h + 1     감소식: h = h/3
            // Shell2(RandomArray, N);     // 증가식1: h = 3*h         감소식: h = h/3
            // Shell3(RandomArray, N);     // 증가식1: h = 5*h + 1     감소식: h = h/5

            // 시간 측정 종료
            end = System.currentTimeMillis();

            // 측정한 시간 정리 : 초(sec)의 형태로 소수점 3자리까지 표현
            sec = String.format("%.3f", (end - start) * (0.001));

            System.out.println("증가식: 3h + 1, 감소식: h/3 쉘 정렬 실행 시간 (N = " + N + "): " + sec + "초");
            // System.out.println("증가식: 3h, 감소식: h/3 쉘 정렬 실행 시간 (N = " + N + "): " + sec + "초");
            // System.out.println("증가식: 5h + 1, 감소식: h/5 쉘 정렬 실행 시간 (N = " + N + "): " + sec + "초");

            // 정렬의 상태 확인 : 정렬 완료 VS 정렬 오류
            checkSort(RandomArray, N);

        }

        System.out.println();       // 깔끔한 출력을 위한  띄어쓰기
    }
}
