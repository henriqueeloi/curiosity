package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Sonda {

	List<Position> positions = null;

	public Sonda() {
		positions = new ArrayList<Position>();
		moveTo(new Position(new Vector(0,0), Direction.NORTH));
	}
	
	public Sonda(Position position) {
		positions = new ArrayList<Position>();
		moveTo(position);
	}
	
	private void moveTo(Position position) {
		positions.add(position);
	}
		
	public Position getCurrentPosition() {		
		return positions.size() > 0 ? positions.get(positions.size()-1) : null; 
	}
 
	public void drive(List<Instruction> instructions) {		 
						
		instructions.stream().forEach(item -> {
			if(item.equals(Instruction.LEFT)){
				moveTo(getCurrentPosition().left());
			}else if(item.equals(Instruction.RIGHT)){
				moveTo(getCurrentPosition().right());
			}else if(item.equals(Instruction.MOVE)){
				moveTo(getCurrentPosition().move());
			}
		});
		
	}
}
