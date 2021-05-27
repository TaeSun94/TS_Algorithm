class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] days = new int[12];
        days[0]= 31;
        days[1]= 29;
        days[2]= 31;
        days[3]= 30;
        days[4]= 31;
        days[5]= 30;
        days[6]= 31;
        days[7]= 31;
        days[8]= 30;
        days[9]= 31;
        days[10]= 30;
        days[11]= 31;
        int count = b;
        for(int i = 0; i < a-1; i++){
            count += days[i];
        }

        switch(count%7){
            case 0 :
                answer = "THU";
                break;
            case 1 :
                answer = "FRI";
                break;
            case 2 :
                answer = "SAT";
                break;
            case 3 :
                answer = "SUN";
                break;
            case 4 :
                answer = "MON";
                break;
            case 5 :
                answer = "TUE";
                break;
            case 6 :
                answer = "WED";
                break;
        }

        return answer;
    }
}
