package shapes;

public class Parallelogram extends Rectangle {
	private double height;
	
	public Parallelogram(double width, double length, double height) throws InvalidSideException {
		super(width, length);
		
		if (height <= 0) 
			throw new InvalidSideException("Invalid height!");
				
		this.height = height;
	}
	
	public Parallelogram(double length, double width) throws InvalidSideException {
		this(length, width, 1);
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return String.format("Parallelogram {w=%s, h=%s} perimeter = %.6g", getWidth(), getLength(), perimeter());
	}
}
