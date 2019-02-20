package shapes;

public class Square implements Shape {
	private double length;
	
	public Square(double length) throws InvalidSideException {
		if (length <= 0) 
			throw new InvalidSideException("Invalid side!");
		
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public double perimeter() {
		return 4 * length;
	}
	
	@Override
	public String toString() {
		return String.format("Square {s=%s} perimeter = %.6g", length, perimeter());
	}
}
