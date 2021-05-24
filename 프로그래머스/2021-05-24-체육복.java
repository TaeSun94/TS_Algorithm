import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        ArrayList<Integer> nLost = new ArrayList<>();
        ArrayList<Integer> nReser = new ArrayList<>();

        for(int i = 0; i < lost.length; i++){
            nLost.add(lost[i]);
        }
        for(int i = 0; i < reserve.length; i++){
            nReser.add(reserve[i]);
        }
        for(int i = 0; i < nLost.size(); i++){
            for(int j = 0; j < nReser.size(); j++){
                if(nReser.get(j)==nLost.get(i)){
                    nReser.remove(nReser.get(j));
                    nLost.remove(nLost.get(i));
                    i -= 1;
                    break;
                }
            }
        }
        for(int i = 0; i < nLost.size(); i++){
            for(int j = 0; j < nReser.size(); j++){
                if(nReser.get(j)-1==nLost.get(i)){
                    nReser.remove(nReser.get(j));
                    nLost.remove(nLost.get(i));
                    i -= 1;
                    break;
                }
                if(nReser.get(j)+1==nLost.get(i)){
                    nReser.remove(nReser.get(j));
                    nLost.remove(nLost.get(i));
                    i -= 1;
                    break;
                }
            }
        }
        answer -= nLost.size();
		return answer;
	}
}
