package mountain;

import java.util.HashMap;

import fractal.*;

public class Massiv extends Fractal {
	private Point p1; 
	private Point p2; 
	private Point p3; 
	public Double dev;
	private HashMap<Side, Point> karta;

	public Massiv(Point p1, Point p2, Point p3, double dev) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.dev = dev;
		karta = new HashMap<Side, Point>();
	}

	@Override
	public String getTitle() {
		return "Bergsfraktal";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		//turtle.moveTo(p1.getX(), p1.getY());
		fractalLine(turtle, order, p1, p2, p3, dev);
	}

	private void fractalLine(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3, Double dev) {
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY()); // Turtle använder intar, vi bör ha doubles
			turtle.penDown();
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else {
			Point old1 = p1;
			Point old2 = p2;
			Point old3 = p3;
			
			Side s1 = new Side(p1,p2);
			Side s2 = new Side(p2,p3);
			Side s3 = new Side(p3,p1);
			
			if (!karta.containsKey(s1)) {
				p1 = new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2+(int) RandomUtilities.randFunc(dev));
				karta.put(s1, p1);
			}
			else {
				p1 = karta.get(s1);
				karta.remove(s1);
			}
			
			if (!karta.containsKey(s2)) {
				p2 = new Point((p3.getX()+p2.getX())/2,(p3.getY()+p2.getY())/2+ (int) RandomUtilities.randFunc(dev));
				karta.put(s2,p2);
			}
			else {
				p2 = karta.get(s2);
				karta.remove(s2);
			}
			
			if (!karta.containsKey(s3)) {
				p3 = new Point((old1.getX()+p3.getX())/2,(old1.getY()+p3.getY())/2+(int) RandomUtilities.randFunc(dev));
				karta.put(s3,p3);
			}
			else {
				p3 = karta.get(s3);
				karta.remove(s3);
			}
			
			fractalLine(turtle,order-1,p1,p2,p3, dev/2);
			fractalLine(turtle,order-1,old1,p1,p3, dev/2);
			fractalLine(turtle,order-1,p1,old2,p2, dev/2);
			fractalLine(turtle,order-1,p3,p2,old3, dev/2);

		}
	}

}
