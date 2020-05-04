package graph;
public class Path2 implements Comparable<Path2>
{
  private String source;
  private String dst;
  private int cost;

  public Path2(String source, String dst, int cost){
	this.source = source;
    this.dst = dst;
    this.cost = cost;
  }
  
  public String getSource() {
	  return source;
  }
  
  public String getDest() {
	  return dst;
  }
  
  public Integer getCost() {
	  return cost;
  }

  public int compareTo(Path2 other){
    return this.cost - other.cost;
  }

  public String toString(){
    return this.dst + " with cost "+this.cost;
  }
}