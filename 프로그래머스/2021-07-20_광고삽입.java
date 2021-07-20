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
