package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aplicacion.GestionCentrales;

class TestCentrales {

	GestionCentrales centrales = new GestionCentrales();
	
	@Test
	void test1() throws Exception {
		centrales.addCentral("Garoña", 0);
		centrales.addCentral("Trillo", 1066.0);
		centrales.addCentral("AscóI", 1027.21);
		assertEquals(1066.0, centrales.getMaximoProduccion());
		
	}
	
	@Test
	void test2() throws Exception {
		centrales.addCentral("Garoña", 0);
		assertThrows(Exception.class, () -> centrales.addCentral("Garoña", 1066.0));

	}
	
	@Test
	void test3() {
		assertThrows(Exception.class, () -> centrales.getMaximoProduccion());
		
	}

}
