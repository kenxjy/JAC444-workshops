package shapes;

public class Circle implements Shape {
	private double radius;
	
	public Circle(double radius) throws InvalidSideException {
		if (radius <= 0) 
			throw new InvalidSideException("Invalid radius!");
		
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double perimeter() {
		return 2 * radius * Math.PI;
	}	
	
	@Override
	public String toString() {
		return String.format("Circle {r=%s} perimeter = %.6g", radius, perimeter());
	}
}
