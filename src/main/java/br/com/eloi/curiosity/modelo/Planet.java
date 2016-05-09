package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;

public class Planet {
	
	private String name;	
	private Vector area;
	List<Sonda> sondas = null;
	
	public Vector getArea() {
		return area;
	}
	
	public String getName() {
		return name;
	}
	
	public Planet(String name, Vector area){
		this.name = name;
		this.area=area;
		sondas = new ArrayList<Sonda>();
	}
	
	public Planet() {
		sondas = new ArrayList<Sonda>();
	}
	
	public void add(Sonda sonda){
		validadeExistInSamePosition(sonda);
		
		sondas.add(sonda);
	}


	public List<Sonda> getSondas() {
		return sondas;
	}
	
	private void validadeExistInSamePosition(Sonda sonda) {
		sondas.stream()
		.filter(s -> s.getCurrentPosition().equals(sonda.getCurrentPosition()))
		.findAny().ifPresent(s -> {throw new RuntimeException("A Sonda is in this position!");});
	}
}
