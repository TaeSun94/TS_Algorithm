import java.util.*;

class Solution {
    class Node {
        int r;
        int c;
        int cnt;
        boolean flag;
        
        Node(int r, int c, int cnt, boolean flag) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
    
    int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};

    public int solution(String[] maps) {
        int answer = -1;
        char[][] map = new char[maps.length][maps[0].length()];
        Queue<Node> que = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    visited[i][j] = true;
                    que.add(new Node(i,j, 0, false));
                }
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        // BFS
        while(!que.isEmpty()) {
            Node node = que.poll();
            
            if (map[node.r][node.c] == 'E' && node.flag) {
                answer = node.cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] == 'X' || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                
                if (map[nr][nc] == 'L' && !node.flag) {
                    que = new LinkedList<>();
                    visited = new boolean[map.length][map[0].length];
                    visited[nr][nc] = true;
                    que.add(new Node(nr,nc, node.cnt + 1, true));
                    break;
                } else {
                    que.add(new Node(nr,nc, node.cnt + 1, node.flag));
                }
            }
        }
        
        
        return answer;
    }
}
