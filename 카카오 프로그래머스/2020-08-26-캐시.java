package 코딩테스트문제;

import java.util.*;

//equalsIgnoreCase

//cache 길이만큼 que생성 만약 풀이면 pop한뒤 다시 넣기로 반복
/*
int cacheSize = 3;
String[] cities = {};
 */
public class 캐시 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

		Queue<String> que = new LinkedList<>();
		Queue<String> que2 = new LinkedList<>();
		int answer = 0;
		for(int i = 0; i < cities.length; i++) {
			boolean check = false;
			int idx = 0;
			while(!que.isEmpty()) {
				String tmp = que.poll();
				if(tmp.equalsIgnoreCase(cities[i])) {
					answer +=1;
					check = true;
					que.add(tmp);
					break;
				}
				idx++;
				que2.add(tmp);
			}
			while(!que.isEmpty()) {
				que2.add(que.poll());
			}
			while(!que2.isEmpty()) {
				que.add(que2.poll());
			}
			if(!check) {
				answer+=5;
				if(que.size() == cacheSize) {
					que.poll();
				}
				que.add(cities[i]);
			}
		}
		System.out.println(answer);
	}
}
