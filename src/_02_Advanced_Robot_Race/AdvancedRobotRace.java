package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;
public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static Thread[] threads = new Thread[5];
	
	public static void main(String[] args) {

			Robot[] robot = new Robot[5];
			for (int i = 0; i < robot.length; i++) {
				robot[i] = new Robot();
			}
			for (int i = 0; i < robot.length; i++) {
				robot[i].setX(300 - (i * 50));
				robot[i].setY(290);
				robot[i].setSpeed(255);
			}

			for(int i = 0; i<robot.length; i++) {
				Robot r = robot[i];
				final int j = i;
				threads[i] = new Thread(()->race(r,j));
			}
			
			for(int i = 0; i<robot.length; i++) {
				threads[i].start();
			}
	
			for (int i = 0; i < robot.length; i++) {
				if (robot[i].getY() <= 0) {
					int b = i + 1;
					JOptionPane.showMessageDialog(null, "Robot " + b + " wins!!!!!!");
				}
			}
			// 8. try different races with different amounts of robots.

			// 9. make the robots race around a circular track.

		}
		
		static void race(Robot r, int index)  {
			Random randFactory = new Random();
			int randy = randFactory.nextInt(50);
			r.setSpeed((index*50)+1);

			boolean finished = false;			
			while (finished == false) {
				//for (int i = 0; i < r.length; i++) {
					for (int x = 0; x < randy; x++) {

						//r.setSpeed((index*20)+1);
						
						  try {
							Thread.sleep((5-index)*17+randFactory.nextInt(100));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(int z = 0; z<=index;z++) {
						r.move(1);
						if (r.getY() == 290 && r.getX() == 300 - (index * 50)) {
							finished = true;
							//i = r.length;
							x=randy;
							z=index+1;
							break;
							
						}
						}
					if(!finished) {
					r.turn(1);
					randy = randFactory.nextInt(200)+50;
					}
//				try {
//					Thread.sleep(25);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
					
					}
				//}

			}

			
			
		}
	}