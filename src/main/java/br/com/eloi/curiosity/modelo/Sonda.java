package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.HashMap;
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
 
	public void move(){
		moveTo(getCurrentPosition().move());		
	}
	
	public void right() {
		moveTo(getCurrentPosition().right());				
	}

	public void left() {
		moveTo(getCurrentPosition().left());
	}

	public void drive(String moviments) {
		 
		for (char moviment : moviments.toCharArray()) {
			switch(moviment) {
				case 'L':
					this.left();
					break;
					
				case 'R':
					this.right();
					break;
					
				case 'M':
					this.move();
					break;
			}
		}
		
		Map<String, Integer> command2 = new HashMap<String, Integer>() {{
			put("L", 1);
			put("R", 5);
			put("M", 10);				
		}};

		
		 
	}

}
