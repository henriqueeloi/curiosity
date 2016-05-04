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
	public Moviments move() {
		// TODO Auto-generated method stub
		return null;
	}

}
