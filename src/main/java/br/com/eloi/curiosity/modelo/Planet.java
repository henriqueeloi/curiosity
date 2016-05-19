package br.com.eloi.curiosity.modelo;


public class Planet {

	private String name;

	private Vector area;

	private Sondas sondas;

	public Vector getArea() {
		return area;
	}

	public String getName() {
		return name;
	}

	public Planet(String name, int x, int y){
		this.area= new Vector(x, y);
		this.name = name;
		sondas = new Sondas();
	}

	public Planet() {
		sondas = new Sondas();
	}

	public void add(Sonda sonda){
		sondas.add(sonda);
	}

	public Sondas getSondas() {
		return sondas;
	}

	public boolean removeSonda(Sonda sonda) {
		return sondas.remove(sonda);
	}

}
