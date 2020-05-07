package _02_Advanced_Robot_Race;

import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;
public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	final static int robotCount = 5;
	static Thread[] threads = new Thread[robotCount];
	public static boolean end = false;
	public static int winner = 0;

	
	public static void main(String[] args) {
	
		
			Robot[] robot = new Robot[robotCount];
			for (int i = 0; i < robot.length; i++) {
				robot[i] = new Robot();
			}
			for (int i = 0; i < robot.length; i++) {
				robot[i].setX(100 + (i * 75));
				robot[i].setY(350);
			}

			for(int i = 0; i<robot.length; i++) {
				Robot r = robot[i];
				final int j = i;
				threads[i] = new Thread(()->race(r,j));
			}
			
			for(int i = 0; i<robot.length; i++) {
				threads[i].start();
			}
	
			// 8. try different races with different amounts of robots.

			// 9. make the robots race around a circular track.

		}
		
		static void race(Robot r, int index) {
			Random randy = new Random();
			r.setSpeed(100);
			while(!end) {
				int distance = randy.nextInt(100);
				try {
					Thread.sleep(distance);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.turn(1);
				//for(int i = 0; i<=distance; i++) {
					r.move(10+((robotCount-5-index)*2));
				//}
				if(	r.getY()<360 && r.getY()>350 && r.getX()<500) {
					end = true;
					winner = index;
				}
				
			}
			

			if(end&&(index==winner)) {

				System.out.println(winner);
				System.out.println("end");
				r.turn(720);
				JOptionPane.showMessageDialog(null, "Robot "+"#"+(winner+1)+" won!");
				r.turn(720);
			}
						
			
		}
	}