/*
3번의 시도로 성공
1차 단순한 2개의 ArrayList를 사용하여 넣고 빼주고를 통하여 결과값 계산 -> 오류
2차 hashmap과 hashset을 이용한 풀이 -> 현재 회의실에 들어가있는 사람들을 나갈때마다 계속 확인해주는 작업에 의해 시간 초과
3차 회의실에 들어가는 사람의 변동에 따라 set에 추가하는 반복문 실행 -> 통과
*/

/*
정확성  테스트
테스트 1 〉	실패 (0.25ms, 68.2MB)
테스트 2 〉	통과 (0.30ms, 70.2MB)
테스트 3 〉	통과 (0.09ms, 60.5MB)
테스트 4 〉	실패 (0.67ms, 74.7MB)
테스트 5 〉	통과 (0.59ms, 72MB)
테스트 6 〉	통과 (4.49ms, 59.1MB)
테스트 7 〉	실패 (2.16ms, 73MB)
테스트 8 〉	실패 (4.09ms, 67MB)
테스트 9 〉	실패 (8.91ms, 73.2MB)
테스트 10 〉	실패 (186.84ms, 91.8MB)
테스트 11 〉	실패 (416.80ms, 234MB)
테스트 12 〉	실패 (903.29ms, 395MB)
테스트 13 〉	통과 (0.12ms, 59.9MB)
테스트 14 〉	통과 (0.13ms, 70.9MB)
테스트 15 〉	통과 (0.12ms, 59.3MB)
테스트 16 〉	통과 (0.09ms, 72.4MB)
테스트 17 〉	통과 (0.09ms, 68.6MB)
테스트 18 〉	통과 (0.51ms, 68.3MB)
테스트 19 〉	실패 (0.98ms, 75.1MB)
테스트 20 〉	실패 (0.21ms, 69.1MB)
테스트 21 〉	실패 (15.88ms, 74.7MB)
테스트 22 〉	실패 (21.57ms, 59.8MB)
테스트 23 〉	실패 (3.93ms, 59.1MB)
테스트 24 〉	실패 (777.38ms, 396MB)
테스트 25 〉	실패 (334.56ms, 219MB)
테스트 26 〉	실패 (4536.24ms, 431MB)
테스트 27 〉	실패 (2421.09ms, 415MB)
테스트 28 〉	실패 (0.20ms, 68MB)
테스트 29 〉	실패 (0.83ms, 73.3MB)
테스트 30 〉	실패 (16.54ms, 61.1MB)
테스트 31 〉	실패 (140.91ms, 104MB)
테스트 32 〉	실패 (379.87ms, 175MB)
테스트 33 〉	실패 (1738.75ms, 489MB)
테스트 34 〉	실패 (1790.43ms, 478MB)
테스트 35 〉	실패 (1.30ms, 71.1MB)
테스트 36 〉	실패 (3.74ms, 70.1MB)
테스트 37 〉	통과 (0.05ms, 68.7MB)
채점 결과
정확성: 23.5
합계: 23.5 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = {};
        HashMap<Integer, HashSet<Integer>> data = new HashMap<>();

		for(int i = 0; i < enter.length; i++) {
			ArrayList<Integer> room = new ArrayList<>();
			if(!data.containsKey(enter[i]))
				data.put(enter[i], new HashSet<>());
			room.add(enter[i]);
			ArrayList<Integer> outList = new ArrayList<>();
			for(int j = 0; j < leave.length; j++) {
				if(enter[i] == leave[j])
					break;
				if(data.get(enter[i]).contains(leave[j]))
					continue;
				outList.add(leave[j]);
			}
			for(int out: outList) {
				for(int k = i+1; k < enter.length; k++) {
					if(out == enter[k]) {
						if(!data.containsKey(enter[k])) {
							data.put(enter[k], new HashSet<>());
						}
						data.get(enter[k]).add(enter[i]);
						data.get(enter[i]).add(enter[k]);
						break;
					}
					if(!data.containsKey(enter[k])) {
						data.put(enter[k], new HashSet<>());
					}
					data.get(enter[k]).add(enter[i]);
					data.get(enter[i]).add(enter[k]);
				}

			}
		}
		answer = new int[data.size()];
		for(int key: data.keySet()) {
			answer[key-1] = data.get(key).size();
		}
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.14ms, 70.4MB)
테스트 2 〉	통과 (0.56ms, 72.6MB)
테스트 3 〉	통과 (0.20ms, 74.1MB)
테스트 4 〉	통과 (0.73ms, 80MB)
테스트 5 〉	통과 (0.38ms, 68.5MB)
테스트 6 〉	통과 (6.43ms, 73.6MB)
테스트 7 〉	통과 (2.52ms, 72MB)
테스트 8 〉	통과 (8.08ms, 70.6MB)
테스트 9 〉	통과 (13.05ms, 74.7MB)
테스트 10 〉	통과 (219.13ms, 114MB)
테스트 11 〉	통과 (1223.73ms, 368MB)
테스트 12 〉	통과 (3358.95ms, 375MB)
테스트 13 〉	통과 (0.09ms, 72.6MB)
테스트 14 〉	통과 (0.08ms, 70.9MB)
테스트 15 〉	통과 (0.09ms, 75MB)
테스트 16 〉	통과 (0.14ms, 62.3MB)
테스트 17 〉	통과 (0.13ms, 70.8MB)
테스트 18 〉	통과 (0.36ms, 73.5MB)
테스트 19 〉	통과 (0.61ms, 61.8MB)
테스트 20 〉	통과 (0.13ms, 74.2MB)
테스트 21 〉	통과 (99.72ms, 81.9MB)
테스트 22 〉	통과 (14.85ms, 58.3MB)
테스트 23 〉	통과 (1.41ms, 75.6MB)
테스트 24 〉	통과 (2257.13ms, 374MB)
테스트 25 〉	통과 (750.45ms, 194MB)
테스트 26 〉	실패 (시간 초과)
테스트 27 〉	통과 (6402.73ms, 417MB)
테스트 28 〉	통과 (0.10ms, 73.7MB)
테스트 29 〉	통과 (0.31ms, 76.8MB)
테스트 30 〉	통과 (7.07ms, 74.5MB)
테스트 31 〉	통과 (158.12ms, 88.7MB)
테스트 32 〉	통과 (357.91ms, 130MB)
테스트 33 〉	통과 (1951.32ms, 394MB)
테스트 34 〉	통과 (2191.59ms, 397MB)
테스트 35 〉	통과 (0.22ms, 74MB)
테스트 36 〉	통과 (5.67ms, 57.6MB)
테스트 37 〉	통과 (0.09ms, 71.8MB)
채점 결과
정확성: 97.1
합계: 97.1 / 100.0
*/
import java.util.*;
class Solution {
    // static class Person{
    //     int number;
    //     HashSet<Integer> meets;
    //     Person(int number){
    //         this.number = number;
    //         this.meets = new HashSet<>();
    //     }
    // }
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        // ArrayList<Person> people = new ArrayList<>();
        // for(int i = 0; i < enter.length; i++){
        //     people.add(new Person(i+1));
        // }
        int eIdx = 0;
        int lIdx = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < enter.length; i++){
            map.put(i+1,new HashSet<>());
        }
        HashSet<Integer> set = new HashSet<>();
        while(lIdx<leave.length){
            if(!set.contains(leave[lIdx])){
                for(int i = eIdx; i < enter.length; i++){
                    set.add(enter[i]);
                    if(enter[i]==leave[lIdx]){
                        eIdx = i+1;
                        break;
                    }
                }
            }
            for(int num: set){
                for(int number: set){
                    if(num==number)
                        continue;
                    map.get(num).add(number);
                }
            }
            set.remove(leave[lIdx]);
            // System.out.println(leave[lIdx]+" "+set.toString());
            lIdx++;
        }
        for(int key: map.keySet()){
            answer[key-1] = map.get(key).size();
            // System.out.println(key+" "+map.get(key).toString());
        }
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.10ms, 71.7MB)
테스트 2 〉	통과 (0.15ms, 67.8MB)
테스트 3 〉	통과 (0.09ms, 70.8MB)
테스트 4 〉	통과 (0.48ms, 69.3MB)
테스트 5 〉	통과 (0.19ms, 58.7MB)
테스트 6 〉	통과 (0.83ms, 70.8MB)
테스트 7 〉	통과 (0.86ms, 69.5MB)
테스트 8 〉	통과 (1.11ms, 72.4MB)
테스트 9 〉	통과 (2.77ms, 69.5MB)
테스트 10 〉	통과 (36.86ms, 83.7MB)
테스트 11 〉	통과 (79.71ms, 88.7MB)
테스트 12 〉	통과 (150.82ms, 96MB)
테스트 13 〉	통과 (0.10ms, 73.6MB)
테스트 14 〉	통과 (0.09ms, 72.4MB)
테스트 15 〉	통과 (0.07ms, 69.7MB)
테스트 16 〉	통과 (0.06ms, 70.5MB)
테스트 17 〉	통과 (0.08ms, 59.1MB)
테스트 18 〉	통과 (0.18ms, 59.1MB)
테스트 19 〉	통과 (0.20ms, 71.8MB)
테스트 20 〉	통과 (0.12ms, 59.5MB)
테스트 21 〉	통과 (8.93ms, 75.2MB)
테스트 22 〉	통과 (2.99ms, 58.3MB)
테스트 23 〉	통과 (0.81ms, 75.4MB)
테스트 24 〉	통과 (139.00ms, 90.2MB)
테스트 25 〉	통과 (105.50ms, 108MB)
테스트 26 〉	통과 (486.26ms, 189MB)
테스트 27 〉	통과 (325.21ms, 146MB)
테스트 28 〉	통과 (0.09ms, 68.5MB)
테스트 29 〉	통과 (0.14ms, 58.9MB)
테스트 30 〉	통과 (3.61ms, 70.8MB)
테스트 31 〉	통과 (22.36ms, 62.8MB)
테스트 32 〉	통과 (94.64ms, 101MB)
테스트 33 〉	통과 (204.63ms, 127MB)
테스트 34 〉	통과 (215.39ms, 119MB)
테스트 35 〉	통과 (0.22ms, 66.9MB)
테스트 36 〉	통과 (0.64ms, 69.9MB)
테스트 37 〉	통과 (0.06ms, 69.3MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        int eIdx = 0;
        int lIdx = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < enter.length; i++){
            map.put(i+1,new HashSet<>());
        }
        HashSet<Integer> set = new HashSet<>();
        while(lIdx<leave.length){
            boolean flag = false;
            if(!set.contains(leave[lIdx])){
                flag = true;
                for(int i = eIdx; i < enter.length; i++){
                    set.add(enter[i]);
                    if(enter[i]==leave[lIdx]){
                        eIdx = i+1;
                        break;
                    }
                }
            }
            if(flag){
                for(int num: set){
                    for(int number: set){
                        if(num==number)
                            continue;
                        map.get(num).add(number);
                    }
                }
            }
            set.remove(leave[lIdx]);
            // System.out.println(leave[lIdx]+" "+set.toString());
            lIdx++;
        }
        for(int key: map.keySet()){
            answer[key-1] = map.get(key).size();
            // System.out.println(key+" "+map.get(key).toString());
        }
        return answer;
    }
}
