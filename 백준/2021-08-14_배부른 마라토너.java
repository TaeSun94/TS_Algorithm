package 쩜문제추천;
import java.util.*;
public class 배부른마라토너 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < N; i++) {
			String key = sc.next();
			if(map.containsKey(key)) {
				map.replace(key, map.get(key)+1);
			}
			else
				map.put(key,1);
		}
		for(int i= 0; i < N-1; i++) {
			String key = sc.next();
			if(map.containsKey(key)) {
				map.replace(key, map.get(key)-1);
				if(map.get(key)==0)
					map.remove(key);
			}
		}
		String answer = "";
		for(String key: map.keySet()) {
			answer = key;
		}
		System.out.println(answer);
	}
}
