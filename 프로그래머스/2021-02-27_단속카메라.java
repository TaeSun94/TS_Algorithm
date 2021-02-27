import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        ArrayList<int[]> list = new ArrayList<>();
		for(int[] route: routes) {
			list.add(route);
		}
		int answer = 0;

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] > o2[1])
					return 1;
				else if(o1[1] == o2[1]) {
					if(o1[0] > o2[0])
						return 1;
					else
						return -1;
				}
				return -1;
			}
		});

		boolean[] check = new boolean[list.size()];
		for (int i = 0; i < check.length; i++) {
			if(check[i])
				continue;
			check[i] = true;
			int tmp = list.get(i)[1];
			for(int j = i+1; j < check.length; j++) {
				if(tmp >= list.get(j)[0]) {
					check[j] = true;
				}
				else {
					break;
				}
			}
			answer++;
		}
        return answer;
    }
}
