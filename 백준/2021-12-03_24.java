import java.util.*;
public class 이십사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] now = sc.nextLine().split(":");
		String[] start = sc.nextLine().split(":");

		String ans = "";
		int hour = Integer.parseInt(start[0]) - Integer.parseInt(now[0]);
		int min = Integer.parseInt(start[1]) - Integer.parseInt(now[1]);
		int sec = Integer.parseInt(start[2]) - Integer.parseInt(now[2]);
		if (sec < 0) {
			min--;
			sec += 60;
		}
		if (min < 0) {
			hour--;
			min += 60;
		}
		if(hour < 0) {
			hour += 24;
		}
		if (hour < 10) {
			ans += "0";
		}
		ans += hour+":";
		if (min < 10) {
			ans += "0";
		}
		ans += min+":";
		if (sec < 10) {
			ans += "0";
		}
		ans += sec;
		System.out.println(ans);
	}
}
