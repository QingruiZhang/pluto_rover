package pluto_rover;

enum Direction {
	N, S, W, E
}

public class Rover {
	
	private int x;
	private int y;
	private Direction d;
	
	public Rover(int x, int y, Direction d) {
		this.x = x;
		this.y = y;
		this.d = d;
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
				break;
			case 'R':
				break;
			default:
				System.out.println("wrond command" + command);
		}
	}

}
