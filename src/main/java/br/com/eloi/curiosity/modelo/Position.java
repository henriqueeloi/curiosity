package br.com.eloi.curiosity.modelo;

public class Position {

	private Direction direction;
	private Vector vector;
	
	public Position() {
	}
	
	public Position(Vector vector, Direction direction) {
		this.vector=vector;
		this.direction = direction;
	}
	
	public Direction getDirection(){
		return direction;
	}

	public Vector getCoordinate(){
		return this.vector;
	}

	public Position right(){
		return new Position(vector, this.getDirection().getMoviment().turnRight());
	}

	public Position left() {
		return new Position(vector, this.getDirection().getMoviment().turnLeft());
	}

	public Position move() {
		return new Position(this.getDirection().getMoviment().move(vector), this.getDirection());
	}
	
}
