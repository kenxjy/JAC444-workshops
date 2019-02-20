import java.io.*;
import shapes.*;

public class Task1 {
	public static void main(String[] args) {
		final String fileName = args[0];
		System.out.println("------> Task 1 <------");
		try {
			LineNumberReader lnr = new LineNumberReader(new	FileReader(fileName)); 
			String s;
			// count lines
			while ((s = lnr.readLine()) != null) {}
			lnr.close();
			
			// declare new array of shapes and counter
			Shape[] shapes = new Shape[lnr.getLineNumber()];
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
			
			// print shapes
			System.out.println("\n" + cnt + " shapes were created:");
			for (int i = 0; i < cnt; ++i) {
				System.out.println(shapes[i].toString() + "\n");
			}
			
		} catch	(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
