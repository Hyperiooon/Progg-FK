package fractal;

import koch.Koch;
import mountain.Massiv;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		
		Point p1 = new Point(10, 400);
		Point p2 = new Point(300, 10);
		Point p3 = new Point(400, 500);
		fractals[0] = new Massiv(p1, p2, p3, 20);
		
		fractals[1] = new Koch(300);
		
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
