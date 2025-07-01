import java.util.*;

/*
    열을 기준으로 내려오는 석유관에 따라서 가져올 수 있는 총 데이터를 확인하여 총 Answer를 리턴하는 방법
    1. 지역별 지도에 Mapping
    2. Mapping 번호에 따라 가져올 수 있는 크기를 정하기
*/
class Solution {
    class Node {
        int r;
        int c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static boolean[][] visited;

    public int solution(int[][] land) {
        int answer = 0;
        int rLen = land.length;
        int cLen = land[0].length;
        
        // 필요한 데이터 Init
        // visited: 이미 지나간 부분인지 확인하기 위한 Boolean 2차원 배열
        visited = new boolean[rLen][cLen];
        // hashmap을 통해 해당 지역을 지나갈 때 뽑아낼 수 있는 석유의 양을 표현
        HashMap<Integer, Integer> hm = new HashMap<>();
        // 석유가 없는 지역이 들어올 경우 0으로 리턴하도록 초기값 설정
        hm.put(0,0);
        // 지역을 나누기 위한 인덱싱
        int dom = 2;
        
        
        // 반복문을 통해 Land의 데이터를 변경해야함
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                // 아직 지역으로 나눠지지 않은 지역이면서 방문하지 않은 곳이 발견될 경우에 완전 탐색을 통해 캘 수 있는 총량을 확인하기 위한 탐색
                if (land[i][j] == 1 && !visited[i][j]){
                    int counts = bfs(i, j, land, dom);
                    hm.put(dom++, counts);
                }
            }
        }
        
        for(int j = 0; j < land[0].length; j++) {
            // 중복되는 데이터를 지우면서 열을 따라 행을 검사하기 위한 자료구조 사용
            Set<Integer> sets = new HashSet<>();
            for (int i = 0; i < land.length; i++) {
                sets.add(land[i][j]);
            }
            int sum = 0;
            
            for (int s: sets) {
                sum += hm.get(s);
            }
            // 정답 찾기
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    // 상,하,좌,우의 방향을 가져오기 위해 필요한 데이터
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    // 너비 우선 탐색
    public int bfs(int r, int c, int[][] land, int dom) {
        int counts = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r,c));
        land[r][c] = dom;
        visited[r][c] = true;
        
        while(!que.isEmpty()) {
            Node node = que.poll();
            
            for (int i = 0; i < dr.length; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= land.length || nc >= land[0].length || visited[nr][nc] || land[nr][nc] != 1) {
                    continue;
                }
                counts++;
                visited[nr][nc] = true;
                land[nr][nc] = dom;
                que.add(new Node(nr, nc));
            }
        }
        
        return counts;
    }
}
