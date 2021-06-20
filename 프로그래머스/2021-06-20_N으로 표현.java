/*
정확성  테스트
테스트 1 〉	통과 (4.42ms, 53.2MB)
테스트 2 〉	통과 (4.12ms, 52.4MB)
테스트 3 〉	통과 (5.91ms, 51.9MB)
테스트 4 〉	통과 (5.60ms, 52.9MB)
테스트 5 〉	통과 (14.45ms, 52.3MB)
테스트 6 〉	통과 (4.56ms, 52.6MB)
테스트 7 〉	통과 (4.95ms, 52.2MB)
테스트 8 〉	통과 (16.41ms, 53MB)
테스트 9 〉	통과 (4.92ms, 52.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
class Solution {
    static int min;
    public int solution(int N, int number) {
        min = Integer.MAX_VALUE;

        dfs(0,0,N,number);

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void dfs(int count, int preNumber, int N, int number){
        if(count > 8)
            return;
        if(preNumber == number){
            min = Math.min(min,count);
            return;
        }
        int tmp = N;
        for(int i = 0; i < 8 - count; i++){
            dfs(count+i+1,preNumber+tmp,N,number);
            dfs(count+i+1,preNumber-tmp,N,number);
            dfs(count+i+1,preNumber*tmp,N,number);
            dfs(count+i+1,preNumber/tmp,N,number);
            tmp = tmp * 10 + N;
        }
    }
}
