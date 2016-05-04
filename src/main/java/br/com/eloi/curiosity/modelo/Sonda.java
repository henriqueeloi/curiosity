package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;

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
	
	public Sonda right() {
	
		if(getCurrentPosition().getDirection().equals(Direction.NORTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.EAST));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.EAST)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.SOUTH));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.SOUTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.WEST));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.WEST)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.NORTH));
			return this;
		}
		
		return this;
	}

	public Sonda left() {
		if(getCurrentPosition().getDirection().equals(Direction.NORTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.WEST));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.WEST)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.SOUTH));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.SOUTH)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.EAST));
			return this;
		}
		if(getCurrentPosition().getDirection().equals(Direction.EAST)){
			moveTo(new Position(getCurrentPosition().getCoordinate(), Direction.NORTH));
			return this;
		}
		
		return this;
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
		
		 
	}

}
