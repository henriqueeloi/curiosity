package br.com.eloi.curiosity.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Sonda;

@Repository
public class PlanetDao {

	Map<String, Planet> planets = new HashMap<String, Planet>();
	
	public Optional<Entry<String, Planet>> getPlanetByName(String name) {
		Optional<Entry<String, Planet>> findFirst = planets.entrySet().stream()
				.filter(p -> p.getValue().getName().equalsIgnoreCase(name))
				.findFirst();
		return findFirst;
	}

	public Sonda getSondaByName(String name) {
		return planets.entrySet().stream()
				.map(Map.Entry::getValue).flatMap(s -> s.getSondas().stream())
				.filter(s -> s.getName().equalsIgnoreCase(name)).findAny()
				.orElseThrow(() -> new RuntimeException("Sonda not found!"));
	}
	
	public void salvePlanet(Planet planet) {
		planets.put(planet.getName(), planet);
	}
	
	public void salveSonda(Planet planet) {
		planets.put(planet.getName(), planet);
	}
	
	public Map<String, Planet> listPlanet(){
		return planets;
	}

	public Boolean deletePlanet(String name) {		
		return planets.entrySet().removeIf(s -> s.getKey().equalsIgnoreCase(name));
	}

	public Boolean deleteSonda(String name) {
			
		planets.entrySet().forEach(d -> {
			d.getValue().getSondas().remove(getSondaByName(name));
		});
		
		return true;
	}
	
}
