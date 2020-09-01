package 코딩테스트문제;

import java.util.*;
// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
/*
1시간 15분 걸림
N은 1이상 500이하 자연수
stages 길이는 1이상 200000이하
stages에는 1이상 N+1이하의 자연수가 담겨있다.
실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록
 */
/*
int N = 5;
int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

int N = 4;
int[] stages = {4,4,4,4,4};
N=8 , stages=[1,2,3,4,5,6,7]

result = 7 6 5 4 3 2 1 8
 */
public class 실패율 {
	static class Node{
		double fail;
		int stage_num;
		public Node(double fail, int stage_num){
			this.fail = fail;
			this.stage_num = stage_num;
		}
	}
	public static void main(String[] args) {
		int N = 3;
		int[] stages = {1,1,2,2,2};
		int[] answer = new int[N];
		double mem_num = (double)stages.length;
		int[] now_stage = new int[N+1];
		Arrays.sort(stages);
//		System.out.println(Arrays.toString(stages));
		ArrayList<Node> list = new ArrayList<>();
		int idx = 1;
		double count = 0.0;
		for(int i = 0; i < stages.length; i++) {
			if(idx > N) {
				break;
			}
			if(idx == stages[i]) {
				count+=1;
				if(i == stages.length-1) {
					list.add(new Node(count/mem_num, idx));
				}
			}
			else {
				list.add(new Node(count/mem_num, idx));
				mem_num -= count;
				count = 0;
				idx++;
				i -= 1;
			}
		}
		if(list.size() < N) {
			int last = list.get(list.size()-1).stage_num;
			for(int i = list.size(); i < N; i++) {
				last++;
				list.add(new Node(0.0, last));
			}
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.fail >= o2.fail) {
					if(o1.fail == o2.fail) {
						if(o1.stage_num < o2.stage_num)
							return -1;
						else
							return 1;
					}
					else {
						return -1;
					}
				}
				else
					return 1;
			}
		});
		for(int i = 0;i<N;i++) {
			answer[i] = list.get(i).stage_num;
		}
		System.out.println(Arrays.toString(answer));
//		System.out.println();for(int i = 0; i < list.size(); i++)
//			System.out.println(list.get(i).fail+" "+list.get(i).stage_num);
	}
}
