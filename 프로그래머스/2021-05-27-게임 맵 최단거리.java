import java.util.*;
class Solution {
    static int[][] dist;
    static class Node{
        int r,c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        dist = new int[maps.length][maps[0].length];
        for(int[] distance: dist){
            Arrays.fill(distance, -1);
        }
        bfs(0,0,maps);
        return dist[maps.length-1][maps[0].length-1];
    }
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public void bfs(int r, int c, int[][] maps){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r,c));
        dist[r][c] = 1;

        while(!que.isEmpty()){
            Node n = que.poll();
            for(int d = 0; d < 4; d++){
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[nr].length)
                    continue;
                if(maps[nr][nc] == 0 || dist[nr][nc] != -1)
                    continue;
                dist[nr][nc] = dist[n.r][n.c] + 1;
                que.add(new Node(nr,nc));
            }
        }
        return;
    }
}
