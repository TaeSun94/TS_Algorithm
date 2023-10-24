import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int keyMapLength = keymap.length;
        for (int i = 0; i < keyMapLength; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                if (hashMap.containsKey(key.charAt(j))) {
                    if (hashMap.get(key.charAt(j)) > j + 1) {
                        hashMap.replace(key.charAt(j), j+1);
                    }
                }
                else {
                    hashMap.put(key.charAt(j), j + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int num = 0;
            boolean flag = false;
            for (int j = 0; j < targets[i].length(); j++) {
                if(!hashMap.containsKey(targets[i].charAt(j))) {
                    flag = true;
                    break;
                }
                num += hashMap.get(targets[i].charAt(j));
            }
            if (flag) {
                answer[i] = -1;
                continue;
            }
            answer[i] = num;
        }
        return answer;
    }
}
