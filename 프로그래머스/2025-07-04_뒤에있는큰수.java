import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[numbers.length-1]);
        
        answer[numbers.length - 1] = -1;
        
        for (int i = numbers.length - 2; i >= 0; i--) {
            int target = numbers[i];
            
            if(numbers[i+1]>target){
                answer[i] = numbers[i+1];
            }else{
                
                while( !stack.isEmpty()&& stack.peek() <= target ){
                    stack.pop();
                }
                
                answer[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(target);
        }
        
        return answer;
    }
}
