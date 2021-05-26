class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = idx++;
            }
        }
        for(int i = 0; i < queries.length; i++){

            int s_r = queries[i][0]-1;
            int s_c = queries[i][1]-1;
            int e_r = queries[i][2]-1;
            int e_c = queries[i][3]-1;

            int tmp = map[s_r][s_c];
            int min = Math.min(Integer.MAX_VALUE,tmp);

            for(int j = s_r; j < e_r; j++){
                map[j][s_c] = map[j+1][s_c];
                min = Math.min(map[j][s_c],min);
            }
            for(int j = s_c; j < e_c; j++){
                map[e_r][j] = map[e_r][j+1];
                min = Math.min(map[e_r][j],min);
            }
            for(int j = e_r; j > s_r; j--){
                map[j][e_c] = map[j-1][e_c];
                min = Math.min(map[j][e_c],min);
            }
            for(int j = e_c; j > s_c; j--){
                map[s_r][j] = map[s_r][j-1];
                min = Math.min(map[s_r][j],min);
            }

            map[s_r][s_c+1] = tmp;

            answer[i] = min;
        }
        return answer;
    }
}
