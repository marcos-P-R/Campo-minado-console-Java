package org.devMarcos.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.devMarcos.modelo.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTest {

	private Campo campo;
	@BeforeEach
	void iniciarCampo () {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testVizinhoRealEsquerdo () {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testVizinhoRealDireito () {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testVizinhoRealCima () {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testVizinhoRealBaixo () {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testVizinhoRealDiagonal () {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testNaoVizinho () {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testValorPadraoMarcado () {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testAlternarMarcacao () {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

}
