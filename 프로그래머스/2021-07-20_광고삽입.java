/*
First Try - 1:10
정확성  테스트
테스트 1 〉	실패 (61.89ms, 55.2MB)
테스트 2 〉	실패 (196.41ms, 63MB)
테스트 3 〉	실패 (449.10ms, 68.7MB)
테스트 4 〉	실패 (9163.66ms, 83.3MB)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	통과 (57.02ms, 54.4MB)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (시간 초과)
테스트 15 〉	실패 (30.65ms, 54MB)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	통과 (31.56ms, 54.6MB)
테스트 20 〉	실패 (19.34ms, 53.6MB)
테스트 21 〉	실패 (런타임 에러)
테스트 22 〉	통과 (0.02ms, 81.6MB)
테스트 23 〉	실패 (시간 초과)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (15.47ms, 52.6MB)
테스트 26 〉	실패 (15.27ms, 53.6MB)
테스트 27 〉	실패 (14.90ms, 52.8MB)
테스트 28 〉	통과 (15.87ms, 54.2MB)
테스트 29 〉	실패 (19.45ms, 53.6MB)
테스트 30 〉	실패 (14.17ms, 52.8MB)
테스트 31 〉	실패 (14.30ms, 52.5MB)
채점 결과
정확성: 12.9
합계: 12.9 / 100.0
*/
import java.util.*;
class Solution {
    static class Adv implements Comparable<Adv>{
        long start,end;
        Adv(long start, long end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Adv adv){
            return this.end > adv.end ? 1:-1;
        }
    }
    static long totalTime, advTime;
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        if(play_time.equals(adv_time)){
            return "00:00:00";
        }
        totalTime = convertTimetoInteger(play_time);
        advTime = convertTimetoInteger(adv_time);
        PriorityQueue<Adv> pq = new PriorityQueue<>();
        ArrayList<Adv> list = new ArrayList<>();
        for(String log: logs){
            String[] split = log.split("-");
            long start = convertTimetoInteger(split[0]);
            long end = convertTimetoInteger(split[1]);
            list.add(new Adv(start,end));
        }
        Collections.sort(list, new Comparator<Adv>(){
           public int compare(Adv adv1, Adv adv2){
               return adv1.start > adv2.start ? 1 : -1;
           }
        });
        int max = 0;
        long start = 0;
        for(int i = 0; i < list.size(); i++){
            Adv adv = list.get(i);
            int cnt = 0;
            for(int j = 0; j< list.size(); j++){
                if(adv.start+advTime < list.get(j).start){
                    break;
                }
                if(adv.start > list.get(j).end)
                    continue;
                cnt++;
            }
            if(max < cnt){
                max = cnt;
                start = adv.start;
            }
        }
        long hour = start/(60*60);
        if(hour < 10)
            answer += "0"+hour+":";
        else
            answer += hour+":";
        start %= 3600;
        if(start/60 < 10)
            answer += "0"+start/60+":";
        else
            answer+=start/60+":";
        if(start%60< 10)
            answer += "0"+start%60;
        else
            answer += start%60;
        return answer;
    }
    public long convertTimetoInteger(String time){
        String[] split = time.split(":");
        return Long.parseLong(split[0])*60*60+Long.parseLong(split[1])*60+Long.parseLong(split[2]);
    }
}
/*
Second Try -> change mem[i+advTime-1];
정확성  테스트
테스트 1 〉	통과 (22.88ms, 55.3MB)
테스트 2 〉	통과 (48.62ms, 59MB)
테스트 3 〉	통과 (55.22ms, 66.1MB)
테스트 4 〉	통과 (124.52ms, 84.7MB)
테스트 5 〉	통과 (232.64ms, 92.8MB)
테스트 6 〉	통과 (42.56ms, 55.4MB)
테스트 7 〉	통과 (306.56ms, 182MB)
테스트 8 〉	통과 (292.85ms, 184MB)
테스트 9 〉	통과 (351.72ms, 298MB)
테스트 10 〉	통과 (390.76ms, 299MB)
테스트 11 〉	통과 (390.68ms, 299MB)
테스트 12 〉	통과 (377.41ms, 299MB)
테스트 13 〉	통과 (415.00ms, 297MB)
테스트 14 〉	통과 (364.34ms, 298MB)
테스트 15 〉	통과 (29.85ms, 54MB)
테스트 16 〉	통과 (305.71ms, 248MB)
테스트 17 〉	실패 (397.55ms, 298MB)
테스트 18 〉	통과 (345.01ms, 263MB)
테스트 19 〉	통과 (25.77ms, 54.4MB)
테스트 20 〉	통과 (17.25ms, 53MB)
테스트 21 〉	통과 (228.09ms, 93.4MB)
테스트 22 〉	통과 (0.02ms, 84.4MB)
테스트 23 〉	통과 (369.09ms, 297MB)
테스트 24 〉	통과 (341.18ms, 298MB)
테스트 25 〉	통과 (23.96ms, 55.8MB)
테스트 26 〉	통과 (19.99ms, 54.1MB)
테스트 27 〉	통과 (21.79ms, 54.3MB)
테스트 28 〉	실패 (21.42ms, 53.4MB)
테스트 29 〉	통과 (19.98ms, 53.8MB)
테스트 30 〉	통과 (19.43ms, 54MB)
테스트 31 〉	통과 (33.23ms, 54.3MB)
채점 결과
정확성: 93.5
합계: 93.5 / 100.0
*/
import java.util.*;
class Solution {
    static int totalTime, advTime;
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        if(play_time.equals(adv_time)){
            return "00:00:00";
        }
        totalTime = convertTimetoInteger(play_time);
        advTime = convertTimetoInteger(adv_time);
        int[] mem = new int[totalTime+1];
        for(int i = 0; i < logs.length; i++){
            String[] split = logs[i].split("-");
            int start = convertTimetoInteger(split[0]);
            int end = convertTimetoInteger(split[1]);
            mem[start]++;
            mem[end]--;
        }
        for(int i = 1; i < mem.length; i++){
            mem[i] += mem[i-1];
        }
        int sum = 0;
        for(int i = 0; i < advTime; i++){
            sum+=mem[i];
        }
        int max = sum;
        int maxPos = 0;
        for(int i = 1; i < totalTime-advTime; i++){
            sum -= mem[i-1];
            sum += mem[i+advTime-1];
            if(max < sum){
                max = sum;
                maxPos = i;
            }
        }

//         System.out.println(maxPos);
//         System.out.println(convertTimetoInteger("01:30:59"));
        int hour = maxPos/(60*60);
        if(hour < 10)
            answer += "0"+hour+":";
        else
            answer += hour+":";
        maxPos %= 3600;
        if(maxPos/60 < 10)
            answer += "0"+maxPos/60+":";
        else
            answer+=maxPos/60+":";
        if(maxPos%60< 10)
            answer += "0"+maxPos%60;
        else
            answer += maxPos%60;
        return answer;
    }
    public int convertTimetoInteger(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60*60+Integer.parseInt(split[1])*60+Integer.parseInt(split[2]);
    }
}

