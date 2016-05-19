package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sonda {

	private String name;
	private List<Position> positions = null;

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

	public String getName() {
		return name;
	}

	private void newPosition(Position position) {
		positions.add(position);
	}

	public Position getCurrentPosition() {
		return positions.size() > 0 ? positions.get(positions.size()-1) : null;
	}

	public void exec(List<Instruction> instructions) {

		for (Instruction item : instructions) {

			item.execute(this);
		}

	}

	public void moveToLeft() {
		newPosition(getCurrentPosition().turnLeft());
	}

	public void moveToRight() {
		newPosition(getCurrentPosition().turnRight());
	}

	public void move() {
		newPosition(getCurrentPosition().move());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sonda) {
			Sonda that = (Sonda) obj;
			return name.equals(that.name);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
