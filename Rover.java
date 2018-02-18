package pluto_rover;

enum Direction {
	N(0), E(1), S(2), W(3);
	
	private int value;
	
	private Direction(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}

public class Rover {
	
	private int x;
	private int y;
	private Direction d;
	private Direction[] direction_table = new Direction[4];
	private Planet planet;
	
	
	public Rover(int x, int y, Direction d, Planet planet) {
		this.x = x;
		this.y = y;
		this.d = d;
		direction_table[0] = Direction.N;
		direction_table[1] = Direction.E;
		direction_table[2] = Direction.S;
		direction_table[3] = Direction.W;
		this.planet = planet;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return d;
	}
	
	//report any detected obstacles and stop the command sequences
	public void move(String commands) {
		for (int i = 0; i < commands.length(); i++) {
			if (!single_move(commands.charAt(i))) {
				System.out.println("encounter an obstacle when the rover is at (" + x + "," + y +") and trying to execute command " + commands.charAt(i));
				break;
			}
		}
	}
	
	//direction is 1 for forward and -1 for backward, return false if a obstacle is detected.
	private boolean move_straight(int direction) {
		
		int x_change;
		int y_change;
		
		switch(d) {
		case N:
			x_change = 0;
			y_change = 1;
			break;
		case E:
			x_change = 1;
			y_change = 0;
			break;
		case S:
			x_change = 0;
			y_change = -1;
			break;
		case W:
			x_change = -1;
			y_change = 0;
			break;
		default:
			x_change = 0;
			y_change = 0;
		}
		
		int x_check = (x + direction * x_change + planet.getX()) % planet.getX();
		int y_check = (y + direction * y_change + planet.getY()) % planet.getY();
		if (planet.has_obstacle(x_check, y_check)) {
			return false;
		}
		x = x_check;
		y = y_check;
		return true;
	}
	
	//return true if the move is valid, false if detect a obstacle
	private boolean single_move(char command) {
		switch (command) {
		case 'F': 
			return move_straight(1);
		case 'B':
			return move_straight(-1);
		case 'L':
			d = direction_table[(d.getValue() + direction_table.length - 1) % direction_table.length];
			return true;
		case 'R':
			d = direction_table[(d.getValue() + direction_table.length + 1) % direction_table.length];
			return true;
		default:
			System.out.println("wrong command" + command);
			return false;
		}
	}

}
