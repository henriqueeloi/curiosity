package br.com.eloi.curiosity.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloi.curiosity.modelo.Direction;
import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;
import br.com.eloi.curiosity.resource.PlanetResource;

@RestController("/planetas")
public class PlanetController {

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public ResponseEntity<PlanetResource> create(@RequestBody Planet planet ){						
		PlanetResource resource = new PlanetResource(planet);		
        return new ResponseEntity<PlanetResource>(resource, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/test/{id}", method=RequestMethod.GET)
	public HttpEntity<String> get(@PathVariable String id){
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public HttpEntity<PlanetResource> getPlanet(@PathVariable String name){
		
		Planet planet = new Planet();
		planet.add(new Sonda(new Position(new Vector(1,2), Direction.NORTH)));
		planet.setName(name);
		
		PlanetResource planetResource = new PlanetResource(planet);
		
		return new ResponseEntity<PlanetResource>(planetResource, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/planeta/{name}", method = RequestMethod.GET)
	public ResponseEntity<Planet> getPlaneta(@PathVariable String name){
		
		Planet planet = new Planet();
		planet.add(new Sonda(new Position(new Vector(1,2), Direction.NORTH)));
		planet.setName(name);
		
		PlanetResource planetResource = new PlanetResource(planet);
		
		return new ResponseEntity<Planet>(planet, HttpStatus.OK);		
	}
	
//	
//	 @RequestMapping("/greeting")
//	    public HttpEntity<Greeting> greeting(
//	            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//
//	        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
//	        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
//
//	        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
//	    }
}