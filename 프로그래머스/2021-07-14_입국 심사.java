/*
정확성  테스트
테스트 1 〉	통과 (0.37ms, 52.7MB)
테스트 2 〉	통과 (0.50ms, 52.5MB)
테스트 3 〉	실패 (3.95ms, 52.7MB)
테스트 4 〉	통과 (98.09ms, 59.5MB)
테스트 5 〉	실패 (89.45ms, 60.4MB)
테스트 6 〉	통과 (115.37ms, 59.5MB)
테스트 7 〉	실패 (92.85ms, 59.9MB)
테스트 8 〉	실패 (40.91ms, 60.5MB)
테스트 9 〉	통과 (0.41ms, 52.8MB)
채점 결과
정확성: 55.6
합계: 55.6 / 100.0
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = n*times[times.length-1];

        while(start<end){
            long mid = (end-start)/2+start;
            long numbers = 0;
            for(int i= 0; i < times.length; i++){
                numbers += mid/times[i];
            }
            if(numbers>=n){
                end = mid;
            }
            else
                start = mid+1;
        }
        answer = start;
        return answer;
    }
}
/*
문제는 가장 많이 걸린 시간을 계산시 자료형이 int * int여서 long으로 강제 형변환 이후 해결
정확성  테스트
테스트 1 〉	통과 (1.68ms, 52.9MB)
테스트 2 〉	통과 (2.96ms, 52.4MB)
테스트 3 〉	통과 (1.75ms, 52.8MB)
테스트 4 〉	통과 (169.23ms, 60.2MB)
테스트 5 〉	통과 (129.66ms, 60.4MB)
테스트 6 〉	통과 (127.47ms, 59.8MB)
테스트 7 〉	통과 (120.71ms, 61.3MB)
테스트 8 〉	통과 (112.39ms, 60.3MB)
테스트 9 〉	통과 (2.03ms, 51.5MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = 1;
        long end = (long)n*(long)times[times.length-1];

        while(start<=end){
            long mid = (end+start)/2;
            long numbers = 0;
            for(int i= 0; i < times.length; i++){
                numbers += mid/times[i];
            }
            if(numbers>=n){
                answer = Math.min(answer,mid);
                end = mid - 1;
            }
            else
                start = mid+1;
        }
        return answer;
    }
}
