import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String>[] list = new ArrayList[n];
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<String>();
        }
        list[0].add(words[0]);
        char first = words[0].charAt(words[0].length()-1);
        hs.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(hs.contains(words[i])){
                answer[0] = i%n+1;
                answer[1] = list[i%n].size()+1;
                break;
            }
            if(first != words[i].charAt(0)){
                answer[0] = i%n+1;
                answer[1] = list[i%n].size()+1;
                break;
            }
            first = words[i].charAt(words[i].length()-1);
            hs.add(words[i]);
            list[i%n].add(words[i]);
        }

        return answer;
    }
}
