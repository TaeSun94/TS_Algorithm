import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<Integer, String> orders = new HashMap<>();
        HashMap<String, Integer> playerIndex = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            orders.put(i+1, players[i]);
            playerIndex.put(players[i], i+1);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int idx = playerIndex.get(callings[i]);
            if(idx == 1) {
                continue;
            }
            String prevPlayer = orders.get(idx-1);
            orders.replace(idx-1, callings[i]);
            orders.replace(idx, prevPlayer);
            playerIndex.replace(callings[i], idx-1);
            playerIndex.replace(prevPlayer, idx);
        }
        int idx = 0;
        for(int key: orders.keySet()) {
            answer[idx++] = orders.get(key);
        }
        return answer;
    }
}
