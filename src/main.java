import java.lang.Thread.State;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numThreads;
		System.out.print("Enter Parallel Threads number: ");
        numThreads = sc.nextInt(); 
        sc.close();
        
		Graph g = new Graph();
		
		g.addRoute(0, 2);
		g.addRoute(1, 2);
		g.addRoute(1, 4);
		g.addRoute(3, 1);
		g.addRoute(2, 1);
		g.addRoute(1, 0);
		
		printGraph(g);
		
		long startTime = System.currentTimeMillis();
		BFS_Serial.walk(3, g);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
        System.out.println("Total execution time for current run (millis): " + totalTime);
        
        startTime = System.currentTimeMillis();
		runParallelBFS(3, numThreads, g);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
        System.out.println("Total execution time for current run (millis): " + totalTime);
	}
	
	private static void printGraph(Graph g) {
		Collections.sort(g.getCities());
		
		System.out.println("----------Directed Graph Cities & Routes----------");
		for(int city : g.getCities()) {
			System.out.print("City #" + city + " Can Reach Cities: ");
			boolean flag = false;
			
			for(int r : g.getCitiyDistenations(city)) {
				if(flag) System.out.print(" | ");
				System.out.print(r);
				
				flag = true;
			}
			
			System.out.println();
		}
	}
	
	private static void runParallelBFS(int startCity, int numThreads, Graph g) {
        Queue<Integer> cities = new LinkedBlockingQueue<>();
        Set<Integer> visited = Collections.newSetFromMap(new ConcurrentHashMap<>(g.getCities().size()));
        
		System.out.println("------------Parallel BFS Walking Tree-------------");
        System.out.println("Threads used in current run: " + numThreads);
        
        for(int city : g.getCitiyDistenations(startCity)) cities.add(city);
        
        Thread[] threads = new Thread[numThreads];
        BFS_Parallel[] tasks = new BFS_Parallel[numThreads];
        
        for(int i = 0;i < numThreads;i++) {
        	tasks[i] = new BFS_Parallel(cities, visited, startCity, g);
        	threads[i] = new Thread(tasks[i]);
        	threads[i].start();
        }

        boolean finished = false;
        int numFinished = 0;
        while(!finished) {
        	numFinished = 0;
        	for(Thread th : threads) if(th.getState() == State.TERMINATED) numFinished++;
        	
        	if(numFinished == threads.length) finished = true;
        }
	}

}
