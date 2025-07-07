import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> feeMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            if (record[2].equals("IN")) {
                hm.put(record[1], convertTime(record[0]));
            } else {
                if (feeMap.containsKey(record[1])) {
                    feeMap.replace(record[1], feeMap.get(record[1]) + convertTime(record[0]) - hm.get(record[1]));
                } else {
                    feeMap.put(record[1], convertTime(record[0]) - hm.get(record[1]));
                }
                hm.remove(record[1]);
            }
        }
        
        // for (String key: feeMap.keySet()) {
        //     System.out.println("FEE MAP: " + key + " : " + feeMap.get(key));
        // }

        for (String key: hm.keySet()) {
            // System.out.println("REMAIN- "+key+ " : " + hm.get(key));
            if (feeMap.containsKey(key)) {
                int newTime = convertTime("23:59") - hm.get(key);
                feeMap.replace(key, feeMap.get(key) + newTime);
            } else {
                feeMap.put(key, convertTime("23:59") - hm.get(key));
            }
        }

        ArrayList<String> al = new ArrayList<>();
        for (String key: feeMap.keySet()) {
            al.add(key);
        }
        Collections.sort(al);

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            // System.out.println(al.get(i)+" : "+ feeMap.get(al.get(i)));
            answer[i] = calculate(feeMap.get(al.get(i)), fees[0], fees[1], fees[2], fees[3]);
        }
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] splitTime = time.split(":");
        int hours = Integer.parseInt(splitTime[0]) * 60;
        int miniuts = Integer.parseInt(splitTime[1]);
        
        return hours + miniuts;
    }
    // [1, 461, 1, 10]
    public int calculate(int time, int base_time, int base_fee, int duration, int duration_fee) {
        int total_time = time - base_time;
        if (total_time <= 0) {
            return base_fee;
        } else {
            int total_fee = base_fee;
            int addTime = total_time%duration == 0 ? 0 : 1;
            total_fee += (total_time/duration + addTime) * duration_fee;
            return total_fee;
        }
    }
}
