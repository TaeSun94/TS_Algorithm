class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
                int max = 0;
                for(int k = 0; k < land[i].length; k++){
                    if(k != j){
                        max = Math.max(max, land[i-1][k]);
                    }
                }
                land[i][j] += max;
            }
        }
        for(int i = 0; i < 4; i++){
            if(answer < land[land.length-1][i])
                answer = land[land.length-1][i];
        }
        return answer;
    }
}
