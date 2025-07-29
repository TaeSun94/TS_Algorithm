import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardOneQue = new LinkedList<>();
        Queue<String> cardTwoQue = new LinkedList<>();
        for (int i = 0; i < cards1.length; i++) {
            cardOneQue.add(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            cardTwoQue.add(cards2[i]);
        }
        
        int idx = 0;
        boolean flag = false;
        while (true) {
            if (flag || idx >= goal.length) {
                break;
            }
            if (!cardOneQue.isEmpty() && cardOneQue.peek().equals(goal[idx])) {
                cardOneQue.poll();
                idx++;
            } else {
                if (!cardTwoQue.isEmpty() && cardTwoQue.peek().equals(goal[idx])) {
                    cardTwoQue.poll();
                    idx++;
                }
                else {
                    flag = true;
                }
            }
        }
        
        return flag ? "No" : "Yes";
    }
}
