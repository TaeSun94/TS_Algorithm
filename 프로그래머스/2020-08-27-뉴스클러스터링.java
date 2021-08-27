/*
정확성  테스트
테스트 1 〉	통과 (12.04ms, 72.9MB)
테스트 2 〉	통과 (9.41ms, 61MB)
테스트 3 〉	통과 (15.83ms, 75.5MB)
테스트 4 〉	통과 (14.14ms, 70.7MB)
테스트 5 〉	통과 (13.78ms, 59.7MB)
테스트 6 〉	통과 (11.72ms, 72.7MB)
테스트 7 〉	통과 (10.37ms, 61.7MB)
테스트 8 〉	통과 (9.17ms, 73.6MB)
테스트 9 〉	통과 (10.83ms, 71.1MB)
테스트 10 〉	통과 (10.49ms, 73.3MB)
테스트 11 〉	통과 (12.29ms, 59.1MB)
테스트 12 〉	통과 (13.72ms, 73.8MB)
테스트 13 〉	통과 (9.55ms, 59.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
package 코딩테스트문제;

import java.util.ArrayList;

public class 뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		String tmp = "";
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i)>='A' && str1.charAt(i)<='Z') {
				tmp += str1.charAt(i);
				if(tmp.length()==2) {
					A.add(tmp);
					tmp = tmp.substring(1);
				}
			}
			else {
				tmp ="";
			}
		}
		tmp = "";
		for(int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i)>='A' && str2.charAt(i)<='Z') {
				tmp += str2.charAt(i);
				if(tmp.length()==2) {
					B.add(tmp);
					tmp = tmp.substring(1);
				}
			}
			else {
				tmp ="";
			}
		}
		if(A.size()==0 && B.size()==0) {
			System.out.println(65536);
		}
		double union_length = A.size()+B.size();
		double intersection_length = 0;
		for(int i = 0; i < A.size(); i++) {
			for(int j = 0; j < B.size(); j++) {
				if(A.get(i).equals(B.get(j))) {
					intersection_length++;
					A.remove(i);
					B.remove(j);
					i -=1;
					break;
				}
			}
		}
		union_length -= intersection_length;
		double answer = (intersection_length/union_length)*65536;
		System.out.println((int)answer);
	}
}
