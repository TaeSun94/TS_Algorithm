/*
정확성  테스트
테스트 1 〉	통과 (1.88ms, 67.2MB)
테스트 2 〉	통과 (1.61ms, 73.8MB)
테스트 3 〉	통과 (1.58ms, 67.1MB)
테스트 4 〉	통과 (2.33ms, 61.9MB)
테스트 5 〉	통과 (9.65ms, 75.7MB)
테스트 6 〉	통과 (6.49ms, 73.7MB)
테스트 7 〉	통과 (5.72ms, 61.4MB)
테스트 8 〉	통과 (6.29ms, 73.3MB)
테스트 9 〉	통과 (6.42ms, 63.2MB)
테스트 10 〉	통과 (7.05ms, 76MB)
테스트 11 〉	통과 (4.07ms, 74.2MB)
테스트 12 〉	통과 (3.74ms, 73.9MB)
테스트 13 〉	통과 (5.66ms, 70.6MB)
테스트 14 〉	통과 (7.72ms, 72.7MB)
테스트 15 〉	통과 (1.52ms, 60.6MB)
테스트 16 〉	통과 (1.82ms, 72MB)
테스트 17 〉	통과 (6.64ms, 70.8MB)
테스트 18 〉	통과 (2.33ms, 59.5MB)
테스트 19 〉	통과 (7.17ms, 72.7MB)
테스트 20 〉	통과 (5.64ms, 73.4MB)
테스트 21 〉	통과 (7.31ms, 74.4MB)
테스트 22 〉	통과 (5.50ms, 77.8MB)
테스트 23 〉	통과 (4.73ms, 61.9MB)
테스트 24 〉	통과 (6.85ms, 72.7MB)
테스트 25 〉	통과 (124.15ms, 178MB)
테스트 26 〉	통과 (128.93ms, 160MB)
테스트 27 〉	통과 (135.22ms, 175MB)
테스트 28 〉	통과 (146.07ms, 154MB)
테스트 29 〉	통과 (154.87ms, 174MB)
테스트 30 〉	통과 (151.96ms, 171MB)
테스트 31 〉	통과 (92.54ms, 175MB)
테스트 32 〉	통과 (87.82ms, 142MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[][] change_record = new String[record.length][2];
		HashMap<String, String> hm = new HashMap<String, String>();
		int idx = 0;
		for(int i = 0; i < record.length; i++) {
			String tmp = record[i];
			String[] parse = tmp.split(" ");
			if(hm.containsKey(parse[1])) {
				if(parse[0].equals("Change")) {
					hm.remove(parse[1]);
					hm.put(parse[1], parse[2]);
				}
				else if(parse[0].equals("Enter")) {
					hm.remove(parse[1]);
					hm.put(parse[1], parse[2]);
				}
			}
			else {
				hm.put(parse[1], parse[2]);
			}
			if(parse[0].equals("Enter")) {
				change_record[idx][0] = "님이 들어왔습니다.";
				change_record[idx][1] = parse[1];
				idx++;
			}
			else if(parse[0].equals("Leave")) {
				change_record[idx][0] = "님이 나갔습니다.";
				change_record[idx][1] = parse[1];
				idx++;
			}
		}
		String[] answer = new String[idx];
		for(int i = 0; i < idx; i++) {
			answer[i] = hm.get(change_record[i][1])+change_record[i][0];
		}
        // hm.clear();
        return answer;
    }
}
