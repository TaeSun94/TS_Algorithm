import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int total = 0;

        for (int i = 0; i < want.length; i++) {
            hm.put(want[i], number[i]);
            total += number[i];
        }
        
        for (int i = 0; i < discount.length; i++) {
            if (total > discount.length - i) {
                break;
            }
            if (check(discount, i, hm)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(String[] discount, int start, HashMap<String, Integer> hm) {
        HashMap<String, Integer> map = new HashMap<>();
        int counts = 0;
        for (int i = start; i < discount.length; i++) {
            if (counts == 10) {
                break;
            }
            if (map.containsKey(discount[i])) {
                map.replace(discount[i], map.get(discount[i]) + 1);
            } else {
                map.put(discount[i], 1);
            }
            counts++;
        }
        
        for (String key: hm.keySet()) {
            if (map.containsKey(key)) {
                if (hm.get(key) > map.get(key)){
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
