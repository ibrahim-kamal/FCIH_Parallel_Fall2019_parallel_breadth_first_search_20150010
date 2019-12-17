import java.util.ArrayList;
import java.util.LinkedList;

public class BFS_Serial {
	
	public static void walk(int startCity, Graph g) {
		System.out.println("-------------Serial BFS Walking Tree--------------");
		ArrayList<Integer> visited = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited.add(startCity);
		queue.add(startCity);
		while(!queue.isEmpty()) {
			int currentCity = queue.poll();
			System.out.println("Visiting City #" + currentCity);
			
			for(int city : g.getCitiyDistenations(currentCity)) {
				if(visited.contains(city)) continue;
				
				queue.add(city);
				visited.add(city);
			}
		}
	}

}
