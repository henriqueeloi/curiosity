package br.com.eloi.curiosity.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.validator.internal.util.privilegedactions.GetConstraintValidatorList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloi.curiosity.modelo.Direction;
import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;
import br.com.eloi.curiosity.resource.PlanetResource;
import br.com.eloi.curiosity.resource.SondaResource;

@RestController
public class PlanetController {

	Map<String, Planet> planets = new HashMap<String, Planet>();

	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
	public ResponseEntity<Position> get(@PathVariable String id) {

		Position position = new Position(new Vector(5, 5), Direction.NORTH);

		return new ResponseEntity<Position>(position, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{name}", method = RequestMethod.POST)
	public HttpEntity<PlanetResource> create(@PathVariable String name,
			@RequestBody(required = true) Vector area) {

		Vector newArea = area;
		Planet planet = new Planet(name, newArea);

		PlanetResource planetResource = new PlanetResource(planet);
		planets.put(name, planet);

		planetResource.add(linkTo(
				methodOn(PlanetController.class).getPlaneta(name))
				.withSelfRel());

		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/planets", method = RequestMethod.GET)
	public ResponseEntity<List<PlanetResource>> getPlanets() {

		List<PlanetResource> listPlanets = new ArrayList<PlanetResource>();

		planets.forEach((k, y) -> {
			PlanetResource resource = new PlanetResource(y);
			resource.add(linkTo(methodOn(PlanetController.class).getPlaneta(k)).withSelfRel());
			listPlanets.add(resource);
		});

		
		
		return new ResponseEntity<List<PlanetResource>>(listPlanets, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{name}", method = RequestMethod.GET)
	public ResponseEntity<PlanetResource> getPlaneta(@PathVariable String name) {

		Planet planet = returnPlanetByName(name).get().getValue();

		PlanetResource planetResource = new PlanetResource(planet);
		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{planet}/sondas/{name}", method = RequestMethod.POST)
	public HttpEntity<SondaResource> createSonda(@PathVariable String planet,
			@PathVariable String name,
			@RequestBody(required = true) Position position) {

		Sonda sonda = new Sonda(name, position);
		SondaResource sondaResource = new SondaResource(sonda);

		returnPlanetByName(planet).ifPresent(p -> {
			p.getValue().add(sonda);
		});

		// if(planets.containsKey(planet)){
		// PlanetResource planetResource = planets.get(planet);
		// planetResource.getContent().add(sonda);
		// planets.replace(planet, planetResource);
		// }

		sondaResource.add(linkTo(methodOn(PlanetController.class).getSonda(name)).withSelfRel());

		return new ResponseEntity<SondaResource>(sondaResource, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/sondas/{name}", method = RequestMethod.GET)
	public ResponseEntity<SondaResource> getSonda(@PathVariable String name) {

		Optional<Sonda> findFirst = planets.entrySet().stream()
				.map(Map.Entry::getValue).flatMap(s -> s.getSondas().stream())
				.filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();

		SondaResource resource = new SondaResource(findFirst.get());
		resource.add(linkTo(methodOn(PlanetController.class).getSonda(name)).withSelfRel());
		return new ResponseEntity<SondaResource>(resource, HttpStatus.OK);
	}

	private Optional<Entry<String, Planet>> returnPlanetByName(String name) {
		Optional<Entry<String, Planet>> findFirst = planets.entrySet().stream()
				.filter(p -> p.getValue().getName().equalsIgnoreCase(name))
				.findFirst();
		return findFirst;
	}

}