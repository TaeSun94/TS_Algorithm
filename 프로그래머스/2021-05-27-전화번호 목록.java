/*
배열을 string 길이로 sort 진행 후 동작 확인
효율성 4번 시간초과

정확성  테스트
테스트 1 〉	통과 (0.48ms, 52.5MB)
테스트 2 〉	통과 (2.37ms, 52.3MB)
테스트 3 〉	통과 (0.49ms, 51.8MB)
테스트 4 〉	통과 (0.44ms, 52.1MB)
테스트 5 〉	통과 (0.47ms, 52.3MB)
테스트 6 〉	통과 (0.43ms, 52.8MB)
테스트 7 〉	통과 (0.46ms, 53.2MB)
테스트 8 〉	통과 (0.54ms, 51.9MB)
테스트 9 〉	통과 (0.47ms, 52.8MB)
테스트 10 〉	통과 (0.39ms, 52.5MB)
테스트 11 〉	통과 (0.46ms, 53.5MB)
테스트 12 〉	통과 (0.36ms, 52.6MB)
테스트 13 〉	통과 (0.32ms, 52.3MB)
테스트 14 〉	통과 (41.71ms, 70.7MB)
테스트 15 〉	통과 (45.51ms, 70.4MB)
테스트 16 〉	통과 (0.99ms, 53.8MB)
테스트 17 〉	통과 (0.97ms, 53.9MB)
테스트 18 〉	통과 (98.16ms, 127MB)
테스트 19 〉	통과 (101.65ms, 134MB)
테스트 20 〉	통과 (142.31ms, 184MB)
효율성  테스트
테스트 1 〉	통과 (15.51ms, 56.6MB)
테스트 2 〉	통과 (13.16ms, 57.5MB)
테스트 3 〉	통과 (10.61ms, 97.7MB)
테스트 4 〉	실패 (시간 초과)
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o1.length()-o2.length());
            }
        });

        for(int i = 0; i < phone_book.length - 1; i++){
            boolean flag = false;
            if(phone_book[i].length() == phone_book[phone_book.length-1].length())
                break;
            for(int j = i+1; j < phone_book.length; j++){
                if(phone_book[j].length() == phone_book[i].length())
                    continue;
                if(phone_book[j].substring(0,phone_book[i].length()).equals(phone_book[i])){
                    answer = false;
                    flag = true;
                    break;
                }
            }

            if(flag)
                break;
        }

        return answer;
    }
}

/*
배열을 일반 sort를 진행한 후에 for문 한개로 다음 번째를 확인하고 포함여부만 확인하는 과정
조심해야하는 것은 앞선 배열의 string의 크기가 다음 string의 크기보다 클 수 있기때문에 조건문에 추가

정확성  테스트
테스트 1 〉	통과 (0.26ms, 51.9MB)
테스트 2 〉	통과 (0.23ms, 54.2MB)
테스트 3 〉	통과 (0.24ms, 53.2MB)
테스트 4 〉	통과 (0.23ms, 52.5MB)
테스트 5 〉	통과 (0.25ms, 52.8MB)
테스트 6 〉	통과 (0.19ms, 52.6MB)
테스트 7 〉	통과 (0.24ms, 53.1MB)
테스트 8 〉	통과 (0.24ms, 52.7MB)
테스트 9 〉	통과 (0.28ms, 52.2MB)
테스트 10 〉	통과 (0.65ms, 52.7MB)
테스트 11 〉	통과 (0.21ms, 52.8MB)
테스트 12 〉	통과 (0.24ms, 52.9MB)
테스트 13 〉	통과 (0.24ms, 52.8MB)
테스트 14 〉	통과 (5.82ms, 52.6MB)
테스트 15 〉	통과 (5.55ms, 53.4MB)
테스트 16 〉	통과 (5.62ms, 53.1MB)
테스트 17 〉	통과 (6.64ms, 53.3MB)
테스트 18 〉	통과 (8.44ms, 56.9MB)
테스트 19 〉	통과 (7.01ms, 53.8MB)
테스트 20 〉	통과 (9.16ms, 53.8MB)
효율성  테스트
테스트 1 〉	통과 (27.37ms, 57.3MB)
테스트 2 〉	통과 (18.77ms, 59.4MB)
테스트 3 〉	통과 (375.65ms, 98.5MB)
테스트 4 〉	통과 (295.16ms, 95.5MB)
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i].length()<phone_book[i+1].length() && phone_book[i].equals(phone_book[i+1].substring(0,phone_book[i].length()))){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
