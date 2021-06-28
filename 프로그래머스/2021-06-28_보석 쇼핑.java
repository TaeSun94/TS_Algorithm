/*
정확성  테스트
테스트 1 〉	실패 (0.14ms, 52.3MB)
테스트 2 〉	실패 (0.41ms, 51.8MB)
테스트 3 〉	실패 (0.90ms, 52.5MB)
테스트 4 〉	통과 (1.71ms, 53.9MB)
테스트 5 〉	실패 (5.19ms, 53.2MB)
테스트 6 〉	통과 (0.17ms, 53.2MB)
테스트 7 〉	통과 (1.64ms, 52.1MB)
테스트 8 〉	실패 (1.63ms, 52.4MB)
테스트 9 〉	실패 (2.42ms, 53.2MB)
테스트 10 〉	통과 (1.67ms, 53.2MB)
테스트 11 〉	통과 (7.88ms, 53.8MB)
테스트 12 〉	실패 (3.77ms, 53MB)
테스트 13 〉	실패 (5.34ms, 53.3MB)
테스트 14 〉	통과 (4.35ms, 54.1MB)
테스트 15 〉	실패 (8.04ms, 53.8MB)
효율성  테스트
테스트 1 〉	실패 (10.34ms, 54.6MB)
테스트 2 〉	통과 (12.15ms, 57.2MB)
테스트 3 〉	실패 (22.36ms, 58.5MB)
테스트 4 〉	통과 (18.99ms, 60.7MB)
테스트 5 〉	실패 (29.97ms, 65.1MB)
테스트 6 〉	실패 (33.87ms, 64.3MB)
테스트 7 〉	실패 (33.70ms, 66.4MB)
테스트 8 〉	실패 (37.90ms, 67.8MB)
테스트 9 〉	실패 (39.83ms, 70.7MB)
테스트 10 〉	실패 (51.18ms, 75.1MB)
테스트 11 〉	실패 (44.35ms, 79.4MB)
테스트 12 〉	실패 (44.71ms, 80.3MB)
테스트 13 〉	실패 (52.27ms, 81MB)
테스트 14 〉	실패 (60.07ms, 84.1MB)
테스트 15 〉	실패 (76.82ms, 82.5MB)
채점 결과
정확성: 13.3
효율성: 8.9
합계: 22.2 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int lpos = 0;
        int rpos = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int idx = 0;
        for(int i = 0; i < gems.length; i++){
            if(map.containsKey(gems[i])){
                map.replace(gems[i], map.get(gems[i])+1);
            }
            else{
                map.put(gems[i],1);
            }
            que.add(gems[i]);
            while(true){
                String gem = que.peek();
                if(map.get(gem) > 1){
                    map.replace(gem, map.get(gem)-1);
                    que.poll();
                    lpos++;
                }
                else{
                    break;
                }
            }
            if(set.size() == map.size()&& rpos>que.size()){
                rpos = que.size();
            }
        }
        answer = new int[2];
        answer[0] = lpos+1;
        answer[1] = lpos+rpos;
        return answer;
      }
    }

/*
정확성  테스트
테스트 1 〉	통과 (0.20ms, 52.5MB)
테스트 2 〉	통과 (0.44ms, 52.2MB)
테스트 3 〉	통과 (0.88ms, 52.8MB)
테스트 4 〉	통과 (0.80ms, 53.4MB)
테스트 5 〉	통과 (1.43ms, 52.6MB)
테스트 6 〉	통과 (0.22ms, 51.6MB)
테스트 7 〉	통과 (0.18ms, 52.4MB)
테스트 8 〉	통과 (1.64ms, 52.8MB)
테스트 9 〉	통과 (1.93ms, 53.1MB)
테스트 10 〉	통과 (1.68ms, 52.6MB)
테스트 11 〉	통과 (2.50ms, 53.7MB)
테스트 12 〉	통과 (3.29ms, 53.6MB)
테스트 13 〉	통과 (5.33ms, 54.2MB)
테스트 14 〉	통과 (5.09ms, 53.4MB)
테스트 15 〉	통과 (9.23ms, 54.3MB)
효율성  테스트
테스트 1 〉	통과 (10.25ms, 54MB)
테스트 2 〉	통과 (15.69ms, 57.4MB)
테스트 3 〉	통과 (28.02ms, 60.3MB)
테스트 4 〉	통과 (18.56ms, 60.9MB)
테스트 5 〉	통과 (32.82ms, 63MB)
테스트 6 〉	통과 (31.01ms, 64.3MB)
테스트 7 〉	통과 (39.08ms, 66.1MB)
테스트 8 〉	통과 (44.01ms, 67.6MB)
테스트 9 〉	통과 (39.56ms, 71.7MB)
테스트 10 〉	통과 (52.68ms, 75.7MB)
테스트 11 〉	통과 (53.74ms, 79.4MB)
테스트 12 〉	통과 (44.32ms, 80.2MB)
테스트 13 〉	통과 (53.81ms, 80.4MB)
테스트 14 〉	통과 (60.53ms, 81.9MB)
테스트 15 〉	통과 (65.81ms, 82.6MB)
채점 결과
정확성: 33.3
효율성: 66.7
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int lpos = 0;
        int rpos = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int idx = 0;
        for(int i = 0; i < gems.length; i++){
            if(map.containsKey(gems[i])){
                map.replace(gems[i], map.get(gems[i])+1);
            }
            else{
                map.put(gems[i],1);
            }
            que.add(gems[i]);
            while(true){
                String gem = que.peek();
                if(map.get(gem) > 1){
                    map.replace(gem, map.get(gem)-1);
                    que.poll();
                    idx++;
                }
                else{
                    break;
                }
            }
            if(set.size() == map.size()&& rpos>que.size()){
                rpos = que.size();
                lpos = idx;
            }
        }
        answer = new int[2];
        answer[0] = lpos+1;
        answer[1] = lpos+rpos;
        return answer;
    }
}
