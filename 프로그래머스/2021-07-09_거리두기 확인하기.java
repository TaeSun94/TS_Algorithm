/*
정확성  테스트
테스트 1 〉	통과 (0.50ms, 53.1MB)
테스트 2 〉	통과 (0.42ms, 53.1MB)
테스트 3 〉	통과 (0.46ms, 52.4MB)
테스트 4 〉	통과 (0.48ms, 52.9MB)
테스트 5 〉	통과 (0.43ms, 52.3MB)
테스트 6 〉	통과 (0.45ms, 52.7MB)
테스트 7 〉	통과 (0.41ms, 53.1MB)
테스트 8 〉	통과 (0.45ms, 53.2MB)
테스트 9 〉	통과 (0.44ms, 52.9MB)
테스트 10 〉	통과 (0.47ms, 54.3MB)
테스트 11 〉	통과 (0.30ms, 51.9MB)
테스트 12 〉	통과 (0.46ms, 53.1MB)
테스트 13 〉	통과 (0.49ms, 52.5MB)
테스트 14 〉	통과 (0.41ms, 52.2MB)
테스트 15 〉	통과 (0.46ms, 52.7MB)
테스트 16 〉	통과 (0.30ms, 51.9MB)
테스트 17 〉	통과 (0.41ms, 52.4MB)
테스트 18 〉	통과 (0.42ms, 51.8MB)
테스트 19 〉	통과 (0.42ms, 52.8MB)
테스트 20 〉	통과 (0.45ms, 51.8MB)
테스트 21 〉	통과 (0.39ms, 53.1MB)
테스트 22 〉	통과 (0.75ms, 52.8MB)
테스트 23 〉	통과 (0.12ms, 52.3MB)
테스트 24 〉	통과 (0.45ms, 52.6MB)
테스트 25 〉	통과 (0.09ms, 51.9MB)
테스트 26 〉	통과 (0.15ms, 52.3MB)
테스트 27 〉	통과 (0.29ms, 51.8MB)
테스트 28 〉	통과 (0.35ms, 53MB)
테스트 29 〉	통과 (0.42ms, 52.2MB)
테스트 30 〉	통과 (0.38ms, 52.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Person{
        int row, col, distance;
        Person(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        //반복문을 실행하며 각 방이 잘 지켜지는지 확인
        for(int index = 0; index < places.length; index++){
            //방 구조 생성
            char[][] room = new char[5][5];
            Queue<Person> que = new LinkedList<>();
            for(int i = 0; i < places[index].length; i++){
                for(int j = 0; j < places[index][i].length(); j++){
                    room[i][j] = places[index][i].charAt(j);
                    if(room[i][j]=='P'){
                        que.add(new Person(i,j,0));
                    }
                }
            }
            //만약 올바른 곳이라면 정답값에 1
            if(!checkRoom(que, room))
                answer[index] = 0;
            //아니라면 0
            else
                answer[index] = 1;
        }
        return answer;
    }
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    public boolean checkRoom(Queue<Person> que, char[][] room){
        while(!que.isEmpty()){
            Person p1 = que.poll();
            boolean[][] visited = new boolean[5][5];
            visited[p1.row][p1.col] = true;
            Queue<Person> moveQue = new LinkedList<>();
            moveQue.add(new Person(p1.row,p1.col,p1.distance));
            while(!moveQue.isEmpty()){
                Person p = moveQue.poll();
                if(p.distance >= 2){
                    continue;
                }
                for(int d = 0; d < 4; d++){
                    int nr = p.row + dr[d];
                    int nc = p.col + dc[d];
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || room[nr][nc] == 'X' || visited[nr][nc])
                        continue;
                    if(room[nr][nc] == 'P')
                        return false;
                    visited[nr][nc] = true;
                    moveQue.add(new Person(nr,nc,p.distance+1));
                }
            }
        }
        return true;
    }
}
