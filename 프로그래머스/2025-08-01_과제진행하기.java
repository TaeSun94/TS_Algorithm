import java.util.*;

class Solution {
    class Work{
        int startTime;
        int remain;
        String str;
        
        Work(int startTime, int remain, String str) {
            this.startTime = startTime;
            this.remain = remain;
            this.str = str;
        }
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Work> remainWorks = new Stack<>();
        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.startTime - o2.startTime;
            }
        });
        
        for (int i = 0; i < plans.length; i++) {
            pq.add(new Work(convertTime(plans[i][1]), Integer.parseInt(plans[i][2]), plans[i][0]));
        }
        
        int idx = 0;
        Work work = pq.poll();
        int now = work.startTime;
        while(!pq.isEmpty()) {
            Work diffWork = pq.peek();
            if (diffWork.startTime < now + work.remain) {
                int remain = work.remain + now - diffWork.startTime;
                remainWorks.push(new Work(diffWork.startTime, remain, work.str));
                work = pq.poll();
                now = work.startTime;
            } else if (diffWork.startTime == now + work.remain) {
                answer[idx++] = work.str;
                work = pq.poll();
                now = work.startTime;
            } else {
                answer[idx++] = work.str;
                if (!remainWorks.isEmpty()) {
                    now += work.remain;
                    work = remainWorks.pop();
                } else {
                    work = pq.poll();
                    now = work.startTime;
                }
            }   
        }
        answer[idx++] = work.str;
        while(!remainWorks.isEmpty()) {
            Work rWork = remainWorks.pop();
            answer[idx++] = rWork.str;
        }
        return answer;
    }
    
    public int convertTime(String time) {
        String[] splits = time.split(":");
        
        return Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
    }
}
