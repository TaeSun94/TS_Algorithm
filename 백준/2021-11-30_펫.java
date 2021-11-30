import java.util.*;
import java.io.*;
public class 펫 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int o = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		boolean flag = false;
		int idx = 1;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			String oper = st.nextToken();
			String min = st.nextToken();
			if(oper.equals("0"))
				break;
			else if(oper.equals("#")) {
				if(w == 0)
					bw.write(idx+" RIP\n");
				else if(w > o/2 && w < o*2)
					bw.write(idx+" :-)\n");
				else {
					bw.write(idx+" :-(\n");
				}
				flag = true;
				idx++;
				continue;
			}
			if(flag) {
				flag = false;
				o = Integer.parseInt(oper);
				w = Integer.parseInt(min);
				continue;
			}
			if(w==0)
				continue;
			if(oper.equals("F")) {
				w+=Integer.parseInt(min);
			}
			else {
				w -= Integer.parseInt(min);
				if(w < 0)
					w = 0;
			}
		}
		bw.flush();
		bw.close();
	}
}
