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
	
	private void single_move(char command) {
		switch (command) {
			case 'F': 
				y++;
				break;
			case 'B':
				y--;
				break;
			case 'L':
				d = direction_table[(d.getValue() + direction_table.length - 1) % direction_table.length];
				break;
			case 'R':
				d = direction_table[(d.getValue() + direction_table.length + 1) % direction_table.length];
				break;
			default:
				System.out.println("wrond command" + command);
		}
	}

}
