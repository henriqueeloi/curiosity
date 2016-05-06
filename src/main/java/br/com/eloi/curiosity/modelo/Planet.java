package br.com.eloi.curiosity.modelo;

import java.util.ArrayList;
import java.util.List;

public class Planet {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	List<Sonda> sondas = null;
	
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
