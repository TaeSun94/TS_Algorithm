/*
First Try -> 초기 지원하는 곳에 대하여 boolean배열을 이용하여 데이터를 만들어 준 뒤에
             배열의 시작부터 검사를 하며 지원하지 않는 곳을 세어가며 w만큼 채워졌을 경우에
             기지국을 설치한 뒤 해당 인덱스에서 w만큼을 더하여 다음을 확인하는 방법.
             정확성에서 빠른 시간을 보이지만 효율성에서 시간초과가 남. 이는 초기 데이터를 설정할 때 생기는것으로 보임.
정확성  테스트
테스트 1 〉	통과 (0.05ms, 52.6MB)
테스트 2 〉	통과 (0.02ms, 51.6MB)
테스트 3 〉	통과 (0.02ms, 54MB)
테스트 4 〉	통과 (0.02ms, 51.9MB)
테스트 5 〉	통과 (0.02ms, 52.8MB)
테스트 6 〉	통과 (0.02ms, 53.3MB)
테스트 7 〉	통과 (0.03ms, 52.8MB)
테스트 8 〉	통과 (0.03ms, 54.5MB)
테스트 9 〉	통과 (0.02ms, 52.3MB)
테스트 10 〉	통과 (0.02ms, 54MB)
테스트 11 〉	통과 (0.02ms, 52.4MB)
테스트 12 〉	통과 (0.04ms, 53.3MB)
테스트 13 〉	통과 (0.02ms, 52.6MB)
테스트 14 〉	통과 (0.02ms, 51.9MB)
테스트 15 〉	통과 (0.02ms, 52.7MB)
테스트 16 〉	통과 (0.04ms, 52.4MB)
테스트 17 〉	통과 (0.02ms, 53MB)
테스트 18 〉	통과 (0.03ms, 53.1MB)
테스트 19 〉	통과 (0.03ms, 52.4MB)
테스트 20 〉	통과 (0.02ms, 53MB)
테스트 21 〉	통과 (0.02ms, 53.6MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 70.5
효율성: 0.0
합계: 70.5 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean[] apartment = new boolean[n];
        for(int i = 0; i<stations.length; i++){
            int Lpos = 0;
            int Rpos = n-1;
            if(stations[i]-1-w >=0){
                Lpos = stations[i]-1-w;
            }
            else{
                Lpos = 0;
            }
            if(stations[i]-1+w < n){
                Rpos = stations[i]-1+w;
            }
            else{
                Rpos = n-1;
            }
            for(int j = Lpos; j <= Rpos; j++){
                apartment[j] = true;
            }
        }
        // System.out.println(Arrays.toString(apartment));
        int cnt = 0;
        for(int i = 0; i < apartment.length; i++){
            if(!apartment[i]){
                cnt++;
                if(cnt > w){
                    answer++;
                    cnt = 0;
                    i += w;
                }
            }
            else{
                if(cnt != 0){
                    answer++;
                    cnt = 0;
                }
            }
        }
        if(cnt!=0)
            answer++;
        return answer;
    }
}
/*
Second Try -> Mod연산을 통해 추가 설치 갯수로 풀이
정확성  테스트
테스트 1 〉	통과 (0.02ms, 52.6MB)
테스트 2 〉	통과 (0.02ms, 52.4MB)
테스트 3 〉	통과 (0.02ms, 51.7MB)
테스트 4 〉	통과 (0.02ms, 52.5MB)
테스트 5 〉	통과 (0.02ms, 53MB)
테스트 6 〉	통과 (0.03ms, 52.2MB)
테스트 7 〉	통과 (0.02ms, 52.6MB)
테스트 8 〉	통과 (0.01ms, 53.1MB)
테스트 9 〉	통과 (0.02ms, 52.3MB)
테스트 10 〉	통과 (0.02ms, 52MB)
테스트 11 〉	통과 (0.03ms, 53.1MB)
테스트 12 〉	통과 (0.03ms, 53MB)
테스트 13 〉	통과 (0.02ms, 52.7MB)
테스트 14 〉	통과 (0.02ms, 52.9MB)
테스트 15 〉	통과 (0.02ms, 52.1MB)
테스트 16 〉	통과 (0.02ms, 51.8MB)
테스트 17 〉	통과 (0.02ms, 52.3MB)
테스트 18 〉	통과 (0.02ms, 51.8MB)
테스트 19 〉	통과 (0.02ms, 52.1MB)
테스트 20 〉	통과 (0.02ms, 52.9MB)
테스트 21 〉	통과 (0.03ms, 52.4MB)
효율성  테스트
테스트 1 〉	통과 (0.70ms, 53.6MB)
테스트 2 〉	통과 (0.74ms, 53.3MB)
테스트 3 〉	통과 (0.67ms, 53.2MB)
테스트 4 〉	통과 (0.68ms, 54.3MB)
채점 결과
정확성: 70.5
효율성: 29.5
합계: 100.0 / 100.0
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int Lpos = 1;
        int range = 2*w +1;
        for(int i = 0; i < stations.length; i++){
            if(Lpos > n)
                break;
            int left = stations[i]-w;
            if(Lpos < left){
                if((left - Lpos)%range != 0){
                    answer += 1;
                }
                answer += (left-Lpos)/range;
            }
            Lpos = stations[i]+w+1;
        }
        if(Lpos < n){
            if((n-Lpos)%range!=0)
                answer++;
            answer += (n-Lpos)/range;
        }
        else if(Lpos == n)
            answer++;
        return answer;
    }
}
