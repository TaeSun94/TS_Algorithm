/*
정확성  테스트
테스트 1 〉	통과 (123.01ms, 74.7MB)
테스트 2 〉	통과 (12.12ms, 52.4MB)
테스트 3 〉	통과 (12.20ms, 54.7MB)
테스트 4 〉	통과 (11.81ms, 53.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> answers;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        for(int i = 0; i < tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(from.equals("ICN")){
                visited[i] = true;
                dfs(from+","+to,to,tickets,1);
                visited[i] = false;
            }
        }
        Collections.sort(answers);
        answer = answers.get(0).split(",");
        return answer;
    }

    public void dfs(String route, String airport, String[][] tickets, int count){
        if(count == tickets.length){
            answers.add(route);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(airport.equals(from) && !visited[i]){
                visited[i] = true;
                dfs(route+","+to, to, tickets, count+1);
                visited[i] = false;
            }
        }
    }
}
