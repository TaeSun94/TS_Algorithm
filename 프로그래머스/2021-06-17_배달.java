/*
정확성  테스트
테스트 1 〉	통과 (0.75ms, 52.5MB)
테스트 2 〉	통과 (0.69ms, 52.3MB)
테스트 3 〉	통과 (0.72ms, 52.7MB)
테스트 4 〉	통과 (0.86ms, 52.7MB)
테스트 5 〉	통과 (0.54ms, 53.1MB)
테스트 6 〉	통과 (0.79ms, 52.7MB)
테스트 7 〉	통과 (0.76ms, 52.3MB)
테스트 8 〉	통과 (0.70ms, 52.3MB)
테스트 9 〉	통과 (0.73ms, 52MB)
테스트 10 〉	통과 (0.78ms, 52.6MB)
테스트 11 〉	통과 (0.75ms, 52.4MB)
테스트 12 〉	통과 (0.82ms, 52.4MB)
테스트 13 〉	통과 (0.83ms, 52.4MB)
테스트 14 〉	통과 (4.40ms, 53.7MB)
테스트 15 〉	통과 (5.13ms, 54MB)
테스트 16 〉	통과 (0.86ms, 52.3MB)
테스트 17 〉	통과 (0.78ms, 52.7MB)
테스트 18 〉	통과 (2.06ms, 52.2MB)
테스트 19 〉	통과 (5.57ms, 53MB)
테스트 20 〉	통과 (1.74ms, 52.6MB)
테스트 21 〉	통과 (6.29ms, 53.8MB)
테스트 22 〉	통과 (2.15ms, 53MB)
테스트 23 〉	통과 (4.93ms, 52.9MB)
테스트 24 〉	통과 (5.64ms, 53.8MB)
테스트 25 〉	통과 (8.40ms, 54.9MB)
테스트 26 〉	통과 (9.99ms, 53.4MB)
테스트 27 〉	통과 (6.30ms, 53.5MB)
테스트 28 〉	통과 (9.11ms, 54.2MB)
테스트 29 〉	통과 (10.18ms, 53.4MB)
테스트 30 〉	통과 (5.57ms, 55.8MB)
테스트 31 〉	통과 (0.76ms, 52.1MB)
테스트 32 〉	통과 (1.28ms, 52.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/

import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    static PriorityQueue<Edge> pq;
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        pq = new PriorityQueue<>();
        adj = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0 ; i <= N ; ++i) adj.add(new ArrayList<>());

        for(int i = 0 ; i < road.length ; ++i){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }

        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        dijkstra();

        for(int distance : dist){
            if(distance <= K) answer++;
        }

        return answer;
    }

    private void dijkstra() {
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            for(Edge next : adj.get(e.to)){
                if(dist[next.to] > dist[e.to] + next.weight){
                    dist[next.to] = dist[e.to] + next.weight;
                    pq.offer(next);
                }
            }
        }
    }
}
