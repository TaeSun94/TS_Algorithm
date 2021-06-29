/*
정확성  테스트
테스트 1 〉	통과 (0.44ms, 52.1MB)
테스트 2 〉	통과 (0.43ms, 52.6MB)
테스트 3 〉	통과 (0.44ms, 52.3MB)
테스트 4 〉	통과 (0.42ms, 52MB)
테스트 5 〉	통과 (0.52ms, 53.1MB)
테스트 6 〉	통과 (0.51ms, 53.4MB)
테스트 7 〉	통과 (0.40ms, 52.5MB)
테스트 8 〉	통과 (0.47ms, 51.6MB)
테스트 9 〉	통과 (1.22ms, 52.3MB)
테스트 10 〉	통과 (0.99ms, 52.4MB)
테스트 11 〉	통과 (1.22ms, 53.1MB)
테스트 12 〉	통과 (0.83ms, 54MB)
테스트 13 〉	통과 (7.02ms, 57.1MB)
테스트 14 〉	통과 (11.07ms, 57.9MB)
테스트 15 〉	통과 (5.79ms, 53MB)
테스트 16 〉	통과 (7.80ms, 54.2MB)
테스트 17 〉	통과 (0.68ms, 52.8MB)
테스트 18 〉	통과 (0.74ms, 52.5MB)
효율성  테스트
테스트 1 〉	통과 (118.95ms, 63.2MB)
테스트 2 〉	통과 (59.81ms, 66.5MB)
테스트 3 〉	통과 (67.43ms, 67MB)
채점 결과
정확성: 85.7
효율성: 14.3
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aPos = 0;
        int bPos = 0;
        while(true){
            if(aPos == A.length || bPos == B.length)
                break;
            if(A[aPos]>= B[bPos]){
                bPos++;
            }
            else{
                answer++;
                aPos++;
                bPos++;
            }
        }
        return answer;
    }
}
