package pluto_rover;

public class Planet {
	
	private int x_size;
	private int y_size;
	private boolean[][] map;
	
	public Planet(int x_size, int y_size, int[][] obstacles) {
		this.x_size = x_size;
		this.y_size = y_size;
	}
	
	public int getX() {
		return x_size;
	}
	
	public int getY() {
		return y_size;
	}
}
