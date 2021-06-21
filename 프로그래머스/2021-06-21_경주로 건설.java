/*
정확성  테스트
테스트 1 〉	통과 (0.30ms, 52.6MB)
테스트 2 〉	통과 (0.30ms, 52MB)
테스트 3 〉	통과 (0.26ms, 52.3MB)
테스트 4 〉	통과 (0.31ms, 52.6MB)
테스트 5 〉	통과 (0.27ms, 52.7MB)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	통과 (3.63ms, 53.2MB)
테스트 14 〉	통과 (64.95ms, 69.9MB)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	통과 (3.92ms, 54MB)
테스트 21 〉	통과 (4.84ms, 52.6MB)
테스트 22 〉	통과 (0.46ms, 51.7MB)
테스트 23 〉	통과 (0.35ms, 52.1MB)
테스트 24 〉	통과 (0.32ms, 51.9MB)
채점 결과
정확성: 50.0
합계: 50.0 / 100.0
*/
import java.util.*;
class Solution {
    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};
    static class Car{
        int direction, r, c, cost;
        Car(int direction, int r, int c, int cost){
            this.direction = direction;
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    static boolean[][] visited;
    static int min;
    public int solution(int[][] board) {

        min = Integer.MAX_VALUE;
        for(int d = 0; d < 4; d++){
            int nr = 0 + dr[d];
            int nc = 0 + dc[d];
            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[nr].length){
                continue;
            }
            visited = new boolean[board.length][board[0].length];
            dfs(new Car(d,0,0,0), board);
        }
        int answer = min;
        return answer;
    }
    public void dfs(Car c, int[][] board){
        if(c.r == board.length -1 && c.c == board[0].length-1){
            min = Math.min(min,c.cost);
            return;
        }
        for(int d = 0; d < 4; d++){
            if(c.direction != d && d%2 == c.direction%2)
                continue;
            int nr = c.r + dr[d];
            int nc = c.c + dc[d];

            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[nr].length)
                continue;
            if(board[nr][nc] == 1 || visited[nr][nc])
                continue;
            int cost = c.cost + 100;
            if(c.direction%2 != d%2)
                cost += 500;
            visited[nr][nc] = true;
            dfs(new Car(d,nr,nc,cost),board);
            visited[nr][nc] = false;
        }
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.42ms, 52.4MB)
테스트 2 〉	통과 (0.42ms, 52.9MB)
테스트 3 〉	통과 (0.48ms, 52.8MB)
테스트 4 〉	통과 (0.37ms, 53.1MB)
테스트 5 〉	통과 (0.46ms, 52MB)
테스트 6 〉	통과 (1.24ms, 52.8MB)
테스트 7 〉	통과 (1.11ms, 53.1MB)
테스트 8 〉	통과 (1.34ms, 52.2MB)
테스트 9 〉	통과 (0.85ms, 52MB)
테스트 10 〉	통과 (1.23ms, 52.4MB)
테스트 11 〉	통과 (26.65ms, 56MB)
테스트 12 〉	통과 (2.77ms, 52.1MB)
테스트 13 〉	통과 (0.77ms, 53.1MB)
테스트 14 〉	통과 (0.74ms, 52.9MB)
테스트 15 〉	통과 (1.70ms, 52.2MB)
테스트 16 〉	통과 (3.76ms, 52.8MB)
테스트 17 〉	통과 (4.92ms, 53.4MB)
테스트 18 〉	통과 (8.27ms, 52.3MB)
테스트 19 〉	통과 (17.56ms, 54.2MB)
테스트 20 〉	통과 (1.09ms, 53.2MB)
테스트 21 〉	통과 (1.02ms, 52.5MB)
테스트 22 〉	통과 (0.49ms, 51.8MB)
테스트 23 〉	통과 (0.40ms, 52.5MB)
테스트 24 〉	통과 (0.56ms, 52.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int min;
    static class Car{
        int r, c, d, cost;
        Car(int r, int c, int d, int cost){
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
    static int[][] dist;
    public int solution(int[][] board) {
        dist = new int[board.length][board[0].length];
        min = Integer.MAX_VALUE;
        bfs(0,0,board);
        int answer = min;
        return answer;
    }
    public void bfs(int r, int c, int[][] board){
        Queue<Car> que = new LinkedList<>();

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr>=board.length || nc >= board[nr].length)
                continue;
            que.add(new Car(r,c,d,0));
        }
        while(!que.isEmpty()){
            Car car = que.poll();
            if(car.r == board.length-1 && car.c == board[0].length-1){
                min = Math.min(car.cost,min);
                continue;
            }
            for(int d = 0; d < 4; d++){
                int nr = car.r + dr[d];
                int nc = car.c + dc[d];
                if(nr < 0 || nc < 0 || nr>=board.length || nc >= board[nr].length || board[nr][nc] == 1)
                    continue;
                int nCost = 0;
                if(d == car.d){
                    nCost = car.cost + 100;
                }
                else if( car.d%2 != d%2){
                    nCost = car.cost + 600;
                }
                else
                    continue;
                if(dist[nr][nc] == 0){
                    dist[nr][nc] = nCost;
                    que.add(new Car(nr,nc,d,nCost));
                }
                else if(dist[nr][nc] >= nCost){
                    dist[nr][nc] = nCost;
                    que.add(new Car(nr,nc,d,nCost));
                }
            }

        }
    }
}
