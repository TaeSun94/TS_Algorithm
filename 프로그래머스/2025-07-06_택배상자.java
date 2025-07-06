import java.util.*;

/*
보조 컨테이너 - Stack의 자료구조
*/
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        boolean flag = true;
        int len = order.length;
        int box_num = 1;
        // order는 뽑고싶은 상자의 번호

        for (int i = 0; i < len; i++) {
            if (box_num <= order[i]) {
                if(box_num < order[i]) {
                    while (box_num < order[i]) {
                        stack.push(box_num++);
                    }
                }
                box_num++;
                answer++;
            } else {
                if (stack.peek() == order[i]) {
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}
