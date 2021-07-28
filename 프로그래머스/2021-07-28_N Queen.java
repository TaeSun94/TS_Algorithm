/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 51.7MB)
테스트 2 〉	통과 (0.03ms, 52.2MB)
테스트 3 〉	통과 (0.04ms, 54.1MB)
테스트 4 〉	통과 (0.20ms, 52.5MB)
테스트 5 〉	통과 (0.75ms, 52.3MB)
테스트 6 〉	통과 (1.37ms, 52.7MB)
테스트 7 〉	통과 (6.76ms, 52.1MB)
테스트 8 〉	통과 (10.50ms, 52.1MB)
테스트 9 〉	통과 (34.32ms, 52.9MB)
테스트 10 〉	통과 (105.95ms, 52.9MB)
테스트 11 〉	통과 (563.05ms, 52.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
class Solution {
    static int count;
    static boolean[][] map;
    public int solution(int n) {
        map = new boolean[n][n];
        NQueen(0);
        int answer = count;
        return answer;
    }
    private static void NQueen(int idx) {
        if(idx == map.length) {
            count++;
            return;
        }
        for(int i = 0; i < map[idx].length; i++) {
            if(Possible(idx,i)) {
                map[idx][i] = true;
                NQueen(idx+1);
                map[idx][i] = false;
            }
        }
    }
    static int[] dr = {-1, -1, -1};
    static int[] dc = {-1, 0, 1};
    private static boolean Possible(int row, int col) {
        boolean check = false;
        for(int d = 0; d < 3; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            while(true) {
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length)
                    break;
                if(map[nr][nc]) {
                    check = true;
                    break;
                }
                nr += dr[d];
                nc += dc[d];
            }
        }
        if(!check)
            return true;
        return false;
    }
}
