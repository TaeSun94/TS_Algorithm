/*
정확성  테스트
테스트 1 〉	통과 (0.22ms, 52.2MB)
테스트 2 〉	통과 (9.58ms, 52.2MB)
테스트 3 〉	통과 (6.19ms, 53.2MB)
테스트 4 〉	통과 (0.07ms, 52.4MB)
테스트 5 〉	통과 (0.02ms, 52.1MB)
테스트 6 〉	통과 (0.03ms, 52.9MB)
테스트 7 〉	통과 (0.90ms, 52.5MB)
테스트 8 〉	통과 (0.14ms, 51.8MB)
테스트 9 〉	통과 (0.04ms, 52.2MB)
테스트 10 〉	통과 (49.67ms, 53.2MB)
테스트 11 〉	통과 (44.16ms, 52.9MB)
테스트 12 〉	통과 (39.06ms, 52.6MB)
테스트 13 〉	통과 (56.31ms, 53MB)
테스트 14 〉	통과 (0.24ms, 52.3MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
채점 결과
정확성: 73.7
효율성: 0.0
합계: 73.7 / 100.0
*/
import java.util.*;
class Solution {
    static int[] input;
    static long cnt;
    static int[] ans;
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        input = new int[n];
        ans = new int[n];
        cnt = 0;
        for(int i = 0; i < n; i++){
            input[i] = i+1;
        }
        do{
            if(k==++cnt){
                int idx = 0;

//                 for(int num : input){
//                     answer[idx++] = num;
//                 }
                break;
            }
        } while(nextPermutation());

        return input;
    }
    public boolean nextPermutation(){
        int i = input.length - 1;
        while(i>0 && input[i-1]>=input[i]) --i;
        if(i <= 0)
            return false;
        int j = input.length - 1;
        while(input[i-1] > input[j]) --j;
        swap(i-1,j);
        j = input.length -1;
        for(;i<j;++i,--j){
            swap(i,j);
        }
        return true;
    }
    public void swap(int i , int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
