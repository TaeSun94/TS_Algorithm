import java.util.*;

class Solution {
    class Node {
        int r;
        int c;
        int d;
        boolean attack; // true면 선공, false면 후공
        
        Node(int r, int c, int d, boolean attack) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.attack = attack;
        }
    }
    int winner = 0;
    int[] dr = {-1,-1,-1,0,0,1,1,1};
    int[] dc = {-1,0,1,-1,1,-1,0,1};
    boolean[][] visited;

    public int solution(String[] board) {
        char[][] map = new char[3][3];
        Queue<Node> preQueue = new LinkedList<>();
        Queue<Node> postQueue = new LinkedList<>();
        int preCnt = 0;
        int postCnt = 0;
        
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    if (preQueue.isEmpty()) {
                        for (int d = 0; d < dr.length; d++) {
                            preQueue.add(new Node(i, j, d, true));
                        }
                    } else {
                        if ( i == 0) {
                            for (int d = 0; d < dr.length; d++) {
                                preQueue.add(new Node(i, j, d, true));
                            }
                        }
                    }
                    preCnt++;
                } else if (board[i].charAt(j) == 'X') {
                    if (postQueue.isEmpty()) {
                        for (int d = 0; d < dr.length; d++) {
                            postQueue.add(new Node(i, j, d, false));
                        }
                    } else {
                        if ( i == 0) {
                            for (int d = 0; d < dr.length; d++) {
                                postQueue.add(new Node(i, j, d, false));
                            }
                        }
                    }
                    postCnt++;
                }
                map[i][j] = board[i].charAt(j);
            }
        }
        
        // 이겼는데 계속 진행하는지 확인
        // 2가지 경우의 수
        // 1. 두개의 Count가 같을 때, O가 이겼다면 0 아니면 1
        // 2. 선공이 클때, X가 이겼다면 0 아니면 1
        // 방향을 넣어서 수정하면 SAP 가능,, ㅎㅎ,,,
        if (preCnt == postCnt) {
            if (preCnt == 0) {
                return 1;
            }
            while(!preQueue.isEmpty()) {
                Node preAttacker = preQueue.poll();
                visited = new boolean[3][3];
                visited[preAttacker.r][preAttacker.c] = true;
                dfs(preAttacker.r, preAttacker.c, preAttacker.attack, map, 1, preAttacker.d);   
            }
            if (winner == 1) {
                return 0;
            }
            return 1;
        } else if(preCnt == postCnt + 1) {
            if (postCnt == 0) {
                return 1;
            }

            while(!postQueue.isEmpty()) {
                Node postAttacker = postQueue.poll();
                visited = new boolean[3][3];
                visited[postAttacker.r][postAttacker.c] = true;
                dfs(postAttacker.r, postAttacker.c, postAttacker.attack, map, 1, postAttacker.d);   
            }
            if (winner == 2) {
                return 0;
            }
            return 1;
        } else {
            return 0;
        }
    }
    
    public void dfs(int r, int c, boolean attack, char[][] map, int cnt, int d){
        if (cnt == 3) {
            winner = attack ? 1 : 2;
            return;
        }
        // for (int d = 0; d < dr.length; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];
            
        if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3 || visited[nr][nc] || map[nr][nc] == '.' || winner != 0) {
                return;
        }
        if (attack) {
            if (map[nr][nc] != 'O') {
                return;
            }
            visited[nr][nc] = true;
            dfs(nr,nc,attack,map, cnt+1, d);
        } else {
            if (map[nr][nc] != 'X') {
                return;
            }
            visited[nr][nc] = true;
            dfs(nr,nc,attack,map, cnt+1, d);
        }
    }
}
