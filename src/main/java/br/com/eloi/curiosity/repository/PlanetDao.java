package br.com.eloi.curiosity.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Sonda;

@Repository
public class PlanetDao {

	Map<String, Planet> planets = new HashMap<String, Planet>();

	public Optional<Planet> getPlanetByName(String name) {
		Optional<Planet> planet = planets.values().stream()
				.filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
		return planet;
	}

	public void salvePlanet(Planet planet) {
		planets.put(planet.getName(), planet);
	}

	public void salveSonda(Planet planet) {
		planets.put(planet.getName(), planet);
	}

	public Collection<Planet> listPlanets() {
		return Collections.unmodifiableCollection(planets.values());
	}

	public Boolean deletePlanet(String name) {
		return planets.entrySet().removeIf(
				s -> s.getKey().equalsIgnoreCase(name));
	}

	public Boolean deleteSonda(String planetName, String name) {

		boolean isRemove = false;

		Optional<Planet> planetByName = getPlanetByName(planetName);

		if (planetByName.isPresent()) {
			isRemove = planetByName.get().removeSonda(getSondaByName(planetName, name));
		}

		return isRemove;
	}

	public Sonda getSondaByName(String planetName, String name) {
		Optional<Planet> planet = getPlanetByName(planetName);
		return planet.get().getSondas().findByName(name);
	}

}
