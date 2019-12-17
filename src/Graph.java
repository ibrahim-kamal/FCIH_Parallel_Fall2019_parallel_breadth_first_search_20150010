import java.util.ArrayList;

public class Graph {
	private ArrayList<Integer> cities;
	private ArrayList<Pair> routes;
	
	Graph(){
		this.cities = new ArrayList<Integer>();
		this.routes = new ArrayList<Pair>();
	}
	
	public void addRoute(int f, int t) {
		if(!this.cities.contains(f)) this.cities.add(f);
		if(!this.cities.contains(t)) this.cities.add(t);
		
		for(Pair r : this.routes)
			if((r.first == f && r.second == t) || (r.first == t && r.second == f))
				return ;
				
		this.routes.add(new Pair(f, t));
	}
	
	public ArrayList<Integer> getCities() {
		return this.cities;
	}
	
	public ArrayList<Pair> getRoutes() {
		return this.routes;
	}
	
	public ArrayList<Integer> getCitiyDistenations(int cityId) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		for(Pair r : this.routes)
			if(r.first == cityId) c.add(r.second);
			else if(r.second == cityId) c.add(r.first);
		
		return c;
	}
	
}
