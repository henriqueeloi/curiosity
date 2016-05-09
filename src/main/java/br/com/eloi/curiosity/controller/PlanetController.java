package br.com.eloi.curiosity.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;
import br.com.eloi.curiosity.resource.PlanetResource;
import br.com.eloi.curiosity.resource.SondaResource;

@RestController
public class PlanetController {

	Map<String, PlanetResource> planets = new HashMap<String, PlanetResource>();
		
	@RequestMapping(value = "/test/{id}", method=RequestMethod.GET)
	public ResponseEntity<Vector> get(@PathVariable String id){
		
		Vector vector = new Vector(5, 5);
				
		return new ResponseEntity<Vector>(vector, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/planets/{name}", method = RequestMethod.POST)
	public HttpEntity<PlanetResource> create(@PathVariable String name, @RequestBody(required = true) Vector area){
		
		Vector newArea = area; 
		Planet planet = new Planet(name, newArea);		

		PlanetResource planetResource = new PlanetResource(planet);
		planets.put(name, planetResource);
		
		planetResource.add(linkTo(methodOn(PlanetController.class).getPlaneta(name)).withSelfRel());
		
		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/planets", method = RequestMethod.GET)
	public ResponseEntity<List<PlanetResource>> getPlanets(){
				
		List<PlanetResource> listPlanets = new ArrayList<PlanetResource>();
		
		planets.forEach((k,y) -> {						
			listPlanets.add(y);
		});
				
		return new ResponseEntity<List<PlanetResource>>(listPlanets, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/planets/{name}", method = RequestMethod.GET)
	public ResponseEntity<PlanetResource> getPlaneta(@PathVariable String name){
		
		PlanetResource planetResource = planets.get(name);
		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/planets/{planet}/sondas/{name}", method = RequestMethod.POST)
	public HttpEntity<SondaResource> createSonda(@PathVariable String planet, String name, @RequestBody Position position){

		Sonda sonda = new Sonda(name, position);
		SondaResource sondaResource = new SondaResource(sonda);

		if(planets.containsKey(planet)){
			PlanetResource planetResource = planets.get(planet);
			planetResource.getContent().add(sonda);
			planets.replace(planet, planetResource);
		}
		
		sondaResource.add(linkTo(methodOn(PlanetController.class).getPlaneta(name)).withSelfRel());
				
		return new ResponseEntity<SondaResource>(sondaResource, HttpStatus.OK);
	}
	
}