import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> matchingNumber = new HashMap<>();
        matchingNumber.put('I', 1);
        matchingNumber.put('V', 5);
        matchingNumber.put('X', 10);
        matchingNumber.put('L', 50);
        matchingNumber.put('C', 100);
        matchingNumber.put('D', 500);
        matchingNumber.put('M', 1000);
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('I',0);
        priority.put('V',1);
        priority.put('X',2);
        priority.put('L',3);
        priority.put('C',4);
        priority.put('D',5);
        priority.put('M',6);

        Stack<Character> stack = new Stack<>();
        for(int i = s.length() -1; i >= 0; i-- ){
            stack.push(s.charAt(i));
        }

        int result = 0;

        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(stack.isEmpty()) {
                result += matchingNumber.get(c);
                break;
            }

            if (priority.get(c) < priority.get(stack.peek())) {
                result += matchingNumber.get(stack.peek()) - matchingNumber.get(c);
                stack.pop();
            }
            else {
                result += matchingNumber.get(c);
            }
        }

        return result;
    }
}
