/*
정확성  테스트
테스트 1 〉	통과 (2.92ms, 53.6MB)
테스트 2 〉	통과 (4.29ms, 54.2MB)
테스트 3 〉	통과 (4.26ms, 54.1MB)
테스트 4 〉	통과 (3.24ms, 54.5MB)
테스트 5 〉	통과 (1.18ms, 53.2MB)
테스트 6 〉	통과 (2.85ms, 53.2MB)
테스트 7 〉	통과 (0.88ms, 53MB)
테스트 8 〉	통과 (0.83ms, 53.3MB)
테스트 9 〉	통과 (2.79ms, 56.3MB)
테스트 10 〉	통과 (3.61ms, 53.2MB)
테스트 11 〉	통과 (3.32ms, 53.4MB)
테스트 12 〉	통과 (3.35ms, 53.2MB)
테스트 13 〉	통과 (4.47ms, 54.7MB)
테스트 14 〉	통과 (0.04ms, 53MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	통과 (0.04ms, 52MB)
채점 결과
정확성: 70.0
효율성: 5.0
합계: 75.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        int num = n;
        for(int i = 0; i < n; i++){
            if(i == n-1){
                list.add(s);
                continue;
            }
            if(s/num <= 0){
                return new int[]{-1};
            }
            list.add(s/num);
            s -= s/num;
            num-=1;
        }
        Collections.sort(list);
        int idx = 0;
        for(int number: list){
            answer[idx++] = number;
        }
        return answer;
    }
}
/*
Second Try -> 기존 ArrayList를 이용하여 계산했을 때 시간이 오래걸려 시간초과가 나는 거 같아
              우선순위 큐를 이용하여 LinkedList자료형을 이용하였고 정렬을 할 필요없이 pq에서
              뽑아서 진행하면 되는 관계로 우선순위큐를 적용하였지만 기존 ArrayList보다 오랜 시간이 걸렸다.
정확성  테스트
테스트 1 〉	통과 (3.93ms, 53.1MB)
테스트 2 〉	통과 (5.11ms, 53.6MB)
테스트 3 〉	통과 (3.18ms, 52.7MB)
테스트 4 〉	통과 (5.28ms, 53.2MB)
테스트 5 〉	통과 (2.13ms, 52.2MB)
테스트 6 〉	통과 (4.15ms, 53.1MB)
테스트 7 〉	통과 (3.57ms, 53.6MB)
테스트 8 〉	통과 (2.02ms, 52.2MB)
테스트 9 〉	통과 (4.53ms, 53.6MB)
테스트 10 〉	통과 (23.76ms, 54.5MB)
테스트 11 〉	통과 (11.69ms, 55MB)
테스트 12 〉	통과 (4.08ms, 53.5MB)
테스트 13 〉	통과 (11.67ms, 54.3MB)
테스트 14 〉	통과 (0.41ms, 52.6MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	통과 (0.45ms, 52MB)
채점 결과
정확성: 70.0
효율성: 5.0
합계: 75.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        int num = n;
        for(int i = 0; i < n; i++){
            if(i == n-1){
                pq.add(s);
                continue;
            }
            if(s/num <= 0){
                return new int[]{-1};
            }
            pq.add(s/num);
            s -= s/num;
            num-=1;
        }
        // Collections.sort(list);
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
        return answer;
    }
}
/*
Third Try -> 배열을 한번만 돌면서 끝내는 방법. pq를 사용하지않고 만약 s가 n으로 나누었을 경우 나머지가 0이라면 s를 n으로 나눈 몫을 넣고
             만약 나눠지지 않는다면 나눠지는 부분까지 몫을 넣은 뒤 +1씩 증가시켜 해결 -> 기존 pq를 사용했을 때, arraylist를 사용했을 때 보다
             빠르다
정확성  테스트
테스트 1 〉	통과 (0.10ms, 52.1MB)
테스트 2 〉	통과 (0.16ms, 53.2MB)
테스트 3 〉	통과 (0.13ms, 53.5MB)
테스트 4 〉	통과 (0.14ms, 53.2MB)
테스트 5 〉	통과 (0.04ms, 53MB)
테스트 6 〉	통과 (0.08ms, 53.7MB)
테스트 7 〉	통과 (0.05ms, 52.7MB)
테스트 8 〉	통과 (0.03ms, 52.1MB)
테스트 9 〉	통과 (0.11ms, 52.9MB)
테스트 10 〉	통과 (0.14ms, 53.9MB)
테스트 11 〉	통과 (0.15ms, 53.5MB)
테스트 12 〉	통과 (0.07ms, 53.7MB)
테스트 13 〉	통과 (0.17ms, 52.8MB)
테스트 14 〉	통과 (0.03ms, 52.9MB)
효율성  테스트
테스트 1 〉	통과 (0.21ms, 53.7MB)
테스트 2 〉	통과 (0.17ms, 54.2MB)
테스트 3 〉	통과 (0.11ms, 52.9MB)
테스트 4 〉	통과 (0.13ms, 53.1MB)
테스트 5 〉	통과 (0.18ms, 55.6MB)
테스트 6 〉	통과 (0.05ms, 52.6MB)
채점 결과
정확성: 70.0
효율성: 30.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s)
            return new int[]{-1};
        if(s%n == 0){
            for(int i = 0; i < n; i ++){
                answer[i] = s/n;
            }
        }
        else{
            int remain = s % n;
            int pos = n - remain;
            for(int i = 0; i < pos; i++){
                answer[i] = s / n;
            }
            for(int i = pos; i < n; i++){
                answer[i] = s/ n + 1;
            }
        }
        return answer;
    }
}
