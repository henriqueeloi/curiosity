package br.com.eloi.curiosity.modelo;

public enum Direction {

	NORTH(new North()), 
	EAST(new East()), 
	SOUTH(new South()), 
	WEST(new West());

	private final Moviments moviments;
	
	private Direction(Moviments moviments) {
		this.moviments=moviments;
	}
	
	public Moviments getMoviment() {
		return moviments;
	}

	public Direction turnLeft() {
		return this.moviments.turnLeft();
	}

	public Direction turnRight() {
		return this.moviments.turnRight();
	}

	public Vector move(Vector coordinate) {
		return this.moviments.move(coordinate);
	}
}
