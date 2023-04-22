package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	final String FUNCIONARIO_INELEGIVEL = "Funcionario inelegivel Bonus";
	
	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException(FUNCIONARIO_INELEGIVEL);
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
