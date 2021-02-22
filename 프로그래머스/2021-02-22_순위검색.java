package 프로그래머스;
import java.util.*;
public class 순위검색 {
	static class Person{
		String lang,position,work,soulfood;
		int score;
		public Person(String lang, String position, String work, String soulfood, int score) {
			super();
			this.lang = lang;
			this.position = position;
			this.work = work;
			this.soulfood = soulfood;
			this.score = score;
		}
		public boolean Compare(String lang, String position, String work, String soulfood, int score) {
			if(lang.equals("-") || this.lang.equals(lang))
				if(position.equals("-") || this.position.equals(position))
					if(work.equals("-") || this.work.equals(work))
						if(soulfood.equals("-") || this.soulfood.equals(soulfood))
							if(score == 0 || this.score >= score)
								return true;
			return false;
		}
		@Override
		public String toString() {
			return "Person [lang=" + lang + ", position=" + position + ", work=" + work + ", soulfood=" + soulfood
					+ ", score=" + score + "]";
		}

	}
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
		ArrayList<Person> list = new ArrayList<>();
		for(int i = 0; i < info.length; i++) {
			String[] data = info[i].split(" ");
			list.add(new Person(data[0],data[1],data[2],data[3],Integer.parseInt(data[4])));
		}
//		for(Person p : list) {
//			System.out.println(p.toString());
//		}
//		System.out.println();
		int[] answer = new int[query.length];
		for(int i = 0; i < query.length; i++) {
			String[] query_data = query[i].split(" ");
			String[] data = new String[5];
			int idx = 0;
			for(int j = 0; j < query_data.length; j++) {
				if(query_data[j].equals("and"))
					continue;
				data[idx++] = query_data[j];
			}
//			System.out.println(Arrays.toString(data));
//			boolean[] check = new boolean[list.size()];
			ArrayList<Person> al = new ArrayList<>(list);
			int cnt = 0;
			for(int k = 0; k < al.size(); k++) {
				Person p = al.get(k);
				String lang = data[0];
				String position = data[1];
				String work = data[2];
				String soulfood = data[3];
				int score = 0;
				if(!data[4].equals("-"))
					score = Integer.parseInt(data[4]);
				if(p.Compare(lang, position, work, soulfood, score))
					cnt++;
			}

			answer[i] = cnt;
		}

		System.out.println(Arrays.toString(answer));
	}
}
