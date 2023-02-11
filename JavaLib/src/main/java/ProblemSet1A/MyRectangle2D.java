package ProblemSet1A;

public class MyRectangle2D {
	private double x, y;
	private double width, height;

	MyRectangle2D() {
		x = 0;
		y = 0;
		width = 1;
		height = 1;
	}

	MyRectangle2D(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return 2 * (width + height);
	}

	public double getLeftEdge() {
		return this.x - (width/2);
	}

	public double getRightEdge() {
		return this.x + (width/2);
	}

	public double getTopEdge() {
		return this.y + (height/2);
	}

	public double getBottomEdge() {
		return this.y - (height/2);
	}

	public boolean contains(double x, double y) {
		return (x > getLeftEdge() && x < getRightEdge()) && (y > getBottomEdge() && y < getTopEdge());
	}

	public boolean contains(MyRectangle2D r) {
		return contains(r.getLeftEdge(), r.getTopEdge()) && contains(r.getRightEdge(), r.getBottomEdge());
	}

	public boolean overlaps(MyRectangle2D r) {
		return contains(r.getLeftEdge(), r.getTopEdge()) ||
				contains(r.getRightEdge(), r.getBottomEdge()) ||
				contains(r.getLeftEdge(), r.getBottomEdge()) ||
				contains(r.getRightEdge(), r.getTopEdge()) ||
				r.contains(this);
	}
}
