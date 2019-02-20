import java.io.*;
import shapes.*;

public class Tasks {
	// task1: reads the file and adds them all to an array then return the array
	public static Shape[] getShapes(String fileName) {
		Shape[] shapes = null;
		try {
			LineNumberReader lnr = new LineNumberReader(new	FileReader(fileName)); 
			String s;
			// count lines
			while ((s = lnr.readLine()) != null) {}
			lnr.close();
			
			// declare new array of shapes and counter
			shapes = new Shape[lnr.getLineNumber()];
			int cnt = 0;
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			// build shapes
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				
				try {
					switch (tokens[0]) { 
						case "Circle": 
							if (tokens.length == 2) {
								shapes[cnt] = new Circle(Double.parseDouble(tokens[1]));
								++cnt;
							} 
							break;
						case "Triangle":
							if (tokens.length == 4) {
								shapes[cnt] = new Triangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
								++cnt;
							} 
							break;
						case "Square":
							if (tokens.length == 2) {
								shapes[cnt] = new Square(Double.parseDouble(tokens[1]));
								++cnt;
							} 
							break;
						case "Rectangle":
							if (tokens.length == 3) {
								shapes[cnt] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
								++cnt;
							}
							break;
						case "Parallelogram":
							if (tokens.length == 3) {
								shapes[cnt] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
								++cnt;
							}
							break;
					}
				}
				catch (InvalidSideException e) {
					System.out.println(e.getMessage());
				}
			}
			
			br.close();
			System.out.println("\n" + cnt + " shapes were created:");
			
		} catch	(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return shapes;
	}
	
	public static void printShapes(Shape[] shapes) {
		for (int i = 0; i < shapes.length; ++i) {
			if (shapes[i] != null) 
				System.out.println(shapes[i].toString() + "\n");
		}
	}
	
	// finds triangle with the lowest perimeter and the circle with the highest perimeter.
	// then removes them from the array
	public static void task2(Shape[] shapes) {
		double lowest = -1;
		double highest = -1;
		
		// find lowest and highest
		for (int i = 0; i < shapes.length; ++i) {
			if (shapes[i] != null) {
				if (shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if (shapes[i].perimeter() < lowest || lowest == -1)
						lowest = shapes[i].perimeter();
				} else if (shapes[i].getClass().getSimpleName().equals("Circle")) {
					if (shapes[i].perimeter() > highest)
						highest = shapes[i].perimeter();
				}
			}
		}
		
		// remove lowest and highest
		for (int i = 0; i < shapes.length; ++i) {
			if (shapes[i] != null) {
				if (shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if (shapes[i].perimeter() == lowest)
						shapes[i] = null;
				} else if (shapes[i].getClass().getSimpleName().equals("Circle")) {
					if (shapes[i].perimeter() == highest) 
						shapes[i] = null;
				}
			}
		}
	}
	
	// finds the total perimeter of parallelograms and triangles
	public static void task3(Shape[] shapes) {
		double totalParallelogram = 0;
		double totalTriangle = 0;
		
		for (Shape shape : shapes) {
			if (shape != null)
				if (shape.getClass().getSimpleName().equals("Triangle")) {
					totalTriangle += shape.perimeter();
				} else if (shape.getClass().getSimpleName().equals("Parallelogram")) {
					totalParallelogram += shape.perimeter();
				}
		}
		
		System.out.println("Total perimeter of Parallelogram is: " + totalParallelogram);
		System.out.println("Total perimeter of Triangle is: " + totalTriangle);
	}
	
	public static void main(String[] args) {
		final String fileName = args[0];
		
		// get shapes from file and print them
		System.out.println("------> Task 1 <------");
		Shape[] shapes = getShapes(fileName);
		printShapes(shapes);
		
		// remove triangles with the lowest perimeter and circles with the highest perimeter
		System.out.println("\n------> Task 2 <------");
		task2(shapes);
		printShapes(shapes);
		
		// find total perimeter of parallelograms and triangles
		System.out.println("\n------> Task 3 <------");
		task3(shapes);
	}
}
