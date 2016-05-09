package br.com.eloi.curiosity.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Vector;

public class PlanetaTest {

	@Test
	public void deveCriarNovoPlaneta(){
		Planet planet = new Planet("Marte", new Vector(5, 5));
		
		assertThat(planet.getArea(), equalTo(new Vector(5, 5)));
	}
	
}
