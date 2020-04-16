package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	
	public static void main(String[] args) {
		
	
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
		Robot ring1 = new Robot(300, 700);
		Robot ring2 = new Robot(900, 700);
	 Robot ring3 = new Robot(0, 400);
	 Robot ring4 = new Robot(600, 400);
	 Robot ring5 = new Robot(1200, 400);
	

	ring1.setSpeed(15);
	ring2.setSpeed(15);
	ring3.setSpeed(15);
	ring4.setSpeed(15);
	ring5.setSpeed(15);
	
	ring1.penDown();
	ring2.penDown();
	ring3.penDown();
	ring4.penDown();
	ring5.penDown();

	ring1.setPenWidth(10);
	ring2.setPenWidth(10);
	ring3.setPenWidth(10);
	ring4.setPenWidth(10);
	ring5.setPenWidth(10);
	
	ring1.setPenColor(Color.YELLOW);
	ring2.setPenColor(Color.GREEN);
	ring3.setPenColor(Color.BLUE);
	ring4.setPenColor(Color.BLACK);
	ring5.setPenColor(Color.RED);
	
	Thread thread1 = new Thread(()->circle(ring1, 400));
	Thread thread2 = new Thread(()->circle(ring2, 400));
	Thread thread3 = new Thread(()->circle(ring3, 400));
	Thread thread4 = new Thread(()->circle(ring4, 400));
	Thread thread5 = new Thread(()->circle(ring5, 400));
	
	thread1.start();
	thread2.start();
	thread3.start();
	thread4.start();
	thread5.start();
	}
	public static void circle(Robot ring, int diameter) {
		for(int i = 0; i<360; i++) {
			ring.move((int) (5));
			ring.turn(1);
		}
		ring.hide();
		
	}
	
	
}

