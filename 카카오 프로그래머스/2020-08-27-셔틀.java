package 코딩테스트문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//n은 셔틀버스 갯수, t는 셔틀버스의 간격, m은 최대의 승객 수
//셔틀의 출발 시간은 09:00으로 고정// 콘은 무조건 가야한다.
/*
int n = 1;
int t = 1;
int m = 5;

String[] timetable = {"08:00","08:01","08:02","08:03"};
 */
public class 셔틀버스 {
	static class arriveTime {
		int h;
		int m;
		public arriveTime(int h, int m) {
			// TODO Auto-generated constructor stub
			this.h = h;
			this.m = m;
		}
	}
	public static void main(String[] args) {
		int n = 2;
		int t = 1;
		int m = 4;

		String[] timetable = {"09:00","09:00","09:00","09:00","09:00","09:00","08:59","08:59"};
		ArrayList<arriveTime> list = new ArrayList<arriveTime>();
		//timetable 정렬

		for(int i = 0; i < timetable.length; i++) {
			String[] tmp = timetable[i].split(":");
			list.add(new arriveTime(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])));
		}
		Collections.sort(list, new Comparator<arriveTime>() {
			@Override
			public int compare(arriveTime o1, arriveTime o2) {
				// TODO Auto-generated method stub
				if(o1.h == o2.h) {
					if(o1.m <= o2.m)
						return -1;
					else
						return 1;
				}
				else if(o1.h < o2.h) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		//데이터 만들기
		for(int i = 0; i < list.size();i++) {
			System.out.println(list.get(i).h +" "+list.get(i).m);
		}
		//셔틀만들기
		ArrayList<arriveTime> suttle = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				suttle.add(new arriveTime(9, 0));
				continue;
			}
			arriveTime pre_suttle = suttle.get(i-1);
			int p_s_h = pre_suttle.h;
			int p_s_m = pre_suttle.m;
			int n_s_h = p_s_h;
			int n_s_m = p_s_m+t;
			if(n_s_m >= 60) {
				n_s_h += 1;
				n_s_m -= 60;
			}
			arriveTime next_suttle = new arriveTime(n_s_h,n_s_m);
			suttle.add(next_suttle);
		}
//		for(int i = 0; i < suttle.size(); i++) {
//			System.out.println(suttle.get(i).h+" "+suttle.get(i).m);
//		}
		arriveTime con = null;
//		boolean[] check = new boolean[timetable.length];
		int idx = 0;
		for(int i = 0; i < suttle.size(); i++) {
			ArrayList<arriveTime> crew = new ArrayList<>();
			for(int j = idx; j < list.size(); j++) {
				if(crew.size()==m)
					break;
				if(suttle.get(i).h > list.get(j).h) {
//					check[j] = true;
					idx++;
					crew.add(list.get(j));
				}
				else if(suttle.get(i).h == list.get(j).h) {
					if(suttle.get(i).m >= list.get(j).m) {
//						check[j] = true;
						idx++;
						crew.add(list.get(j));
					}
				}
			}
			System.out.println("크루");
			for(int j = 0; j < crew.size(); j++) {
				System.out.println(crew.get(j).h+" "+crew.get(j).m);
			}
			if(i == suttle.size()-1) {
				if(crew.size()==m) {
					arriveTime lastmem = crew.get(m-1);
					int con_h = lastmem.h;
					int con_m = lastmem.m;
					if(lastmem.m == 0 ) {
						con_h -=1;
						con_m += 60;
					}
					con_m -= 1;
					con = new arriveTime(con_h, con_m);
				}
				else {
					con = suttle.get(i);
				}
			}
		}
		if(con.h == -1) {
			con.h = 0;
			con.m = 0;
		}
		String answer = "";
		if (con.h < 10) {
			answer += "0";
		}
		answer += con.h + ":";
		if (con.m < 10) {
			answer += "0";
		}
		answer += con.m;
		System.out.println(answer);
	}
}
