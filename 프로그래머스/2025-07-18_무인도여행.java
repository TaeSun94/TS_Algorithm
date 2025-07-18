import java.util.*;

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    boolean[][] visited;
    int[][] map;
    int sum;
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.parseInt(maps[i].charAt(j)+"");
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] < 0 || visited[i][j])
                    continue;
                
                sum = 0;
                dfs(i,j);
                if (sum > 0) {
                    al.add(sum);
                }
            }
        }
        
        if (al.size() == 0) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[al.size()];
            // al.sort();
            Collections.sort(al);
            
            for (int i = 0; i < al.size(); i++) {
                answer[i] = al.get(i);
            }
            
            return answer;   
        }
    }
    
    public void dfs(int r, int c) {
        visited[r][c] = true;
        sum += map[r][c];
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc] || map[nr][nc] < 0) {
                continue;
            }
            dfs(nr,nc);
        }
    }
}
