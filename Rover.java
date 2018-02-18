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
	
	
	public Rover(int x, int y, Direction d) {
		this.x = x;
		this.y = y;
		this.d = d;
		direction_table[0] = Direction.N;
		direction_table[1] = Direction.E;
		direction_table[2] = Direction.S;
		direction_table[3] = Direction.W;
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
	
	public void move(String commands) {
		for (int i = 0; i < commands.length(); i++) {
			single_move(commands.charAt(i));
		}
	}
	
	//direction is 1 for forward and -1 for backward
	private void move_straight(int direction) {
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
		x = x + direction * x_change;
		y = y + direction * y_change;
	}
	
	private void single_move(char command) {
		switch (command) {
		case 'F': 
			move_straight(1);
			break;
		case 'B':
			move_straight(-1);
			break;
		case 'L':
			d = direction_table[(d.getValue() + direction_table.length - 1) % direction_table.length];
			break;
		case 'R':
			d = direction_table[(d.getValue() + direction_table.length + 1) % direction_table.length];
			break;
		default:
			System.out.println("wrong command" + command);
		}
	}

}
