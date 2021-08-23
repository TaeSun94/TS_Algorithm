/*
정확성  테스트
테스트 1 〉	통과 (0.40ms, 56.5MB)
테스트 2 〉	통과 (0.57ms, 59.9MB)
테스트 3 〉	통과 (0.46ms, 63.1MB)
테스트 4 〉	통과 (0.48ms, 72.2MB)
테스트 5 〉	통과 (0.44ms, 74.1MB)
테스트 6 〉	통과 (0.33ms, 73.4MB)
테스트 7 〉	통과 (0.35ms, 60MB)
테스트 8 〉	통과 (0.30ms, 70.8MB)
테스트 9 〉	통과 (0.26ms, 58.3MB)
테스트 10 〉	통과 (0.40ms, 71.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, HashMap<String,Integer>> data = new HashMap<>();
		HashMap<String, Integer> ans = new HashMap<>();
		//언어에 따른 선호 점수 테이블
		for(int i = 0; i < table.length; i++) {
			String[] tmp = table[i].split(" ");
			data.put(tmp[0],new HashMap<>());
			ans.put(tmp[0],0);
			int score = 5;
			for(int j = 1; j < tmp.length; j++) {
				data.get(tmp[0]).put(tmp[j], score--);
			}
		}
		for(int i = 0; i < languages.length; i++) {
			for(String key: data.keySet()) {
				if(data.get(key).containsKey(languages[i])) {
					int tmp = data.get(key).get(languages[i])*preference[i];
					ans.replace(key, ans.get(key)+tmp);
				}
			}
		}
		//최고 점의 직군 return
		ArrayList<String> list = new ArrayList<>();
		int max = 0;
		String answer = "";
		for(String key: ans.keySet()) {
			if(max< ans.get(key)) {
				max = ans.get(key);
				answer = key;
				list.clear();
				list.add(key);
			}
			else if(max == ans.get(key)) {
				list.add(key);
			}
		}
		Collections.sort(list);

		// System.out.println(list.get(0));
        return list.get(0);
    }
}
