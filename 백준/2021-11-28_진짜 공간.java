import java.util.*;
public class 진짜공간 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		int cluster = sc.nextInt();
		long answer = 0;
		for(int file: list) {
			int num = 0;
			if(file%cluster> 0) {
				num++;
			}
			num += file/cluster;
			answer += num*cluster;
		}
		System.out.println(answer);
	}
}
