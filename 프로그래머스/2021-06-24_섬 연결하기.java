/*
정확성  테스트
테스트 1 〉	통과 (0.75ms, 52.5MB)
테스트 2 〉	통과 (0.68ms, 52.9MB)
테스트 3 〉	통과 (0.73ms, 53.3MB)
테스트 4 〉	통과 (0.75ms, 52.8MB)
테스트 5 〉	통과 (0.68ms, 52.4MB)
테스트 6 〉	통과 (0.90ms, 52.8MB)
테스트 7 〉	통과 (0.96ms, 52.5MB)
테스트 8 〉	통과 (0.70ms, 52.3MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int from,to,cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge e){
            return this.cost-e.cost;
        }
    }
    static int[] parents;
    static int[] ranks;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Edge> list = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < costs.length; i++){
            pq.add(new Edge(costs[i][0],costs[i][1],costs[i][2]));
        }
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(findSet(e.from) != findSet(e.to)){
                answer += e.cost;
                union(e.from, e.to);
            }
        }
        // boolean[] visited = new boolean[n];
        // Collections.sort(list, new Comparator<Edge>(){
        //     public int compare(Edge o1, Edge o2){
        //         return o1.cost-o2.cost;
        //     }
        // });
        // for(Edge e: list){
        //     if(visited[e.from] && visited[e.to])
        //         continue;
        //     if(!visited[e.from] || !visited[e.to]){
        //         visited[e.from] = true;
        //         visited[e.to] = true;
        //         answer += e.cost;
        //     }
        // }
        return answer;
    }
    public int findSet(int i){
        if(parents[i] == i){
            return i;
        }
        else{
            return findSet(parents[i]);
        }
    }
    public void union(int x, int y){
        x = findSet(x);
        y = findSet(y);
        if(x==y)
            return;
        if(ranks[x] < ranks[y])
            parents[x] = y;
        else{
            parents[y] = x;
            ranks[y]++;
        }
    }
}
