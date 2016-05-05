package br.com.eloi.curiosity.modelo;

public class East implements Moviments {

	@Override
	public Direction turnRight() {
		return Direction.SOUTH;
	}

	@Override
	public Direction turnLeft() {
		return Direction.NORTH;
	}

	@Override
	public Vector move() {
		return new Vector(1, 0);
	}

}
