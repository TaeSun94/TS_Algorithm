import java.util.*;
class Solution {
    static char[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
		map = new char[m][n];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length(); j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		while(true) {
			int score = findBlocks();
			if(score == 0) break;
			answer += score;
		}
        return answer;
    }

	private static int findBlocks() {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < map.length-1; i++) {
			for(int j = 0; j < map[i].length-1; j++) {
				if(map[i][j]!= ' ') {
					if(map[i][j]==map[i][j+1] && map[i][j] == map[i+1][j+1] && map[i][j] == map[i+1][j]) {
						set.add(i+"_"+j);
						set.add(i+"_"+(j+1));
						set.add((i+1)+"_"+(j+1));
						set.add((i+1)+"_"+j);
					}
				}
			}
		}

		modMap(set);

		return set.size();
	}

	private static void modMap(HashSet<String> set) {
		// TODO Auto-generated method stub
		Iterator it = set.iterator();
		//map에서 지우기
		for(String str: set) {
			String[] arr = str.split("_");
			map[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = ' ';
		}
		//블럭 내리기
		for(int i = 0; i < map[0].length; i++) {
			int cnt = 0;
			for(int j = map.length-1; j >= 0; j--) {
				if(map[j][i] == ' ') {
					cnt++;
				}
				else{
					if(cnt != 0) {
						map[j+cnt][i] = map[j][i];
						map[j][i] = ' ';
					}
				}
			}
		}
	}
}
