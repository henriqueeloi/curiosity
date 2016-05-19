package br.com.eloi.curiosity.modelo;


public class Position {

	Direction direction;
	private Vector coordinate;

	public Position() {
	}

	public Position(int x, int y, Direction direction) {
		this.coordinate = new Vector(x, y);
		this.direction = direction;
	}

	public Position(Vector coordinate, Direction direction) {
		this.coordinate = coordinate;
		this.direction = direction;
	}

	public Direction getDirection(){
		return direction;
	}

	public Vector getCoordinate(){
		return this.coordinate;
	}

	public Position turnLeft() {
		return new Position(coordinate, direction.turnLeft());
	}

	public Position turnRight() {
		return new Position(coordinate, direction.turnRight());
	}

	public Position move() {
		return new Position(direction.move(coordinate), direction);
	}
}
