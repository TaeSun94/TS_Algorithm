import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Integer, Character> words = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < 26; i ++) {
            char character = (char)('a'+i);
            if(!skip.contains(character+"")) {
                hm.put(character, idx);
                words.put(idx++, character);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int num = hm.get(s.charAt(i)) + index;
            if(num >= hm.size()) {
                num -= hm.size() * (num / hm.size());
            }
            answer += words.get(num);
        }
        
        return answer;
    }
}
