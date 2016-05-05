package br.com.eloi.curiosity.modelo;

public class South implements Moviments {

	@Override
	public Direction turnRight() {
		return Direction.WEST;
	}

	@Override
	public Direction turnLeft() {
		return Direction.EAST;
	}

	@Override
	public Vector move() {
		return new Vector(0, -1);
	}

}
