package org.devMarcos.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.devMarcos.excecao.ExplosaoExcepction;
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

	@Test
	void testAlternarMarcacaoDuasChamadas () {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testAbrirNaoMinadoNaomarcado () {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testAbrirNaoMinadoMarcado () {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testAbrirMinadoMarcado () {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testAbrirMinadoNaoMarcado () {
		campo.minar();
		assertThrows(ExplosaoExcepction.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testAbrirComVizinhos1 () {
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		
		campo22.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testAbrirComVizinhos2 () {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
}
