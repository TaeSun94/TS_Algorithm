import java.util.*;

class Solution {
    class Booking{
        int start;
        int end;
        
        Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    class BookingComparator implements Comparator<Booking> {
        @Override
        public int compare(Booking o1, Booking o2) {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            } else {
                return o1.start - o2.start;
            }
        }
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Booking> pq = new PriorityQueue<>(1, new BookingComparator());
        
        for (int i = 0; i < book_time.length; i++) {
            pq.add(new Booking(convertTime(book_time[i][0]), convertTime(book_time[i][1]) + 10));
        }
        
        PriorityQueue<Integer> room = new PriorityQueue<>();
        
        while(!pq.isEmpty()) {
            Booking bk = pq.poll();
            
            if (!room.isEmpty()) {
                boolean flag = false;
                while(true) {
                    if (room.isEmpty() || flag) {
                        break;
                    }
                    if (bk.start >= room.peek()) {
                        room.poll();
                        continue;
                    }
                    flag = true;
                }
            }
            room.add(bk.end);
            
            answer = Math.max(answer, room.size());
        }
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] SplitTime = time.split(":");
        
        return Integer.parseInt(SplitTime[0]) * 60 + Integer.parseInt(SplitTime[1]);
    }
}
