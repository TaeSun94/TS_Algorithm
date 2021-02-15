package 코딩테스트문제;

import java.util.Arrays;
import java.util.Scanner;

//파이프 자르기와 비슷한 문제 -> 가장 많이 지나는 점을 찾는게 목표
//브루트 포스 문제 같아 보임.
//한 시점에서 가장많은 갯수를 출력하면 됌
//일차원 배열을 통해서 모든 점을 넣은 뒤 가장 높은걸 출력해보자
//다이나믹 프로그래밍
//0:0:0.0
/*

입력: [
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"


"2016-09-15 01:00:04.002 2.0s",
"2016-09-15 01:00:07.000 2s"



"2016-09-15 01:00:04.001 2.0s"
,"2016-09-15 01:00:07.000 2s"
 */



public class 추석트래픽 {
	public static void main(String[] args) {
		String[] str = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
};
		int T = str.length;
		String[][] tmp = new String[T][2];
		//시간을 초로 변환하여 계산하면 어떨까? -> double
		long[][] start_end = new long[T][2];
		for(int i = 0; i < T; i++) {
			String t_str = str[i].substring(11);
			String[] tt = t_str.split(" ");
			tmp[i][0] = tt[0];
			tmp[i][1] = tt[1];
		}
		for(int i = 0; i < T; i++) {
			String[] value = tmp[i][0].split(":");
			long sum = Long.parseLong(value[0])*3600*1000+Long.parseLong(value[1])*60*1000+(long)(Double.parseDouble(value[2])*1000);
			start_end[i][1] = sum;
			String[] value2 = tmp[i][1].split("s");
			start_end[i][0] = sum - (long)(Double.parseDouble(value2[0])*1000);
		}
		long start = start_end[0][0];
		for(int i = 0; i < T; i++) {
			start_end[i][0] -= start;
			if(start_end[i][0] <0) {
				start_end[i][0] = 0;
			}
			start_end[i][1] -= start;
		}
		int max = 0;
		for(int i = 0; i < T; i++) {
			long tmp_start = start_end[i][0];
			int mem = 0;
			for(int j = 0; j < T; j++) {
				if(start_end[j][0] >= tmp_start+999) {
					continue;
				}
				else {
					if(start_end[j][1] <tmp_start) {
						continue;
					}
				}
				mem +=1;
				if(max < mem) {
					max = mem;
				}
			}
			long tmp_end = start_end[i][1];
			mem = 0;
			for(int j = 0; j < T; j++) {
				if(start_end[j][0] >= tmp_end+999) {
					continue;
				}
				else {
					if(start_end[j][1] <tmp_end) {
						continue;
					}
				}
				mem +=1;
				if(max < mem) {
					max = mem;
				}
			}
		}
		System.out.println(max);
	}
}
