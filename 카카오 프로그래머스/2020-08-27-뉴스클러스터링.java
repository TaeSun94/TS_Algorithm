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
