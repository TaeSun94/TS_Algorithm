import java.util.*;
public class 저항 {
	public static void main(String[] args) {
		ArrayList<String> color = new ArrayList<>(Arrays.asList("black","brown","red","orange","yellow","green","blue","violet","grey","white"));
		Scanner sc = new Scanner(System.in);
		String first_c = sc.nextLine();
		String second_c = sc.nextLine();
		String third_c = sc.nextLine();
		String str = ""+color.indexOf(first_c)+color.indexOf(second_c);
		long ans = Long.parseLong(str);
		ans *= Math.pow(10, color.indexOf(third_c));
		System.out.println(ans);
	}
}
