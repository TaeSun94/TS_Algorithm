import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hs = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!hs.containsKey(clothes[i][1])){
                hs.put(clothes[i][1],1);
            }
            else{
                hs.replace(clothes[i][1],hs.get(clothes[i][1])+1);
            }
        }
        if(hs.size() == 1){
            for(String key: hs.keySet()){
                return hs.get(key);
            }
        }
        int[] ans = new int[hs.size()];
        int idx = 0;
        for(String key: hs.keySet()){
            ans[idx++] = hs.get(key)+1;
        }
        answer = 1;
        for(int nums: ans){
            answer *= nums;
        }
        answer -= 1;
        return answer;
    }
}
