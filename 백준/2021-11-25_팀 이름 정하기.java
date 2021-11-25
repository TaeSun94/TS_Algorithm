import java.util.*;
import java.io.*;
public class 팀이름정하기 {
	static HashMap<Character, Integer> team;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doo = br.readLine();
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		team = new LinkedHashMap<Character, Integer>();
		map.put('L', 0);
		map.put('O', 0);
		map.put('V', 0);
		map.put('E', 0);
		team.put('L', 0);
		team.put('O', 0);
		team.put('V', 0);
		team.put('E', 0);
		for(int i = 0; i < doo.length(); i++) {
			if(map.containsKey(doo.charAt(i))) {
				map.replace(doo.charAt(i), map.get(doo.charAt(i))+1);
			}
		}
		double max = -1;
		String ans = "";
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			init(map);
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				if(team.containsKey(str.charAt(j))) {
					team.replace(str.charAt(j), team.get(str.charAt(j))+1);
				}
			}
			double score = 1;
			for(char key: map.keySet()) {
				boolean flag = false;
				for(char key2: team.keySet()) {
					if(flag) {
						score *= (team.get(key)+team.get(key2));
					}
					else {
						if(key == key2) {
							flag = true;
						}
					}
				}
			}
			score %= 100;
			if(max < score) {
				max = score;
				ans = str;
			}
			else if(max == score) {
				if(ans.compareTo(str) > 0) {
					ans = str;
				}
			}
		}
		System.out.println(ans);
	}
	private static void init(HashMap<Character, Integer> map) {
		// TODO Auto-generated method stub
		for(char key: team.keySet()) {
			team.replace(key, map.get(key));
		}
	}
}
