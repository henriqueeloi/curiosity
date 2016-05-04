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

 
	public Sonda move(){
		
		if(getCurrentPosition().getDirection().equals(Direction.NORTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate().move(0, 1), getCurrentPosition().getDirection()));
		}
		if(getCurrentPosition().getDirection().equals(Direction.SOUTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate().move(0, -1), getCurrentPosition().getDirection()));
		}
		if(getCurrentPosition().getDirection().equals(Direction.EAST)){
			moveTo(new Position(getCurrentPosition().getCoordinate().move(1, 0), getCurrentPosition().getDirection()));
		}
		if(getCurrentPosition().getDirection().equals(Direction.WEST)){
			moveTo(new Position(getCurrentPosition().getCoordinate().move(-1, 0), getCurrentPosition().getDirection()));
		}
		
		return this;
	}
	
	public void right() {
		Direction direction = getCurrentPosition().getDirection().getMoviment().turnRight();		
		moveTo(new Position(getCurrentPosition().getCoordinate(),  direction));
	}

	public void left() {
		Direction direction = getCurrentPosition().getDirection().getMoviment().turnLeft();		
		moveTo(new Position(getCurrentPosition().getCoordinate(),  direction));
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
