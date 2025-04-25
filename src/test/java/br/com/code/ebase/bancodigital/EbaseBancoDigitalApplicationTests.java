package br.com.code.ebase.bancodigital;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EbaseBancoDigitalApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(1 == 1, "Esse teste sempre passa, pois 1 é igual a 1.");
	}

}
