import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];
        Queue<Integer> que = new LinkedList<>();
        // answer는 증설시 + 되어서 마지막 데이터 리턴
        // players의 숫자에 따라 서버 증설 및 반환
        // 여기서 중요한 점은 증설된 서버의 TimeLine을 잡는것
        // 서버의 증설 갯수와 time이 중요한데 linear하게 설계하여 해결하는게 중요
        // Queue와 Array를 활용하여 해결이 가능해보임
        for (int i = 0; i < players.length; i++) {
            // Queue의 데이터 검색후 servers의 정보를 이용하여 정리 진행
            boolean flag = false;
            int counts = 0;
            if(!que.isEmpty()) {
                while(!que.isEmpty()) {
                    // Queue의 가장 먼저들어온 위치 파악
                    int que_top = que.peek();
                    if(i < que_top) {
                        break;
                    }
                    que.poll();
                    counts++;
                    flag = true;
                }   
            }
            // 서버 갯수 Checking
            servers[i] = i != 0 ? flag ? servers[i-1] - counts : servers[i-1] : 0;

            // 증설이 필요한 경우와 아닌 경우 check
            if(players[i]/m > servers[i]) {
                int more = players[i]/m - servers[i];
                servers[i] += more;
                answer += more;
                for (int j = 0; j < more; j++) {
                    que.add(i+k);
                }
            }
        }
        
        return answer;
    }
}
