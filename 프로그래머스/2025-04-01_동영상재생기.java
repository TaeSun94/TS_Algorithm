class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = pos;
        for (int i = 0; i < commands.length; i++) {
            answer = checkOpeningTime(answer, op_start, op_end);
            answer = operation(answer, video_len, commands[i]);
        }

        answer = checkOpeningTime(answer, op_start, op_end);
        return answer;
    }
    
    public String checkOpeningTime(String pos, String start, String end) {
        String[] posSplit = pos.split(":");
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");
        int posData = Integer.parseInt(posSplit[0])*100 + Integer.parseInt(posSplit[1]);
        int startData = Integer.parseInt(startSplit[0])*100 + Integer.parseInt(startSplit[1]);
        int endData = Integer.parseInt(endSplit[0])*100 + Integer.parseInt(endSplit[1]);

        if(posData >= startData && posData < endData) {
            return end;
        } else {
            return pos;
        }
    }
    
    public String operation(String answer, String video_end, String commands) {
        switch (commands) {
            case "prev":
                return operateCommand(answer, video_end, false);
            case "next": 
                return operateCommand(answer, video_end, true);
            default:
                return "";
        }
    }
    
    public String operateCommand(String pos, String end, boolean comm) {
        boolean min = false;
        String[] splitData = pos.split(":");
        int mm = Integer.parseInt(splitData[0]);
        int ss = Integer.parseInt(splitData[1]);
        ss = comm ? ss + 10 : ss - 10;
        
        if( ss < 0) {
            if (mm == 0) {
                return convertDataToString(0,0);
            }
            return convertDataToString(mm -1, ss+60);
        }
        if(ss >= 60) {
            mm += 1;
            ss -= 60;
        }

        String[] endSplitData = end.split(":");
        int endMM = Integer.parseInt(endSplitData[0]);
        int endSS = Integer.parseInt(endSplitData[1]);
        if(mm*100 + ss > endMM * 100 + endSS) {
            return convertDataToString(endMM, endSS);
        }
        
        return convertDataToString(mm, ss);
    }
    
    public String convertDataToString(int mm, int ss) {
        String res = "";

        if(ss >= 60) {
            mm += 1;
            ss -= 60;
        }
        
        if (mm < 10) {
            res += "0";
        }
        res += mm + ":";

        if(ss < 10) {
            res += "0";
        }
        res += ss;
        
        return res;
    }
}
