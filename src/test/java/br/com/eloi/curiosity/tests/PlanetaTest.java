//package br.com.eloi.curiosity.tests;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasItem;
//
//import org.junit.Test;
//
//import br.com.eloi.curiosity.modelo.Planet;
//import br.com.eloi.curiosity.modelo.Sonda;
//
//public class PlanetaTest {
//	
//	@Test
//	public void deveSeguirCoordenadas(){
//		Planet planet = new Planet();
//		Sonda sonda = new Sonda();
//		sonda.left().move();
//		planet.add(sonda);
//	}
//	
//	@Test
//	public void deveAdicionarNovaSonda(){
//		Planet marte = new Planet();
//		Sonda sonda = new Sonda();
//		sonda.right(20);
//		
//		marte.add(sonda);				
//		assertThat(marte.getSondas(), hasItem(sonda));
//	}
//	
//	@Test(expected = RuntimeException.class)
//	public void deveValidarSeJaExisteSondaNaMesmaPosicao(){
//		Planet marte = new Planet();
//		Sonda sonda = new Sonda();
//		sonda.right(10).moveUp(20);
//		
//		Sonda sonda2 = new Sonda();
//		sonda2.right(10).moveUp(20);
//		
//		marte.add(sonda);
//		marte.add(sonda2);
//	}
//	
//}
