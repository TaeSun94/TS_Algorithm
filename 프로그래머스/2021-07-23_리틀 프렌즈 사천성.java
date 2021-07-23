/*
정확성  테스트
테스트 1 〉	실패 (16.45ms, 56.6MB)
채점 결과
정확성: 0.0
합계: 0.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Tile implements Comparable<Tile>{
        int r, c, dir, dir_cnt,e_r,e_c;
        char data;
        Tile(int r, int c, int dir, int dir_cnt, char data){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.dir_cnt = dir_cnt;
            this.data = data;
        }
        public int compareTo(Tile t){
            return this.data-t.data;
        }
        public String toString(){
            return this.data+" ("+this.r+","+this.c+")"+" ("+this.e_r+","+this.e_c+")  "+this.dir_cnt;
        }
    }
    static HashSet<Character> set;
    static ArrayList<Character> ans;
    static char[][] map;
    public void InitMap(String[] board,int m, int n){
        map = new char[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]>= 'A'&& map[i][j] <= 'Z')
                    set.add(map[i][j]);
            }
        }
        return;
    }
    static PriorityQueue<Tile> pq;
    public String solution(int m, int n, String[] board) {
        String answer = "";
        set = new HashSet<>();
        InitMap(board,m,n);
        boolean flag = false;
        pq = new PriorityQueue<>();
        while(true){
            pq.clear();
            boolean[] check = new boolean[30];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] >='A' && map[i][j] <= 'Z' && !check[map[i][j]-'A']){
                        check[map[i][j]-'A'] = true;
                        if(bfs(new Tile(i,j,0,0,map[i][j]))){
                            flag = true;
                        }
                    }
                }
            }
            if(!flag)
                break;
            if(pq.isEmpty())
                break;

            Tile t = pq.poll();
            answer += t.data;
            map[t.r][t.c] = '.';
            map[t.e_r][t.e_c] = '.';
            set.remove(t.data);
        }

        if(set.size()>0){
            return "IMPOSSIBLE";
        }
        return answer;
    }
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public boolean bfs(Tile tile){
        int s_r = tile.r;
        int s_c = tile.c;
        Queue<Tile> que = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        que.add(new Tile(tile.r,tile.c,-1,-1,tile.data));
        visited[tile.r][tile.c] = true;
        while(!que.isEmpty()){
            Tile t = que.poll();
            if(t.dir_cnt > 1){
                continue;
            }
            for(int d = 0; d < 4; d++){
                int nr = t.r + dr[d];
                int nc = t.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc]=='*'|| visited[nr][nc])
                    continue;

                if(map[nr][nc] == '.' || map[nr][nc] == t.data){
                    visited[nr][nc] = true;
                    if(t.dir == d){
                        que.add(new Tile(nr,nc,d,t.dir_cnt,t.data));
                    }
                    else{
                        que.add(new Tile(nr,nc,d,t.dir_cnt+1,t.data));
                    }
                    if(map[nr][nc]==t.data){
                        Tile nTile = new Tile(s_r, s_c, 0,0,t.data);
                        nTile.e_r = nr;
                        nTile.e_c = nc;
                        pq.add(nTile);
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
