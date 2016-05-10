package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Planet {
	
	private String name;	
	private Vector area;
	Collection<Sonda> sondas = null;
	
	public Vector getArea() {
		return area;
	}
	
	public String getName() {
		return name;
	}
	
	public Planet(String name, int x, int y){
		this.area= new Vector(x, y);
		this.name = name;
		sondas = new HashSet<Sonda>();
	}
	
	public Planet() {
		sondas = new HashSet<Sonda>();
	}
	
	public void add(Sonda sonda){
		validateExistInSamePosition(sonda);
		validateSondaSameName(sonda);
		
		sondas.add(sonda);
	}

	private void validateSondaSameName(Sonda sonda) {
		sondas.stream().filter(s -> s.getName().equals(sonda.getName()))
		.findAny().ifPresent(s -> {throw new RuntimeException("There is a probe with same name!");});
	}

	public Collection<Sonda> getSondas() {
		return sondas;
	}
	
	private void validateExistInSamePosition(Sonda sonda) {
		sondas.stream()
		.filter(s -> s.getCurrentPosition().getCoordinate().equals(sonda.getCurrentPosition().getCoordinate()))
		.findAny().ifPresent(s -> {throw new RuntimeException("A Sonda is in this position!");});
	}
	
	
}
