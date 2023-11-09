package geometry;

public class Line {

	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint,boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	@Override
	public String toString() {
		return "(" + startPoint.getX() + "," + startPoint.getY() + ")"
				+ "---> (" + endPoint.getX() + "," + endPoint.getY() + ")";  
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Line) {
			Line temp = (Line) o;
			if(startPoint.equals(temp.getStartPoint()) && endPoint.equals(temp.getEndPoint())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (length() - startPoint.distance(new Point(x,y)) - 
				endPoint.distance(new Point(x,y))) <= 3;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
