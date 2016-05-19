package br.com.eloi.curiosity.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sondas {

	private Set<Sonda> sondas = new HashSet<Sonda>();

	public void add(Sonda sonda) {
		validateExistInSamePosition(sonda);

		if (!sondas.add(sonda)) {
			throw new RuntimeException("There is a probe with same name!");
		}
	}

	private void validateExistInSamePosition(Sonda sonda) {
		sondas.stream()
		.filter(s -> s.getCurrentPosition().getCoordinate().equals(sonda.getCurrentPosition().getCoordinate()))
		.findAny().ifPresent(s -> {throw new RuntimeException("A Sonda is in this position!");});
	}

	public Collection<Sonda> getSondas() {
		return Collections.unmodifiableCollection(sondas);
	}

	public Sonda findByName(String name){
		return sondas.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(() -> new RuntimeException("Sonda not found!"));
	}

	public boolean remove(Sonda sonda){
		return sondas.remove(sonda);
	}
}
