/*
정확성  테스트
테스트 1 〉	통과 (0.44ms, 79.7MB)
테스트 2 〉	통과 (0.37ms, 78.6MB)
테스트 3 〉	통과 (0.36ms, 72MB)
테스트 4 〉	통과 (0.52ms, 72.6MB)
테스트 5 〉	통과 (0.36ms, 76.5MB)
테스트 6 〉	통과 (0.35ms, 71.8MB)
테스트 7 〉	통과 (0.47ms, 74.8MB)
테스트 8 〉	통과 (0.50ms, 81.8MB)
테스트 9 〉	통과 (0.34ms, 72.6MB)
테스트 10 〉	통과 (0.62ms, 75MB)
테스트 11 〉	통과 (0.48ms, 71.6MB)
테스트 12 〉	통과 (0.52ms, 79.9MB)
테스트 13 〉	통과 (1.14ms, 85.2MB)
테스트 14 〉	통과 (1.64ms, 80MB)
테스트 15 〉	통과 (1.57ms, 80.4MB)
테스트 16 〉	통과 (6.79ms, 77.9MB)
테스트 17 〉	통과 (3.86ms, 76.4MB)
테스트 18 〉	통과 (4.77ms, 81.3MB)
테스트 19 〉	통과 (6.96ms, 88.4MB)
테스트 20 〉	통과 (5.72ms, 90.3MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 1;
        int rMax = 0;
        int cMax = 0;
        for(int i = 0; i < sizes.length; i++){
            Arrays.sort(sizes[i]);
        }
        for(int i = 0; i < sizes.length; i++){
            rMax = Math.max(sizes[i][0],rMax);
            cMax = Math.max(sizes[i][1],cMax);
        }
        answer = rMax*cMax;
        return answer;
    }
}
