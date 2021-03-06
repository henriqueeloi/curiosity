package br.com.eloi.curiosity.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloi.curiosity.modelo.Instruction;
import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;
import br.com.eloi.curiosity.repository.PlanetDao;
import br.com.eloi.curiosity.resource.PlanetResource;
import br.com.eloi.curiosity.resource.SondaResource;

@RestController
public class PlanetController {

	@Autowired
	PlanetDao planetDao;

	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Instruction>> get(@PathVariable String id) {

		List<Instruction> inputInstructios =
				Arrays.asList(
						Instruction.LEFT,
						Instruction.MOVE,
						Instruction.LEFT,
						Instruction.MOVE,
						Instruction.LEFT,
						Instruction.MOVE,
						Instruction.LEFT,
						Instruction.MOVE,
						Instruction.MOVE);

		return new ResponseEntity<List<Instruction>>(inputInstructios, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{name}", method = RequestMethod.POST)
	public HttpEntity<PlanetResource> create(@PathVariable String name,
			@RequestBody(required = true) Vector area) {

		Planet planet = new Planet(name, area.getX(), area.getY());

		PlanetResource planetResource = new PlanetResource(planet);

		planetDao.salvePlanet(planet);

		planetResource.add(linkTo(
				methodOn(PlanetController.class).getPlaneta(name))
				.withSelfRel());

		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/planets", method = RequestMethod.GET)
	public ResponseEntity<List<PlanetResource>> getPlanets() {

		List<PlanetResource> listPlanets = new ArrayList<PlanetResource>();

		planetDao.listPlanets().forEach(l -> {
			PlanetResource resource = new PlanetResource(l);
			resource.add(linkTo(methodOn(PlanetController.class).getPlaneta(l.getName())).withSelfRel());
			listPlanets.add(resource);
		});

		return new ResponseEntity<List<PlanetResource>>(listPlanets, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{name}", method = RequestMethod.GET)
	public ResponseEntity<? extends Object> getPlaneta(@PathVariable String name) {

		Optional<Planet> planetByName = planetDao.getPlanetByName(name);

		if(!planetByName.isPresent()){
			return ResponseEntity.notFound().build();
		}

		Planet planet = planetByName.get();

		PlanetResource planetResource = new PlanetResource(planet);
		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.OK);
	}

	@RequestMapping(value = "/planets/{name}", method = RequestMethod.DELETE)
	public HttpStatus deletePlanet(@PathVariable String name) {
		if(!planetDao.deletePlanet(name)){
			return HttpStatus.NOT_MODIFIED;
		}

		return HttpStatus.OK;
	}

	@RequestMapping(value = "/planets/{planet}/sondas/{name}", method = RequestMethod.POST)
	public HttpEntity<SondaResource> createSonda(@PathVariable String planet,
			@PathVariable String name,
			@RequestBody(required = true) Position position) {

		Sonda sonda = new Sonda(name, position);
		SondaResource sondaResource = new SondaResource(sonda);

		planetDao.getPlanetByName(planet).ifPresent(p -> {
			p.add(sonda);
		});

		sondaResource.add(linkTo(methodOn(PlanetController.class).getSonda(planet, name)).withSelfRel());

		return new ResponseEntity<SondaResource>(sondaResource, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/planets/{planet}/sondas/{name}", method = RequestMethod.GET)
	public ResponseEntity<SondaResource> getSonda(@PathVariable String name, @PathVariable String planet) {

		Sonda sondaByName = planetDao.getSondaByName(planet, name);

		SondaResource resource = new SondaResource(sondaByName);
		resource.add(linkTo(methodOn(PlanetController.class).getSonda(planet, name)).withSelfRel());
		return new ResponseEntity<SondaResource>(resource, HttpStatus.OK);
	}


	@RequestMapping(value = "/planets/{planet}/sondas/{name}", method = RequestMethod.DELETE)
	public HttpStatus deleteSonda(@PathVariable String name, @PathVariable String planet) {

		if(!planetDao.deleteSonda(planet, name)){
			return HttpStatus.NOT_MODIFIED;
		}

		return HttpStatus.OK;
	}

	@RequestMapping(value = "/planets/{planet}/sondas/{name}/instructions", method = RequestMethod.POST)
	public ResponseEntity<SondaResource> sendInstructions(@PathVariable String name, @PathVariable String planet,
			@RequestBody(required = true) List<Instruction> instructions) {

		Sonda sondaByName = planetDao.getSondaByName(planet, name);
		sondaByName.exec(instructions);

		SondaResource resource = new SondaResource(sondaByName);

		return new ResponseEntity<SondaResource>(resource, HttpStatus.OK);
	}

}