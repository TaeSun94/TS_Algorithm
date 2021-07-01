/*
정확성  테스트
테스트 1 〉	통과 (0.86ms, 52.9MB)
테스트 2 〉	통과 (0.83ms, 52.6MB)
테스트 3 〉	통과 (0.78ms, 53.5MB)
테스트 4 〉	통과 (2.11ms, 53MB)
테스트 5 〉	통과 (1.51ms, 52.4MB)
테스트 6 〉	통과 (1.96ms, 54.4MB)
테스트 7 〉	통과 (1.92ms, 52.5MB)
테스트 8 〉	통과 (1.88ms, 52.9MB)
테스트 9 〉	통과 (2.69ms, 52.4MB)
테스트 10 〉	통과 (2.68ms, 52.6MB)
효율성  테스트
테스트 1 〉	통과 (28.75ms, 54.9MB)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	통과 (58.87ms, 56.1MB)
테스트 4 〉	통과 (55.13ms, 57.5MB)
테스트 5 〉	통과 (53.90ms, 56.2MB)
테스트 6 〉	통과 (52.00ms, 56.8MB)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	통과 (112.31ms, 66.8MB)
테스트 10 〉	통과 (118.63ms, 66.6MB)
테스트 11 〉	통과 (128.16ms, 66.8MB)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	통과 (217.32ms, 67.8MB)
테스트 14 〉	통과 (214.99ms, 67.7MB)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	통과 (44.45ms, 55.5MB)
테스트 17 〉	통과 (55.99ms, 55.7MB)
테스트 18 〉	통과 (43.46ms, 55.6MB)
테스트 19 〉	통과 (94.78ms, 57.8MB)
테스트 20 〉	통과 (96.00ms, 56.7MB)
테스트 21 〉	통과 (126.82ms, 59.3MB)
테스트 22 〉	실패 (시간 초과)
테스트 23 〉	통과 (201.83ms, 68.5MB)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	통과 (29.54ms, 55.4MB)
테스트 26 〉	통과 (36.08ms, 55.1MB)
테스트 27 〉	통과 (105.97ms, 57.6MB)
테스트 28 〉	실패 (시간 초과)
테스트 29 〉	통과 (25.28ms, 53.2MB)
테스트 30 〉	통과 (23.94ms, 53.9MB)
채점 결과
정확성: 50.0
효율성: 36.7
합계: 86.7 / 100.0
*/
import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return this.weight-e.weight;
        }
    }
    static PriorityQueue<Edge> pq;
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;
    static int[] nextDist;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n+1];
        pq = new PriorityQueue<>();
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < fares.length; i++){
            adj.get(fares[i][0]).add(new Edge(fares[i][1],fares[i][2]));
            adj.get(fares[i][1]).add(new Edge(fares[i][0],fares[i][2]));
        }
        dist[s] = 0;
        pq.add(new Edge(s,0));
        dijstra();
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            nextDist = new int[n+1];
            Arrays.fill(nextDist,Integer.MAX_VALUE);
            nextDist[i] = 0;
            pq.add(new Edge(i,0));
            nextDijstra();
            answer = Math.min(answer, dist[i]+nextDist[a]+nextDist[b]);
        }
        return answer;
    }

    public void dijstra(){
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(Edge next: adj.get(e.to)){
                if(dist[next.to] > dist[e.to]+next.weight){
                    dist[next.to] = dist[e.to]+next.weight;
                    pq.offer(next);
                }
            }
        }
    }
    public void nextDijstra(){
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(Edge next: adj.get(e.to)){
                if(nextDist[next.to] > nextDist[e.to]+next.weight){
                    nextDist[next.to] = nextDist[e.to]+next.weight;
                    pq.offer(next);
                }
            }
        }
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.07ms, 53.1MB)
테스트 2 〉	통과 (0.10ms, 52.4MB)
테스트 3 〉	통과 (0.07ms, 52.7MB)
테스트 4 〉	통과 (0.15ms, 51.9MB)
테스트 5 〉	통과 (0.23ms, 52.5MB)
테스트 6 〉	통과 (0.36ms, 52.6MB)
테스트 7 〉	통과 (0.24ms, 51.7MB)
테스트 8 〉	통과 (0.50ms, 52.6MB)
테스트 9 〉	통과 (0.58ms, 52.2MB)
테스트 10 〉	통과 (0.78ms, 53MB)
효율성  테스트
테스트 1 〉	통과 (15.62ms, 52.7MB)
테스트 2 〉	통과 (25.33ms, 55.1MB)
테스트 3 〉	통과 (27.88ms, 52.4MB)
테스트 4 〉	통과 (30.83ms, 52.8MB)
테스트 5 〉	통과 (21.76ms, 52.9MB)
테스트 6 〉	통과 (23.20ms, 52.3MB)
테스트 7 〉	통과 (50.56ms, 64.7MB)
테스트 8 〉	통과 (84.91ms, 67.3MB)
테스트 9 〉	통과 (29.11ms, 64.9MB)
테스트 10 〉	통과 (39.14ms, 64.5MB)
테스트 11 〉	통과 (49.28ms, 64.1MB)
테스트 12 〉	통과 (25.21ms, 58.1MB)
테스트 13 〉	통과 (47.21ms, 58MB)
테스트 14 〉	통과 (84.28ms, 62.8MB)
테스트 15 〉	통과 (37.85ms, 59.8MB)
테스트 16 〉	통과 (21.13ms, 53.3MB)
테스트 17 〉	통과 (28.89ms, 52.6MB)
테스트 18 〉	통과 (30.18ms, 52.8MB)
테스트 19 〉	통과 (28.06ms, 53.7MB)
테스트 20 〉	통과 (31.22ms, 53.6MB)
테스트 21 〉	통과 (29.71ms, 54.1MB)
테스트 22 〉	통과 (53.26ms, 59.6MB)
테스트 23 〉	통과 (23.71ms, 60.3MB)
테스트 24 〉	통과 (69.99ms, 62.1MB)
테스트 25 〉	통과 (20.61ms, 52.4MB)
테스트 26 〉	통과 (23.06ms, 53MB)
테스트 27 〉	통과 (21.39ms, 54.5MB)
테스트 28 〉	통과 (36.21ms, 57.4MB)
테스트 29 〉	통과 (15.58ms, 52.3MB)
테스트 30 〉	통과 (22.27ms, 52.7MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static int[][] edges;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        edges = new int[n+1][n+1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                edges[i][j] = 20000001;
            }
            edges[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++){
            edges[fares[i][0]][fares[i][1]] = fares[i][2];
            edges[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    edges[i][j] = Math.min(edges[i][k] + edges[k][j], edges[i][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer,edges[s][i] + edges[i][a]+edges[i][b]);
        }
        return answer;
    }
}
