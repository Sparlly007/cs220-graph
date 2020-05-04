package graph;
public class Path implements Comparable<Path>
{
  private String dst;
  int cost;

  public Path(String dst, int cost){
    this.dst = dst;
    this.cost = cost;
  }
  
  public String getNode() {
	  return dst;
  }
  
  public Integer getCost() {
	  return cost;
  }

  public int compareTo(Path other){
    return this.cost - other.cost;
  }

  public String toString(){
    return this.dst + " with cost "+this.cost;
  }
}