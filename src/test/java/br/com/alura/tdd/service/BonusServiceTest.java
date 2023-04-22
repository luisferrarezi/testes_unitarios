package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;

class BonusServiceTest {

	@Test
	void calcularBonusRetornoZerotest() {
		BonusService bonusService = new BonusService();				
		Assert.assertThrows(IllegalArgumentException.class ,() ->bonusService.calcularBonus(new Funcionario("Luis", LocalDate.now(), new BigDecimal("50000"))));
	}

	
	@Test
	void calcularBonusRetorno10Porcentotest() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Luis", LocalDate.now(), new BigDecimal("1600")));
		
		Assert.assertEquals(new BigDecimal("160.00"), bonus);
	}	
	
	@Test
	void calcularBonusRetorno1000test() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Luis", LocalDate.now(), new BigDecimal("10000")));
		
		Assert.assertEquals(new BigDecimal("1000.00"), bonus);
	}		
}
