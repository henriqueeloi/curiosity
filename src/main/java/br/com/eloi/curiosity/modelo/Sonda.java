package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sonda {

	private String name;
	List<Position> positions = null;
	
	public String getName() {
		return name;
	}

	public Sonda() {
		positions = new ArrayList<Position>();
		newPosition(new Position(0, 0, Direction.NORTH));
	}
	
	public Sonda(Position position) {
		positions = new ArrayList<Position>();
		newPosition(position);
	}
	
	public Sonda(String name, Position position) {
		positions = new ArrayList<Position>();
		this.name = name;
		newPosition(position);
	}
	
	private void newPosition(Position position) {
		positions.add(position);
	}
		
	public Position getCurrentPosition() {		
		return positions.size() > 0 ? positions.get(positions.size()-1) : null; 
	}
 
	public void drive(List<Instruction> instructions) {		 
		newPosition(this.getCurrentPosition().change(instructions));	
	}
}
