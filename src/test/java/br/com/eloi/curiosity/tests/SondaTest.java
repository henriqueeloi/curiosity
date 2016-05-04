package br.com.eloi.curiosity.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.eloi.curiosity.modelo.Direction;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;

public class SondaTest {

	
	@Test
	public void deveSeguirCoordenadasPrimeiraSonda(){
		
		String inputMoviments = "LMLMLMLMM";
				
		Sonda sonda = new Sonda(new Position(new Vector(1,2), Direction.NORTH));
		
		sonda.drive(inputMoviments);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(1,3)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.NORTH));
	}
	
	@Test
	public void deveSeguirCoordenadasSegundaSonda(){
		String inputMoviments = "MMRMMRMRRM";
		
		Sonda sonda = new Sonda(new Position(new Vector(3,3), Direction.EAST));
		
		sonda.drive(inputMoviments);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(5,1)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.EAST));
	}
	
	@Test
	public void deveSeguirCoordenadasComDirecaoDiferante(){
		String inputMoviments = "RMRMLM";
		
		Sonda sonda = new Sonda(new Position(new Vector(2,2), Direction.NORTH));
		
		sonda.drive(inputMoviments);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(4,1)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.EAST));
	}
	
	
	
}