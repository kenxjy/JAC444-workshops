package shapes;

public class Triangle implements Shape {
	private double a;
	private double b;
	private double c;
	private double height;
	
	public Triangle(double a, double b, double c, double height) throws InvalidSideException {
		if ((a <= 0 || b <= 0 || c <= 0 || height <= 0) || // valid parameters
				(a >= b + c || b >= a + c || c >= a + b)) // Triangle Inequality
			throw new InvalidSideException("Invalid side(s)!");
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.height = height;
	}
	
	public Triangle(double a, double b, double c) throws InvalidSideException {
		this(a, b, c, 1);
	}
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double perimeter() {
		return a + b + c;
	}
	
	@Override
	public String toString() {
		return String.format("Triangle {s=%s, s=%s, s=%s} perimeter = %.6g", a, b, c, perimeter());
	}
}
