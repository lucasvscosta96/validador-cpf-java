package com.validador.Validador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.validador.Validador.Models.Cliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorApplicationTests {

	@Test
	@DisplayName("Quando um CPF válido é passado, o valor precisa ser verdadeiro")
	void paraValidarCpf() {
		Cliente cliente = new Cliente("Lucas","84094952012");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	@DisplayName("Quando um CPF inválido é passado, o valor precisa ser falso")
	void paraValidarCpfInvalido() {
		Cliente cliente = new Cliente("Lucas","84094952976");
		assertEquals(cliente.validarCpf(), false);
	}

	@Test
	@DisplayName("Quando um CPF válido formatado é passado, o valor precisa ser true")
	void paraValidarCpfValidoFormatado() {
		Cliente cliente = new Cliente("Lucas","840.949.520-12");
		assertEquals(cliente.validarCpf(), true);
	}
	
	@Test
	@DisplayName("Quando um CPF iválido formatado é passado, o valor precisa ser falso")
	void paraValidarCpfInvalidoFormatado() {
		Cliente cliente = new Cliente("Lucas","840.949.520-19");
		assertEquals(cliente.validarCpf(), false);
	}
	// private boolean validarCpf(String cpf) {
	// 	return true;
	// }

}