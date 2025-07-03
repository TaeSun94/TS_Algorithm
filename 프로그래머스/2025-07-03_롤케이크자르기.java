import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> leftHM = new HashMap<>();
        HashMap<Integer, Integer> rightHM = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            if (rightHM.containsKey(topping[i])) {
                rightHM.replace(topping[i], rightHM.get(topping[i]) + 1);
            } else {
                rightHM.put(topping[i], 1);
            }
        }
        
        for (int i = 0; i < topping.length; i++) {
            // LEFT에 추가
            if (!leftHM.containsKey(topping[i])) {
                leftHM.put(topping[i], 1);
            }
            // RIGHT에서 제거
            rightHM.replace(topping[i], rightHM.get(topping[i]) - 1);
            if (rightHM.get(topping[i]) == 0) {
                rightHM.remove(topping[i]);
            }
            
            if (leftHM.size() == rightHM.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
