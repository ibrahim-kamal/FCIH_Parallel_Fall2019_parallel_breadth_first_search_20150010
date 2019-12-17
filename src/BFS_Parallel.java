import java.util.Queue;
import java.util.Set;

public class BFS_Parallel implements Runnable {
	private int cityId;
	private Graph graph;
	private Queue<Integer> queue;
	private Set<Integer> visited;

	public BFS_Parallel(Queue<Integer> queue, Set<Integer> visited, int cityId, Graph graph) {
        this.cityId = cityId;
		this.graph = graph;
		this.queue = queue;
		this.visited = visited;
	}
	
	public void run() {
            int city = cityId;
            visitNode(city);

            while (!queue.isEmpty()) {
                Integer currentCity = queue.poll();
                for (Integer c : graph.getCitiyDistenations(currentCity)) 
                    visitNode(c);
        }
    }

    private void visitNode(int city) {
        synchronized (graph.getCities().get(city)) {
            if (!visited.contains(city)) {
            	System.out.println("Visiting City #" + city);
                visited.add(city);
                queue.add(city);
            }
        }
    }
	
}
