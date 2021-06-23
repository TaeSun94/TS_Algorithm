/*
정확성  테스트
테스트 1 〉	실패 (0.11ms, 51.8MB)
테스트 2 〉	통과 (0.14ms, 53MB)
테스트 3 〉	실패 (0.22ms, 52.4MB)
테스트 4 〉	통과 (0.38ms, 52.3MB)
테스트 5 〉	통과 (0.66ms, 52.7MB)
테스트 6 〉	통과 (3.30ms, 53.2MB)
테스트 7 〉	통과 (6.32ms, 53.7MB)
테스트 8 〉	통과 (12.60ms, 54.7MB)
테스트 9 〉	통과 (18.91ms, 55.9MB)
테스트 10 〉	통과 (0.44ms, 52.1MB)
테스트 11 〉	통과 (0.18ms, 52.4MB)
테스트 12 〉	통과 (0.44ms, 52.6MB)
테스트 13 〉	통과 (0.60ms, 52.4MB)
테스트 14 〉	통과 (2.44ms, 52.1MB)
테스트 15 〉	통과 (6.75ms, 53.2MB)
테스트 16 〉	통과 (14.55ms, 54.2MB)
테스트 17 〉	통과 (22.87ms, 56.5MB)
테스트 18 〉	통과 (0.19ms, 52.8MB)
테스트 19 〉	통과 (0.41ms, 52.4MB)
테스트 20 〉	통과 (0.81ms, 51.8MB)
테스트 21 〉	통과 (2.55ms, 54.2MB)
테스트 22 〉	통과 (9.53ms, 52.6MB)
테스트 23 〉	통과 (16.90ms, 55.3MB)
테스트 24 〉	통과 (19.73ms, 55.8MB)
테스트 25 〉	통과 (0.26ms, 52.1MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (시간 초과)
채점 결과
정확성: 59.0
효율성: 0.0
합계: 59.0 / 100.0
*/
import java.util.*;
class Solution {
    // static int[] mem;
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        // mem = new int[stones.length - k + 1];
        // go(stones.length-k, stones);
        for(int i = 0; i < stones.length; i++){
            if(que.size() < k){
                que.add(stones[i]);
                continue;
            }
            int max = 0;
            for(int j = 0; j < que.size(); j++){
                int t = que.poll();
                max = Math.max(t,max);
                que.add(t);
            }
            que.poll();
            que.add(stones[i]);
            min = Math.min(max,min);
        }
        answer = min;
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 52.3MB)
테스트 2 〉	통과 (0.04ms, 52.3MB)
테스트 3 〉	통과 (0.04ms, 52.5MB)
테스트 4 〉	통과 (0.04ms, 53.1MB)
테스트 5 〉	통과 (0.05ms, 54MB)
테스트 6 〉	통과 (0.19ms, 53.1MB)
테스트 7 〉	통과 (0.31ms, 53.1MB)
테스트 8 〉	통과 (0.36ms, 52.5MB)
테스트 9 〉	통과 (0.30ms, 52.3MB)
테스트 10 〉	통과 (0.05ms, 53.7MB)
테스트 11 〉	통과 (0.05ms, 52.5MB)
테스트 12 〉	통과 (0.05ms, 51.8MB)
테스트 13 〉	통과 (0.06ms, 51.9MB)
테스트 14 〉	통과 (0.16ms, 53MB)
테스트 15 〉	통과 (0.37ms, 53.3MB)
테스트 16 〉	통과 (0.33ms, 52.5MB)
테스트 17 〉	통과 (0.43ms, 52.8MB)
테스트 18 〉	통과 (0.04ms, 52.8MB)
테스트 19 〉	통과 (0.09ms, 53MB)
테스트 20 〉	통과 (0.08ms, 52.5MB)
테스트 21 〉	통과 (0.15ms, 52.7MB)
테스트 22 〉	통과 (0.32ms, 54.2MB)
테스트 23 〉	통과 (0.21ms, 52.1MB)
테스트 24 〉	통과 (0.41ms, 52.9MB)
테스트 25 〉	통과 (0.05ms, 52.4MB)
효율성  테스트
테스트 1 〉	통과 (19.42ms, 61.8MB)
테스트 2 〉	통과 (24.17ms, 62.4MB)
테스트 3 〉	통과 (19.93ms, 62.3MB)
테스트 4 〉	통과 (12.00ms, 61.9MB)
테스트 5 〉	통과 (13.18ms, 62.7MB)
테스트 6 〉	통과 (17.45ms, 62MB)
테스트 7 〉	통과 (22.59ms, 62.8MB)
테스트 8 〉	통과 (21.04ms, 62.7MB)
테스트 9 〉	통과 (19.90ms, 62.3MB)
테스트 10 〉	통과 (19.44ms, 62.2MB)
테스트 11 〉	통과 (19.53ms, 63MB)
테스트 12 〉	통과 (27.52ms, 61.9MB)
테스트 13 〉	통과 (17.50ms, 62.5MB)
테스트 14 〉	통과 (19.13ms, 62.5MB)
채점 결과
정확성: 64.1
효율성: 35.9
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int high = 200000000;
        int low = 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(!check(stones, k, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
                answer = Math.max(answer,mid);
            }
        }
        return answer;
    }
    public boolean check(int[] stones, int k, int mid){
        int cnt = 0;
        for(int stone: stones){
            if(stone-mid < 0)
                cnt++;
            else
                cnt = 0;

            if(cnt == k)
                return false;
        }
        return true;
    }
}
