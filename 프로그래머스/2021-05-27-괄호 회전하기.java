import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i,s.length())+s.substring(0,i);
            if(check(str))
                answer++;
        }

        return answer;
    }
    public boolean check(String str){
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='(')
                stk.push(str.charAt(i));
            else{
                if(stk.isEmpty())
                    return false;
                if(str.charAt(i)==']'){
                    if(stk.peek()!='[')
                        return false;
                    stk.pop();
                }
                else if(str.charAt(i)==')'){
                    if(stk.peek()!='(')
                        return false;
                    stk.pop();
                }
                else{
                    if(stk.peek()!='{')
                        return false;
                    stk.pop();
                }
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }
}
