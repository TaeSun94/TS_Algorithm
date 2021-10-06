/*
정확성  테스트
테스트 1 〉	통과 (6.47ms, 75.3MB)
테스트 2 〉	통과 (8.29ms, 85MB)
테스트 3 〉	통과 (8.68ms, 80.1MB)
테스트 4 〉	통과 (6.09ms, 77.6MB)
테스트 5 〉	통과 (7.97ms, 80.6MB)
테스트 6 〉	통과 (0.21ms, 70.5MB)
테스트 7 〉	통과 (0.19ms, 77.8MB)
테스트 8 〉	통과 (1.11ms, 75MB)
테스트 9 〉	통과 (1.68ms, 80.3MB)
테스트 10 〉	통과 (6.32ms, 80.6MB)
테스트 11 〉	통과 (6.72ms, 77.8MB)
테스트 12 〉	통과 (5.56ms, 77.4MB)
테스트 13 〉	통과 (8.00ms, 75.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int min;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            init(n);
            for(int j = 0; j < wires.length; j++){
                if(i == j)
                    continue;
                adj[wires[j][0]].add(wires[j][1]);
                adj[wires[j][1]].add(wires[j][0]);
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    ans.add(countNode(j));
                }
            }
            int n1 = ans.get(0);
            int n2 = ans.get(1);
            min = Math.min(min, Math.abs(n1-n2));
        }

        return min;
    }
    public void init(int n){
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int k = 1; k <= n; k++)
            adj[k] = new ArrayList<>();

        return;
    }
    public int countNode(int nodeNum){
        Queue<Integer> que = new LinkedList<>();
        int cnt = 1;
        que.add(nodeNum);
        visited[nodeNum] = true;
        while(!que.isEmpty()){
            int num = que.poll();
            for(int next: adj[num]){
                if(!visited[next]){
                    visited[next] = true;
                    que.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
