package br.com.eloi.curiosity.modelo;

public class North implements Moviments {

	@Override
	public Direction turnRight() {
		return Direction.EAST;		
	}

	@Override
	public Direction turnLeft() {
		return Direction.WEST;
	}

	@Override
	public Vector move() {
		return new Vector(0, 1);
	}

}
