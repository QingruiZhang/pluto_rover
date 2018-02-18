package pluto_rover;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoverTest {
	
	@Test
	public void moveForwardOnce() {
		Rover rover = new Rover(0,0,Direction.N);
		rover.move("F");
		assertEquals("move forward once", rover.getY(), 1);
	}
}
