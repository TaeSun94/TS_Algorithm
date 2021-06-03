/*
      -10
0-1    00   01
       10
*/
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        //L,R,U,D
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 5;
        int y = 5;
        for(int i = 0; i < dirs.length(); i++){
            int d = direction(dirs.charAt(i));
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx > 10 || ny > 10 || nx < 0 || ny < 0)
                continue;
            if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y]){
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
    public int direction(char c){
        if(c == 'L'){
            return 0;
        }
        else if(c == 'R'){
            return 1;
        }
        else if(c == 'U'){
            return 2;
        }
        else
            return 3;
    }
}
