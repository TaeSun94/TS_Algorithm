class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {
            boolean flag = true;

            for (int j = 0; j < timelogs[i].length; j++) {
                if(!flag) {
                    break;
                }

                flag = checkTime(schedules[i], timelogs[i][j], startday, j);
            }
            
            if(flag) {
                answer += 1;
            }
        }

        return answer;
    }
    
    public boolean checkTime(int time, int logTime, int startDay, int index) {
        int maxTime = (time + 10)%100 >= 60 ? time + 10 - 60 + 100 : time + 10;
        int dayIndex = (startDay + index) % 7 == 0 ? 7 : (startDay + index) % 7;
        
        if(dayIndex == 6 || dayIndex == 7) {
            return true;
        }
        
        return logTime <= maxTime;
    }
}
