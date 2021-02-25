import java.util.*;

public class 다리를지나는트럭 {
	static class Truck{
		int truck_bridge, weight;

		public Truck(int truck_bridge, int weight) {
			super();
			this.truck_bridge = truck_bridge;
			this.weight = weight;
		}

	}
	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		int answer = 0;

		Queue<Truck> bridge = new LinkedList<>();
		int pos = 0; // truck index
		int weight_sum = 0;
		while(true) {
			answer++;
			//다리에 있는 트럭들 한칸씩 땡기
			for(int i = 0; i < bridge.size(); i++) {
				Truck t = bridge.poll();
				t.truck_bridge += 1;
				bridge.add(t);
			}
			//트럭에 있는 것중 지난건 out.
			for(int i = 0; i < bridge.size(); i++) {
				Truck t = bridge.poll();
				if(t.truck_bridge > bridge_length) {
					weight_sum -= t.weight;
					continue;
				}
				bridge.add(t);
			}
			if(pos != truck_weights.length && weight_sum + truck_weights[pos] <= weight && bridge.size() < bridge_length) {
				weight_sum += truck_weights[pos];
				bridge.add(new Truck(1, truck_weights[pos]));
				pos++;
			}
			if(bridge.isEmpty() && pos == truck_weights.length)
				break;
		}
		System.out.println(answer);
	}
}
