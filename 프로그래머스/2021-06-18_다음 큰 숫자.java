/*
정확성  테스트
테스트 1 〉	실패 (런타임 에러)
테스트 2 〉	통과 (2.33ms, 52.2MB)
테스트 3 〉	통과 (2.57ms, 52.7MB)
테스트 4 〉	통과 (2.42ms, 53.3MB)
테스트 5 〉	실패 (2.67ms, 52.5MB)
테스트 6 〉	통과 (2.68ms, 54.6MB)
테스트 7 〉	실패 (2.47ms, 54.4MB)
테스트 8 〉	통과 (2.36ms, 52.2MB)
테스트 9 〉	실패 (4.99ms, 56.3MB)
테스트 10 〉	통과 (2.56ms, 52.4MB)
테스트 11 〉	통과 (2.46ms, 53.5MB)
테스트 12 〉	통과 (2.37ms, 52.5MB)
테스트 13 〉	통과 (2.61ms, 51.8MB)
테스트 14 〉	통과 (2.30ms, 52.3MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
채점 결과
정확성: 50.0
효율성: 0.0
합계: 50.0 / 100.0
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toBinaryString(n);
        String tmp = "";
        for(int i = 0; i < number.length(); i++){
            tmp+="1";
        }
        if(number.equals(tmp)){
            tmp = "10"+number.substring(1,number.length());
            double sum = 0.0;
            for(int i = tmp.length()-1; i >= 0; i--){
                if(tmp.charAt(i)=='1')
                    sum += Math.pow(2,tmp.length()-1-i);
            }
            answer += sum;
        }
        else{
            tmp = "";
            int cnt = -1;
            boolean flag = false;
            int pos = -1;
            for(int i = number.length()-1; i >=0; i--){
                if(number.charAt(i)=='1'){
                    flag = true;
                    cnt++;
                }
                else{
                    if(flag){
                        pos = i;
                        break;
                    }
                }
            }
            if(!flag){
                pos = 0;
            }
            tmp = number.substring(0,pos)+"1";
            for(int i = 0; i <= number.length()-tmp.length()-cnt; i++){
                tmp+="0";
            }
            for(int i = 0; i < cnt; i++){
                tmp += "1";
            }
            double sum = 0.0;
            for(int i = tmp.length()-1; i >= 0; i--){
                if(tmp.charAt(i)=='1')
                    sum += Math.pow(2,tmp.length()-1-i);
            }
            answer += sum;
        }
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 51.9MB)
테스트 2 〉	통과 (0.03ms, 52.2MB)
테스트 3 〉	통과 (0.03ms, 52.4MB)
테스트 4 〉	통과 (0.02ms, 54MB)
테스트 5 〉	통과 (0.02ms, 52.6MB)
테스트 6 〉	통과 (0.03ms, 53.7MB)
테스트 7 〉	통과 (0.02ms, 52.5MB)
테스트 8 〉	통과 (0.02ms, 52.5MB)
테스트 9 〉	통과 (0.02ms, 52.6MB)
테스트 10 〉	통과 (0.02ms, 53.8MB)
테스트 11 〉	통과 (0.02ms, 52.6MB)
테스트 12 〉	통과 (0.03ms, 53.1MB)
테스트 13 〉	통과 (0.02ms, 51.9MB)
테스트 14 〉	통과 (0.02ms, 52.7MB)
효율성  테스트
테스트 1 〉	통과 (0.02ms, 52MB)
테스트 2 〉	통과 (0.02ms, 52.6MB)
테스트 3 〉	통과 (0.02ms, 52.8MB)
테스트 4 〉	통과 (0.02ms, 53MB)
테스트 5 〉	통과 (0.03ms, 52.8MB)
테스트 6 〉	통과 (0.02ms, 52.5MB)
채점 결과
정확성: 70.0
효율성: 30.0
합계: 100.0 / 100.0
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        int nBit = Integer.bitCount(n);
        for(int i = n+1; ;i++){
            if(Integer.bitCount(i)==nBit){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
