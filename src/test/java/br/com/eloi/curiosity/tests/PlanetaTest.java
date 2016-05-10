package br.com.eloi.curiosity.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import br.com.eloi.curiosity.modelo.Direction;
import br.com.eloi.curiosity.modelo.Planet;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;

public class PlanetaTest {

	@Test
	public void deveCriarNovoPlaneta(){
		Planet planet = new Planet("Marte", 5, 5);
		
		assertThat(planet.getArea(), equalTo(new Vector(5, 5)));
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveAdicionarSondaNaMesmaPosicao(){
		Planet planet = new Planet("Marte", 5, 5);
		
		planet.add(new Sonda(new Position(1, 2, Direction.EAST)));
		planet.add(new Sonda(new Position(1, 2, Direction.EAST)));				
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveAdicionarSondaComMesmoNome(){
		Planet planet = new Planet("Marte", 5, 5);
		
		planet.add(new Sonda("sonda1", new Position(1, 2, Direction.EAST)));
		planet.add(new Sonda("sonda1", new Position(1, 2, Direction.EAST)));				
	}
	
}
