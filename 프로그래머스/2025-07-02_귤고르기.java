import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if(hm.containsKey(tangerine[i])) {
                hm.replace(tangerine[i], hm.get(tangerine[i]) + 1);
            } else {
                hm.put(tangerine[i], 1);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int key: hm.keySet()){
            al.add(hm.get(key));
        }
        Collections.sort(al, Collections.reverseOrder());
        int counts = 0;
        for (int i = 0; i < al.size(); i++) {
            counts += al.get(i);
            if ( k <= counts) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}
