package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		long max = list.get(list.size()-1);
		long min = 1;
		while(min <= max) {
			long mid = (max+min)/2;
			long cnt = 0;
			for(int i = 0; i < list.size(); i++) {
				cnt += list.get(i)/mid;
			}
			if(cnt >= N) {
				min = mid+1;
			}else if(cnt < N) {
				max = mid-1;
			}
		}
		System.out.println(max);
	}
}
