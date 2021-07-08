/*
정확성  테스트
테스트 1 〉	통과 (162.88ms, 73.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] mem = new int[m+1][n+1][2];
        mem[1][1][0] = 1;
        mem[1][1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(cityMap[i-1][j-1] == 0){
                    mem[i][j][0] += (mem[i-1][j][0] + mem[i][j-1][1])%MOD;
                    mem[i][j][1] += (mem[i-1][j][0] + mem[i][j-1][1])%MOD;
                }
                else if(cityMap[i-1][j-1] == 1){
                    mem[i][j][0] = 0;
                    mem[i][j][1] = 0;
                }
                else{
                    mem[i][j][0] = mem[i-1][j][0];
                    mem[i][j][1] = mem[i][j-1][1];
                }
            }
        }

        return mem[m][n][0];
    }
}
