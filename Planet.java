package pluto_rover;

public class Planet {
	
	private int x_size;
	private int y_size;
	private boolean[][] map;

	public Planet(int x_size, int y_size, int[][] obstacles) {
		this.x_size = x_size;
		this.y_size = y_size;
		map = new boolean[x_size][y_size];
		if (obstacles != null) {
			for (int[] obstacle : obstacles) {;
				assert (obstacle.length == 2); //every obstacle should has only 2 value: x and y coordinate
				int x = obstacle[0];
				int y = obstacle[1];
				assert (0 <= x && 0 <= y && x < x_size && y < y_size); //obstacle must be on the planet
				map[x][y] = true;
			}
		}
	}
	
	public int getX() {
		return x_size;
	}
	
	public int getY() {
		return y_size;
	}
	
	public boolean has_obstacle(int x, int y) {
		assert(0 <= x && 0 <= y && x < x_size && y < y_size);
		return map[x][y];
	}
}
