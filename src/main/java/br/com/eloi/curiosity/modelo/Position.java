package br.com.eloi.curiosity.modelo;

import java.util.List;

public class Position {

	private Direction direction;
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

	public Position change(List<Instruction> instructions) {
				
		for (Instruction item : instructions) {
			if(item.equals(Instruction.LEFT)){
				this.direction = direction.getMoviment().turnLeft();				
			}else if(item.equals(Instruction.RIGHT)){
				this.direction = direction.getMoviment().turnRight();
			}else if(item.equals(Instruction.MOVE)){
				this.coordinate = direction.getMoviment().move(coordinate);
			}
		}
				
		return this;				
	}	
}
