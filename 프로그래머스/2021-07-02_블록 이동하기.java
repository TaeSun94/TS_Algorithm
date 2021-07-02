import java.util.*;
class Solution {
    static int answer;
    static boolean[][] visited;
    static class Robot{
        int leftR,leftC,rightR,rightC, timer;
        Robot(int leftR, int leftC, int rightR, int rightC, int timer){
            this.leftR = leftR;
            this.leftC = leftC;
            this.rightR = rightR;
            this.rightC = rightC;
            this.timer = timer;
        }
    }
    public int solution(int[][] board) {
        visited = new boolean[board.length][board[0].length];
        bfs(new Robot(0,0,0,1,0));
        answer = 0;
        return answer;
    }
    public void bfs(Robot robot){
        Queue<Robot> que = new LinkedList<>();
        visited[robot.leftR][robot.leftC] = true;
        visited[robot.rightR][robot.rightC] = true;

        que.add(robot);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                Robot moveRobot = que.poll();

                //종료 조건
                if((moveRobot.leftR == visited.length && moveRobot.leftC == visited.length ) || (moveRobot.rightR == visited.length && moveRobot.rightC == visited.length ))
                    return;

                //4방향 이동

                //가로 회전

                //세로 회전
            }
        }
    }
}
