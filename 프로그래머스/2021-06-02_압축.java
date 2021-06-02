import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i = 0; i < 26; i++){
            String str = ""+(char)('A'+i);
            dic.put(str,i+1);
        }
        // for(String key: dic.keySet()){
        //     System.out.println(key);
        // }
        for(int i = 0; i < msg.length(); i++){
            String tmp = ""+msg.charAt(i);
            for(int j = i+1; j < msg.length(); j++){
                if(!dic.containsKey(tmp+msg.charAt(j))){
                    dic.put(tmp+msg.charAt(j),dic.size()+1);
                    break;
                }
                tmp += msg.charAt(j);
            }
            i += tmp.length()-1;
            list.add(dic.get(tmp));
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int num: list){
            answer[idx++] = num;
        }
        return answer;
    }
}