/*
Third Try -> 누적합의 자료형을 long으로 바꿈(17번 테스트케이스), 누적합 부분의 최대 인덱스를 totalTime - advTime까지 확인하도록 설정
정확성  테스트
테스트 1 〉	통과 (28.98ms, 54.1MB)
테스트 2 〉	통과 (45.83ms, 59.1MB)
테스트 3 〉	통과 (41.37ms, 65.3MB)
테스트 4 〉	통과 (155.15ms, 84.2MB)
테스트 5 〉	통과 (199.95ms, 91.3MB)
테스트 6 〉	통과 (55.39ms, 55.5MB)
테스트 7 〉	통과 (289.26ms, 180MB)
테스트 8 〉	통과 (268.97ms, 177MB)
테스트 9 〉	통과 (357.21ms, 298MB)
테스트 10 〉	통과 (360.25ms, 263MB)
테스트 11 〉	통과 (371.32ms, 267MB)
테스트 12 〉	통과 (349.22ms, 264MB)
테스트 13 〉	통과 (394.60ms, 298MB)
테스트 14 〉	통과 (355.77ms, 297MB)
테스트 15 〉	통과 (27.51ms, 53.7MB)
테스트 16 〉	통과 (335.96ms, 296MB)
테스트 17 〉	통과 (383.59ms, 260MB)
테스트 18 〉	통과 (378.52ms, 296MB)
테스트 19 〉	통과 (17.78ms, 54.2MB)
테스트 20 〉	통과 (17.21ms, 53.3MB)
테스트 21 〉	통과 (211.22ms, 91.6MB)
테스트 22 〉	통과 (0.04ms, 85.4MB)
테스트 23 〉	통과 (399.83ms, 298MB)
테스트 24 〉	통과 (348.48ms, 296MB)
테스트 25 〉	통과 (39.56ms, 54.3MB)
테스트 26 〉	통과 (21.27ms, 53.3MB)
테스트 27 〉	통과 (25.10ms, 53.9MB)
테스트 28 〉	통과 (34.00ms, 53.9MB)
테스트 29 〉	통과 (21.93ms, 54.2MB)
테스트 30 〉	통과 (24.33ms, 53.3MB)
테스트 31 〉	통과 (54.53ms, 53.6MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static int totalTime, advTime;
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        if(play_time.equals(adv_time)){
            return "00:00:00";
        }
        totalTime = convertTimetoInteger(play_time);
        advTime = convertTimetoInteger(adv_time);
        int[] mem = new int[totalTime+1];
        for(int i = 0; i < logs.length; i++){
            String[] split = logs[i].split("-");
            int start = convertTimetoInteger(split[0]);
            int end = convertTimetoInteger(split[1]);
            mem[start]++;
            mem[end]--;
        }
        for(int i = 1; i < mem.length; i++){
            mem[i] += mem[i-1];
        }
        long sum = 0;
        for(int i = 0; i < advTime; i++){
            sum+=mem[i];
        }
        long max = sum;
        int maxPos = 0;
        for(int i = 1; i < totalTime-advTime+1; i++){
            sum -= mem[i-1];
            sum += mem[i+advTime-1];
            if(max < sum){
                max = sum;
                maxPos = i;
            }
        }

//         System.out.println(maxPos);
//         System.out.println(convertTimetoInteger("01:30:59"));
        int hour = maxPos/(60*60);
        if(hour < 10)
            answer += "0"+hour+":";
        else
            answer += hour+":";
        maxPos %= 3600;
        if(maxPos/60 < 10)
            answer += "0"+maxPos/60+":";
        else
            answer+=maxPos/60+":";
        if(maxPos%60< 10)
            answer += "0"+maxPos%60;
        else
            answer += maxPos%60;
        return answer;
    }
    public int convertTimetoInteger(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60*60+Integer.parseInt(split[1])*60+Integer.parseInt(split[2]);
    }
}
