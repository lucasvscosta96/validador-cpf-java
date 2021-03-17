package com.validador.Validador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorApplicationTests {

	@Test
	@DisplayName("Quando um CPF válido é passado, o valor precisa ser verdadeiro")
	void paraValidarCpf() {
		assertEquals(validarCpf("84094952012"), true);
	}

	@Test
	@DisplayName("Quando um CPF inválido é passado, o valor precisa ser falso")
	void paraValidarCpfInvalido() {
		assertEquals(validarCpf("11111111111"), false);
	}

	@Test
	@DisplayName("Quando um CPF válido formatado é passado, o valor precisa ser true")
	void paraValidarCpfValidoFormatado() {
		assertEquals(validarCpf("840.949.520-12"), true);
	}
	
	@Test
	@DisplayName("Quando um CPF iválido formatado é passado, o valor precisa ser falso")
	void paraValidarCpfInvalidoFormatado() {
		assertEquals(validarCpf("840.949.520-19"), false);
	}

	public boolean isCPF(String CPF) {
		CPF = CPF.replace("-", "").replace(".", "");

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}

	private boolean validarCpf(String cpf) {
		return true;
	}

}