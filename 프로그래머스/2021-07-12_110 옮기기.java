/*
정확성  테스트
테스트 1 〉	통과 (1378.30ms, 372MB)
테스트 2 〉	통과 (4263.78ms, 372MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	통과 (1434.56ms, 372MB)
테스트 6 〉	통과 (3944.63ms, 372MB)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	통과 (493.31ms, 322MB)
테스트 10 〉	통과 (705.51ms, 337MB)
테스트 11 〉	통과 (545.27ms, 331MB)
테스트 12 〉	통과 (727.16ms, 395MB)
테스트 13 〉	통과 (703.98ms, 339MB)
테스트 14 〉	통과 (812.52ms, 333MB)
테스트 15 〉	통과 (641.34ms, 336MB)
테스트 16 〉	통과 (695.61ms, 381MB)
테스트 17 〉	통과 (496.06ms, 286MB)
테스트 18 〉	통과 (7555.20ms, 365MB)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실패 (시간 초과)
채점 결과
정확성: 66.7
합계: 66.7 / 100.0
*/
import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        //110찾기 앞쪽부터 111세개가 중복되는 곳과 자리 변경
        for(int index = 0; index < s.length; index++){
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s[index].length(); i++){
                stack.push(s[index].charAt(i));
                if(stack.size() < 3){
                    continue;
                }
                String tmp = "";
                for(int k = 0; k < 3; k++){
                    tmp = stack.pop()+tmp;
                }
                if(tmp.equals("110")){
                    count++;
                    continue;
                }
                for(int k = 0; k < tmp.length(); k++){
                    stack.push(tmp.charAt(k));
                }
            }
            if(count == 0){
                answer[index] = s[index];
                continue;
            }
            String ans = "";
            while(!stack.isEmpty()){
                ans = stack.pop()+ans;
            }
            for(int i = ans.length()-1; i >= 0; i--){
                if(ans.charAt(i)=='0'){
                    for(int j = 0; j < count; j++){
                        ans = ans.substring(0,i+1)+"110"+ans.substring(i+1,ans.length());
                    }
                    count = 0;
                    break;
                }
            }
            if(count > 0){
                for(int cnt = 0; cnt < count; cnt++){
                    ans = "110"+ans;
                }
            }
            answer[index] = ans;
        }
        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (451.39ms, 307MB)
테스트 2 〉	통과 (524.54ms, 295MB)
테스트 3 〉	통과 (859.75ms, 211MB)
테스트 4 〉	통과 (2677.48ms, 329MB)
테스트 5 〉	통과 (390.18ms, 289MB)
테스트 6 〉	통과 (568.05ms, 292MB)
테스트 7 〉	통과 (798.08ms, 190MB)
테스트 8 〉	통과 (723.06ms, 130MB)
테스트 9 〉	통과 (534.72ms, 345MB)
테스트 10 〉	통과 (510.15ms, 341MB)
테스트 11 〉	통과 (572.16ms, 346MB)
테스트 12 〉	통과 (498.10ms, 346MB)
테스트 13 〉	통과 (585.09ms, 305MB)
테스트 14 〉	통과 (569.79ms, 336MB)
테스트 15 〉	통과 (578.54ms, 324MB)
테스트 16 〉	통과 (551.32ms, 297MB)
테스트 17 〉	통과 (414.37ms, 293MB)
테스트 18 〉	통과 (1151.05ms, 258MB)
테스트 19 〉	통과 (3234.09ms, 308MB)
테스트 20 〉	통과 (1017.25ms, 230MB)
테스트 21 〉	통과 (3781.59ms, 306MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int index = 0; index < s.length; index++){
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s[index].length(); i++){
                stack.push(s[index].charAt(i));
                if(stack.size() < 3){
                    continue;
                }
                String tmp = "";
                for(int k = 0; k < 3; k++){
                    tmp = stack.pop()+tmp;
                }
                if(tmp.equals("110")){
                    count++;
                    continue;
                }
                for(int k = 0; k < tmp.length(); k++){
                    stack.push(tmp.charAt(k));
                }
            }
            if(count == 0){
                answer[index] = s[index];
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.insert(0,stack.pop());
            }
            for(int i = sb.length()-1; i >= 0; i--){
                if(sb.charAt(i)=='0'){
                    // for(int j = 0; j < count; j++){
                    //     ans = ans.substring(0,i+1)+"110"+ans.substring(i+1,ans.length());
                    // }
                    while(count>0){
                        sb.insert(i+1,"110");
                        count--;
                    }
                    break;
                }
            }
            if(count > 0){
                while(count>0){
                    sb.insert(0,"110");
                    count--;
                }
            }
            answer[index] = sb.toString();
        }
        return answer;
    }
}
