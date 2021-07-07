/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 51.9MB)
테스트 2 〉	통과 (0.02ms, 52.7MB)
테스트 3 〉	통과 (0.03ms, 52.5MB)
테스트 4 〉	통과 (0.03ms, 52MB)
테스트 5 〉	통과 (0.03ms, 53.3MB)
테스트 6 〉	통과 (0.03ms, 52.1MB)
테스트 7 〉	통과 (0.12ms, 53.1MB)
테스트 8 〉	통과 (0.11ms, 52.5MB)
테스트 9 〉	통과 (0.09ms, 52.4MB)
테스트 10 〉	통과 (0.07ms, 53.8MB)
테스트 11 〉	통과 (0.50ms, 51.5MB)
테스트 12 〉	통과 (0.46ms, 53.4MB)
테스트 13 〉	통과 (0.30ms, 53.2MB)
테스트 14 〉	통과 (0.54ms, 52.3MB)
테스트 15 〉	통과 (0.41ms, 53.2MB)
테스트 16 〉	통과 (0.48ms, 55.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
class Solution {
    static long[] mem;
    public long solution(int n) {
        long answer = 0;
        mem = new long[n+1];
        answer = go(n);
        return answer;
    }
    public long go(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(mem[n]>0)
            return mem[n];
        mem[n] = (go(n-1)+go(n-2))%1234567;
        return mem[n];
    }
}
