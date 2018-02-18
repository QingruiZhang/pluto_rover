package pluto_rover;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoverTest {
	
	final Planet plain_planet = new Planet(100, 100, null);
	
	@Test
	public void moveForwardOnce() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("F");
		assertEquals("move forward once", rover.getY(), 1);
	}
	
	@Test
	public void moveBackwardOnce() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("B");
		assertEquals("move backward once", rover.getY(), 99);
	}
	
	@Test
	public void turnRightOnce() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("R");
		assertEquals("turn right once", rover.getX(), 0);
		assertEquals("turn right once", rover.getY(), 0);
		assertEquals("turn right once", rover.getDirection(), Direction.E);
	}
	
	@Test
	public void turnRightAndLeft() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("RL");
		assertEquals("turn right and left", rover.getX(), 0);
		assertEquals("turn right and left", rover.getY(), 0);
		assertEquals("turn right and left", rover.getDirection(), Direction.N);
	}
	
	@Test
	public void turnRightAndMove() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("RF");
		assertEquals("turn right and move", rover.getX(), 1);
		assertEquals("turn right and move", rover.getY(), 0);
		assertEquals("turn right and move", rover.getDirection(), Direction.E);
	}
	
	@Test
	public void turnFFRFF() {
		Rover rover = new Rover(0,0,Direction.N, plain_planet);
		rover.move("FFRFF");
		assertEquals("turn FFRFF", rover.getX(), 2);
		assertEquals("turn FFRFF", rover.getY(), 2);
		assertEquals("turn FFRFF", rover.getDirection(), Direction.E);
	}
	
	@Test
	public void moveToTheOtherSide() {
		Rover rover = new Rover(0,99,Direction.N, plain_planet);
		rover.move("F");
		assertEquals("turn F from 99", rover.getX(), 0);
		assertEquals("turn F from 99", rover.getY(), 0);
		assertEquals("turn F from 99", rover.getDirection(), Direction.N);
	}
}
