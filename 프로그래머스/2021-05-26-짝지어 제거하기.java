import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stk.isEmpty()){
                stk.push(s.charAt(i));
                continue;
            }
            if(stk.peek() == s.charAt(i)){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        if(stk.isEmpty())
            answer = 1;
        return answer;
    }
}
