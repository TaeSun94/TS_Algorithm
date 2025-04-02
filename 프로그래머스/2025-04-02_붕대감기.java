class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int pos = 0;
        
        for(int i = 0; i < attacks.length; i++) {
            int remains = attacks[i][0] - pos - 1;
            answer += bandage[1]*remains + bandage[2]*(remains/bandage[0]);

            if(answer > health) {
                answer = health;
            }

            answer -= attacks[i][1];
            
            if(answer <= 0) {
                answer = -1;
                break;
            }
            pos = attacks[i][0];
        }
        
        return answer;
    }
}
