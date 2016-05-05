package br.com.eloi.curiosity.modelo;

public class West implements Moviments {

	@Override
	public Direction turnRight() {
		return Direction.NORTH;
	}

	@Override
	public Direction turnLeft() {
		return Direction.SOUTH;
	}

	@Override
	public Vector move(Vector coordinate) {
		return coordinate.add(-1, 0);
	}

}
