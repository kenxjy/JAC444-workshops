package shapes;

public class Rectangle extends Square {
	private double width;
	
	public Rectangle(double width, double length) throws InvalidSideException {
		super(length);
		
		if (width <= 0)
			throw new InvalidSideException("Invalid side(s)!");
		
		this.width = width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	@Override 
	public double perimeter() {
		return (2 * width + 2 * getLength());
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle {w=%.2g, h=%.2g} perimeter = %.6g", width, getLength(), perimeter());
	}
}
