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

//	@Test
//	public void deveMoverParaDireita() {
//		Sonda sonda = new Sonda();
//		sonda.moveRight(20);		
//	}
	
	@Test
	public void deveSeguirCoordenadas(){
		
		String moviments = "LMLMLMLMM";
				
		Sonda sonda = new Sonda(new Position(new Vector(1,2), Direction.NORTH));
		
		sonda.drive(moviments);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(1,3)));
	}
	
//	@Test
//	public void validarDirecaoDiferente(){
//		Sonda sonda = new Sonda().moveRight(20);
//		
//		assertThat(sonda.getCurrentPosition(), not(new Position(30, 0)));
//	}
//	
//	@Test
//	public void deveMoverParaCima(){
//		Sonda sonda = new Sonda();
//		sonda.moveUp(10);
//	
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(0, 10)));
//	}
//	
//	@Test
//	public void deveMoverParaDiretaEparaCima(){
//		Sonda sonda = new Sonda();
//		sonda.moveRight(20)
//		.moveUp(10);
//		
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(20, 10)));
//	}
//	
//	@Test
//	public void deveMoverParaBaixo(){
//		Sonda sonda = new Sonda();
//		sonda.moveDown(40);
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(0, -40)));
//	}
//	
//	@Test
//	public void deveMoverParaDireitaEparaBaixo(){
//		Sonda sonda = new Sonda();
//		sonda.moveRight(15).moveDown(40);
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(15, -40)));
//	}
//	
//	@Test
//	public void deveMoverParaEsquerda(){
//		Sonda sonda = new Sonda();
//		sonda.moveLeft(20);
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(-20, 0)));
//	}
//	
//	@Test
//	public void deveMoverParaEsquerdaEparaCima(){
//		Sonda sonda = new Sonda();
//		sonda.moveLeft(20)
//		.moveUp(10);
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(-20, 10)));
//	}
//	
//	@Test
//	public void deveMoverParaEsquerdaEparaBaixo(){
//		Sonda sonda = new Sonda();
//		sonda.moveLeft(20)
//		.moveDown(10);
//		assertThat(sonda.getCurrentPosition(), equalTo(new Position(-20, -10)));
//	}
	
	
}