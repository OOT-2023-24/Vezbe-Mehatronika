package geometry;

import java.awt.Graphics;

public class Point extends Shape{

	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		// Tacka ce imati izgled znaka +
		g.drawLine(x-2, y, x+2, y); // Horizontalna linija
		g.drawLine(x, y-2, x, y+2); // Vertikalna linija	
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;		
	}

	@Override
	public void moveBy(int byX, int byY) {
		x+=byX;
		y+=byY;
		
	}
	
	public double distance(Point p1) {
		int dx = x - p1.x;
		int dy = y - p1.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point) o;
			return (int) (distance(new Point(0,0)) - temp.distance(new Point(0,0)));
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point temp = (Point) o;
			if(this.x == temp.getX() && this.y == temp.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return distance(new Point(x,y)) <= 3;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	

	
	
}
