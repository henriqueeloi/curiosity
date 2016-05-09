package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sonda {

	private String name;
	
	public String getName() {
		return name;
	}

	List<Position> positions = null;

	public Sonda() {
		positions = new ArrayList<Position>();
		newPosition(new Position(new Vector(0,0), Direction.NORTH));
	}
	
	public Sonda(Position position) {
		positions = new ArrayList<Position>();
		newPosition(position);
	}
	
	public Sonda(String name, Position position) {
		this.name = name;
		positions = new ArrayList<Position>();
		newPosition(position);
	}
	
	private void newPosition(Position position) {
		positions.add(position);
	}
		
	public Position getCurrentPosition() {		
		return positions.size() > 0 ? positions.get(positions.size()-1) : null; 
	}
 
	public void drive(List<Instruction> instructions) {		 
						
		instructions.stream().forEach(item -> {
			if(item.equals(Instruction.LEFT)){
				moveToLeft();
			}else if(item.equals(Instruction.RIGHT)){
				moveToRight();
			}else if(item.equals(Instruction.MOVE)){
				moveForward();
			}
		});
		
	}

	private void moveForward() {
		newPosition(getCurrentPosition().move());
	}

	private void moveToRight() {
		newPosition(getCurrentPosition().right());
	}

	private void moveToLeft() {
		newPosition(getCurrentPosition().left());
	}
}
