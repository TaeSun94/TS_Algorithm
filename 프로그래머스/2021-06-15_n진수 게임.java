/*
정확성  테스트
테스트 1 〉	통과 (16.36ms, 53.3MB)
테스트 2 〉	통과 (24.97ms, 54.2MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	통과 (15.98ms, 54.7MB)
테스트 5 〉	통과 (16.69ms, 53.9MB)
테스트 6 〉	통과 (18.80ms, 54.4MB)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	통과 (28.25ms, 54.5MB)
테스트 9 〉	통과 (21.58ms, 53.5MB)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	통과 (19.68ms, 54.4MB)
테스트 12 〉	통과 (23.38ms, 54.6MB)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	통과 (58.56ms, 59.2MB)
테스트 15 〉	통과 (54.78ms, 59.1MB)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	통과 (27.14ms, 54.8MB)
테스트 18 〉	통과 (23.69ms, 53.8MB)
테스트 19 〉	통과 (20.60ms, 53.3MB)
테스트 20 〉	통과 (33.51ms, 53.6MB)
테스트 21 〉	통과 (24.40ms, 55.2MB)
테스트 22 〉	통과 (38.25ms, 55.5MB)
테스트 23 〉	통과 (41.18ms, 55.4MB)
테스트 24 〉	통과 (59.91ms, 58.1MB)
테스트 25 〉	통과 (43.41ms, 56.6MB)
테스트 26 〉	통과 (30.95ms, 54.4MB)
채점 결과
정확성: 80.8
합계: 80.8 / 100.0
*/
class Solution {
    static String characterNum = "0123456789ABCDEF";
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int idx = 1;
        int num = 0;
        while(t>0){
            //진수 변환
            String str = trans(num++, n);

            //숫자 부르기
            for(int i = 0; i < str.length(); i++){
                if(idx%m == p){
                    answer += str.charAt(i);
                    t--;
                    if(t == 0)
                        break;
                }
                idx++;
            }
        }
        return answer;
    }
    public String trans(int num, int n){
        String tmp = "";
        if(num == 0)
            return "0";
        else if(n == 10)
            return num+"";
        while(num != 0){
            tmp = characterNum.charAt(num%n)+tmp;
            num /= n;
        }
        return tmp;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (17.38ms, 54.3MB)
테스트 2 〉	통과 (17.36ms, 53.5MB)
테스트 3 〉	통과 (20.47ms, 53.2MB)
테스트 4 〉	통과 (20.57ms, 53.3MB)
테스트 5 〉	통과 (18.26ms, 54.4MB)
테스트 6 〉	통과 (18.96ms, 53.4MB)
테스트 7 〉	통과 (19.61ms, 54MB)
테스트 8 〉	통과 (17.10ms, 53.8MB)
테스트 9 〉	통과 (29.13ms, 53.6MB)
테스트 10 〉	통과 (19.24ms, 53.5MB)
테스트 11 〉	통과 (18.80ms, 53.6MB)
테스트 12 〉	통과 (24.45ms, 54.1MB)
테스트 13 〉	통과 (21.52ms, 53.4MB)
테스트 14 〉	통과 (55.41ms, 59MB)
테스트 15 〉	통과 (50.22ms, 60MB)
테스트 16 〉	통과 (53.10ms, 59.4MB)
테스트 17 〉	통과 (31.52ms, 53.7MB)
테스트 18 〉	통과 (33.90ms, 53.9MB)
테스트 19 〉	통과 (19.76ms, 54.1MB)
테스트 20 〉	통과 (29.87ms, 53.9MB)
테스트 21 〉	통과 (43.83ms, 54.9MB)
테스트 22 〉	통과 (35.37ms, 55.6MB)
테스트 23 〉	통과 (42.55ms, 56.4MB)
테스트 24 〉	통과 (48.42ms, 56.3MB)
테스트 25 〉	통과 (44.93ms, 56.4MB)
테스트 26 〉	통과 (34.74ms, 54.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/

class Solution {
    static String characterNum = "0123456789ABCDEF";
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int idx = 1;
        int num = 0;
        if(m == p)
            p = 0;
        while(t>0){
            //진수 변환
            String str = trans(num++, n);
            //숫자 부르기
            for(int i = 0; i < str.length(); i++){
                if(idx%m == p){
                    answer += str.charAt(i);
                    t--;
                    if(t == 0)
                        break;
                }
                idx++;
            }
        }
        return answer;
    }
    public String trans(int num, int n){
        String tmp = "";
        if(num == 0)
            return "0";
        else if(n == 10)
            return num+"";
        while(num != 0){
            tmp = characterNum.charAt(num%n)+tmp;
            num /= n;
        }
        return tmp;
    }
}
