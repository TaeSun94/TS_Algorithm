/*
정확성  테스트
테스트 1 〉	통과 (10.35ms, 60MB)
테스트 2 〉	통과 (15.33ms, 59.3MB)
테스트 3 〉	통과 (33.12ms, 74.2MB)
테스트 4 〉	통과 (15.99ms, 71.5MB)
테스트 5 〉	통과 (19.95ms, 74.6MB)
테스트 6 〉	통과 (20.42ms, 61.9MB)
테스트 7 〉	통과 (53.76ms, 75.5MB)
테스트 8 〉	통과 (23.53ms, 61.2MB)
테스트 9 〉	통과 (20.94ms, 60.8MB)
테스트 10 〉	통과 (17.14ms, 76.7MB)
테스트 11 〉	통과 (25.47ms, 74MB)
테스트 12 〉	통과 (23.31ms, 71.9MB)
테스트 13 〉	통과 (13.31ms, 74.1MB)
테스트 14 〉	통과 (17.56ms, 72.5MB)
테스트 15 〉	통과 (23.12ms, 59.5MB)
테스트 16 〉	통과 (14.20ms, 72.7MB)
테스트 17 〉	통과 (20.09ms, 72.1MB)
테스트 18 〉	통과 (17.22ms, 74.6MB)
테스트 19 〉	통과 (23.18ms, 77.9MB)
테스트 20 〉	통과 (15.96ms, 62.3MB)
테스트 21 〉	통과 (10.67ms, 63MB)
테스트 22 〉	통과 (23.92ms, 71.9MB)
테스트 23 〉	통과 (11.30ms, 76.5MB)
테스트 24 〉	통과 (25.78ms, 75.7MB)
테스트 25 〉	통과 (15.58ms, 58MB)
테스트 26 〉	통과 (13.08ms, 72.3MB)
테스트 27 〉	통과 (20.28ms, 59.8MB)
테스트 28 〉	통과 (14.58ms, 73.8MB)
테스트 29 〉	통과 (12.72ms, 75.9MB)
테스트 30 〉	통과 (14.75ms, 71.5MB)
테스트 31 〉	통과 (13.63ms, 60.2MB)
테스트 32 〉	통과 (19.45ms, 76.7MB)
테스트 33 〉	통과 (27.56ms, 72.8MB)
테스트 34 〉	통과 (16.70ms, 61.4MB)
테스트 35 〉	통과 (18.17ms, 74.1MB)
테스트 36 〉	통과 (16.47ms, 61.3MB)
테스트 37 〉	통과 (12.63ms, 58.1MB)
테스트 38 〉	통과 (16.90ms, 74.1MB)
테스트 39 〉	통과 (13.63ms, 60.4MB)
테스트 40 〉	통과 (20.78ms, 72.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static char[] input = {'A','E','I','O','U'};
    static int ans;
    static boolean flag;
    public int solution(String word) {
        int answer = 0;
        ans = 0;
        flag = false;
        dfs("",word);
        // System.out.println(ans);
        return ans;
    }
    public static void dfs(String str, String word){
        if(flag)
            return;
        if(str.length() > 5)
            return;
        if(str.length()>0){
            ans++;
            if(word.equals(str)){
                flag = true;
            }
        }
        for(int i = 0; i < input.length; i++){
            dfs(str+input[i],word);
        }
        return;
    }
}
