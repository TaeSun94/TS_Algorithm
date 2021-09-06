/*
First Try-> 확률 구하는 부분에서 오류가 있는거 같다. 주어진 조건에 따라 객체를 생성하고
필요한 변수를 정의하여 만들었지만 확률 부분에서 오류가 있는 것으로 추정.
정확성  테스트
테스트 1 〉	통과 (0.55ms, 71.5MB)
테스트 2 〉	통과 (0.81ms, 61.1MB)
테스트 3 〉	통과 (0.56ms, 68.1MB)
테스트 4 〉	통과 (0.46ms, 59.8MB)
테스트 5 〉	통과 (0.57ms, 67.9MB)
테스트 6 〉	실패 (18.59ms, 78.2MB)
테스트 7 〉	실패 (20.90ms, 75.6MB)
테스트 8 〉	실패 (21.59ms, 78.4MB)
테스트 9 〉	실패 (14.02ms, 60.4MB)
테스트 10 〉	통과 (11.07ms, 63.5MB)
테스트 11 〉	통과 (23.66ms, 78.4MB)
테스트 12 〉	통과 (15.41ms, 62.8MB)
채점 결과
정확성: 66.7
합계: 66.7 / 100.0
*/
import java.util.*;
class Solution {
    static class Player{
        int number, overWeightWinCount, weight;
        int winRate;
        Player(int number, int overWeightWinCount, int weight, int winRate){
            this.number = number;
            this.overWeightWinCount = overWeightWinCount;
            this.weight = weight;
            this.winRate = winRate;
        }
        public String toString(){
            return this.number+" "+this.overWeightWinCount+" "+weight+" "+winRate;
        }
    }
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        ArrayList<Player> players = new ArrayList<>();
        for(int idx = 0; idx < weights.length; idx++){
            int number = idx + 1;
            int playerWeight = weights[idx];
            int overWeightWinCount = 0;
            int winCount = 0;
            int numbers = weights.length;
            for(int stringIdx = 0; stringIdx < head2head[idx].length(); stringIdx++){
                if(head2head[idx].charAt(stringIdx)=='N'){
                    numbers--;
                    continue;
                }
                if(head2head[idx].charAt(stringIdx)=='W'){
                    if(playerWeight < weights[stringIdx]){
                        overWeightWinCount++;
                    }
                    winCount++;
                }
            }
            if(numbers == 0){
                players.add(new Player(number,overWeightWinCount,playerWeight,0));
                continue;
            }
            int rate = winCount*10000/numbers;
            players.add(new Player(number,overWeightWinCount,playerWeight,rate));
        }
        Collections.sort(players, new Comparator<Player>(){
           public int compare(Player o1, Player o2){
               if(o1.winRate==o2.winRate){
                   if(o1.overWeightWinCount == o2.overWeightWinCount){
                       if(o1.weight == o2.weight){
                           return o1.number-o2.number;
                       }
                       else
                           return -(o1.weight-o2.weight);
                   }
                   else
                       return -(o1.overWeightWinCount-o2.overWeightWinCount);
               }
               else
                   return -(o1.winRate-o2.winRate);
           }
        });

        //정답 도출
        int index = 0;
        for(Player player: players){
            answer[index++] = player.number;
        }

        return answer;
    }
}
