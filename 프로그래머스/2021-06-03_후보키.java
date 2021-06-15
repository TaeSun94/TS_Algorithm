/*
풀이: 튜플의 index를 넣어두고 조합을 이용하여 풀이
결과:
테스트 1 〉	실패 (16.43ms, 52MB)
테스트 2 〉	실패 (10.88ms, 52.8MB)
테스트 3 〉	실패 (12.65ms, 52.5MB)
테스트 4 〉	실패 (15.13ms, 52.6MB)
테스트 5 〉	통과 (14.69ms, 53MB)
테스트 6 〉	통과 (14.15ms, 53.8MB)
테스트 7 〉	통과 (13.24ms, 53.3MB)
테스트 8 〉	통과 (15.86ms, 52.9MB)
테스트 9 〉	실패 (12.42ms, 53.8MB)
테스트 10 〉	통과 (15.02ms, 52.4MB)
테스트 11 〉	실패 (13.59ms, 53.3MB)
테스트 12 〉	통과 (20.65ms, 53.6MB)
테스트 13 〉	실패 (11.52ms, 52.4MB)
테스트 14 〉	통과 (14.70ms, 53.4MB)
테스트 15 〉	통과 (13.03ms, 53.4MB)
테스트 16 〉	통과 (12.23ms, 52.9MB)
테스트 17 〉	통과 (15.38ms, 52.5MB)
테스트 18 〉	실패 (16.49ms, 53.1MB)
테스트 19 〉	실패 (13.63ms, 52.6MB)
테스트 20 〉	실패 (14.07ms, 52.8MB)
테스트 21 〉	통과 (26.73ms, 54.7MB)
테스트 22 〉	실패 (15.97ms, 53.6MB)
테스트 23 〉	실패 (11.40ms, 52.5MB)
테스트 24 〉	실패 (15.85ms, 52.1MB)
테스트 25 〉	실패 (13.26ms, 53.3MB)
테스트 26 〉	통과 (31.86ms, 53.9MB)
테스트 27 〉	통과 (13.44ms, 52.5MB)
테스트 28 〉	실패 (17.11ms, 53.8MB)
채점 결과
정확성: 46.4
합계: 46.4 / 100.0
*/
import java.util.*;
class Solution {
    static HashSet<Integer> set;
    static int[] input;
    static int[] result;
    static int cnt;
    public int solution(String[][] relation) {
        cnt = 0;
        set = new HashSet<>();
        input = new int[relation[0].length];
        for(int i = 0; i < input.length; i++){
            input[i] = i;
        }
        //튜플최대 갯수 만큼 for문
        for(int d = 1; d<=relation[0].length-set.size(); d++){
            //갯수에 따른 조합 구하기
            result = new int[d];
            comb(0,0,relation);
        }
        for(int num: set){
            System.out.println(num);
        }
        return cnt;
    }
    public void comb(int s_idx, int idx,String[][] relation){
        if(s_idx == result.length){
            String[] arr = new String[relation.length];
            Arrays.fill(arr,"");
            for(int i = 0; i < result.length; i++){
                if(set.contains(result[i]))
                    return;
                for(int j = 0; j < relation.length;j++){
                    arr[j] += "_"+relation[j][result[i]];
                }
            }
            HashSet<String> hs = new HashSet<>();
            for(String str: arr){
                hs.add(str);
            }
            if(hs.size() == relation.length){
                String key = "";
                for(int i = 0; i < result.length; i++){
                    set.add(result[i]);
                }
                cnt++;
            }
            return;
        }
        if(idx == input.length)
            return;
        result[s_idx] = input[idx];
        comb(s_idx+1, idx+1,relation);
        comb(s_idx, idx+1,relation);
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (2.02ms, 52MB)
테스트 2 〉	통과 (1.61ms, 53.2MB)
테스트 3 〉	통과 (1.85ms, 52.1MB)
테스트 4 〉	통과 (2.00ms, 52.5MB)
테스트 5 〉	통과 (1.84ms, 52.6MB)
테스트 6 〉	통과 (1.78ms, 52.3MB)
테스트 7 〉	통과 (1.74ms, 52.1MB)
테스트 8 〉	통과 (1.75ms, 52.3MB)
테스트 9 〉	통과 (2.18ms, 52.5MB)
테스트 10 〉	통과 (2.03ms, 52.8MB)
테스트 11 〉	통과 (4.28ms, 52.8MB)
테스트 12 〉	통과 (5.47ms, 54.7MB)
테스트 13 〉	통과 (3.00ms, 52.9MB)
테스트 14 〉	통과 (1.92ms, 52.4MB)
테스트 15 〉	통과 (1.59ms, 52.7MB)
테스트 16 〉	통과 (2.22ms, 53.1MB)
테스트 17 〉	통과 (1.66ms, 52.4MB)
테스트 18 〉	통과 (7.82ms, 52.9MB)
테스트 19 〉	통과 (7.40ms, 52.8MB)
테스트 20 〉	통과 (6.68ms, 53.6MB)
테스트 21 〉	통과 (7.78ms, 53.5MB)
테스트 22 〉	통과 (7.37ms, 53.7MB)
테스트 23 〉	통과 (1.61ms, 52.3MB)
테스트 24 〉	통과 (6.73ms, 53.2MB)
테스트 25 〉	통과 (8.98ms, 53.1MB)
테스트 26 〉	통과 (6.62ms, 53.7MB)
테스트 27 〉	통과 (2.34ms, 52.9MB)
테스트 28 〉	통과 (3.46ms, 52.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
	static ArrayList<HashSet<Integer>> ans;
    public int solution(String[][] relation) {
        ans = new ArrayList<>();
		for(int i = 0; i <= relation[0].length; i++) {
			comb(-1,i,0,new HashSet<>(), relation);
		}
        return ans.size();
    }

	private static void comb(int idx, int size, int s_idx, HashSet<Integer> keySet, String[][] relation) {
		// TODO Auto-generated method stub
		if(s_idx == size) {
			for(HashSet<Integer> key: ans) {
				if(keySet.containsAll(key)) {
					return;
				}
			}
			if(isUnique(keySet, relation)) {
				ans.add(keySet);
			}
			return;
		}
		for(int i = idx+1; i < relation[0].length; i++) {
			HashSet<Integer> newKey =  new HashSet<Integer>(keySet);
			newKey.add(i);
			comb(i, size, s_idx+1, newKey,relation);
		}
	}

	private static boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < relation.length; i++) {
			String key = "";
			for(int c: keySet) {
				key += relation[i][c];
			}
			if(set.contains(key))
				return false;
			set.add(key);
		}
		return true;
	}
}
