import java.util.*;
public class 집주소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		for(int i = 2; i <= 9; i++) {
			list.add(3);
		}
		while(true) {
			String num = sc.nextLine();
			if(num.equals("0")) {
				break;
			}
			int width = 1;
			for(int i = 0; i < num.length(); i++) {
				width += list.get(num.charAt(i)-'0')+1;
			}
			System.out.println(width);
		}
	}
}
