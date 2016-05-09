package br.com.eloi.curiosity.modelo;

public class Vector {
	private int x;
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Vector() {
	}
	
	public Vector(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Vector add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!(obj instanceof Vector))
			return false;
		
		final Vector other = (Vector) obj;
		
		return getX() == other.x && getY() == other.y;
		
	}
}
