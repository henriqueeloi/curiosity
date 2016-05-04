package br.com.eloi.curiosity.modelo;

public class Position {

	private Direction direction;
	private Vector vector;
	
	
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
	
	
	
}
