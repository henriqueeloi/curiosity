package br.com.eloi.curiosity.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.eloi.curiosity.modelo.Direction;
import br.com.eloi.curiosity.modelo.Instruction;
import br.com.eloi.curiosity.modelo.Position;
import br.com.eloi.curiosity.modelo.Sonda;
import br.com.eloi.curiosity.modelo.Vector;

public class SondaTest {

	
	@Test
	public void deveSeguirCoordenadasPrimeiraSonda(){
		
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
						
		Sonda sonda = new Sonda(new Position(1, 2, Direction.NORTH));
		
		sonda.drive(inputInstructios);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(1,3)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.NORTH));
	}
	
	@Test
	public void deveSeguirCoordenadasSegundaSonda(){
				
		List<Instruction> inputInstructios = 
				Arrays.asList(
						Instruction.MOVE, 
						Instruction.MOVE, 
						
						Instruction.RIGHT,
						Instruction.MOVE,						
						
						Instruction.MOVE,
						Instruction.RIGHT,						
						
						Instruction.MOVE,
						Instruction.RIGHT,						
						
						Instruction.RIGHT,
						Instruction.MOVE);
								
		Sonda sonda = new Sonda(new Position(3, 3, Direction.EAST));
		sonda.drive(inputInstructios);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(5,1)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.EAST));
	}
	
	@Test
	public void deveSeguirCoordenadasComDirecaoDiferante(){
		
		List<Instruction> inputInstructios = 
				Arrays.asList(
						Instruction.RIGHT, 
						Instruction.MOVE, 						
						Instruction.RIGHT,
						Instruction.MOVE,												
						Instruction.LEFT,
						Instruction.MOVE);
		
		Sonda sonda = new Sonda(new Position(2, 2, Direction.NORTH));
		
		sonda.drive(inputInstructios);
	
		assertThat(sonda.getCurrentPosition().getCoordinate(), equalTo(new Vector(4,1)));
		assertThat(sonda.getCurrentPosition().getDirection(), equalTo(Direction.EAST));
	}
		
}