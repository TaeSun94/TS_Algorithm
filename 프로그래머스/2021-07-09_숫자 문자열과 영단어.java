/*
정확성  테스트
테스트 1 〉	통과 (16.87ms, 53.8MB)
테스트 2 〉	통과 (15.79ms, 52.7MB)
테스트 3 〉	통과 (11.96ms, 54.1MB)
테스트 4 〉	통과 (12.92ms, 53.2MB)
테스트 5 〉	통과 (20.25ms, 53.4MB)
테스트 6 〉	통과 (19.08ms, 52.9MB)
테스트 7 〉	통과 (13.92ms, 52.6MB)
테스트 8 〉	통과 (17.77ms, 53.3MB)
테스트 9 〉	통과 (15.28ms, 52.6MB)
테스트 10 〉	통과 (13.46ms, 51.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static ArrayList<String> numberEN = new ArrayList<>(Arrays.asList("zero","one","two","three","four","five","six","seven","eight","nine"));
    public int solution(String s) {
        int answer = 0;
        String transS = "";
        String numberString = "";
        //for문을 돌며 tmp로 만약 해당 string이 있다면 transS로 옮기고 숫자라면 바로 옮기기
        for(int index = 0; index < s.length(); index++){
            if(s.charAt(index)-'0'>= 0 && s.charAt(index)-'0' <= 9){
                transS += s.charAt(index);
                continue;
            }
            numberString += s.charAt(index);
            if(numberEN.contains(numberString)){
                transS += numberEN.indexOf(numberString);
                numberString = "";
            }
        }
        answer = Integer.parseInt(transS);
        return answer;
    }
}
