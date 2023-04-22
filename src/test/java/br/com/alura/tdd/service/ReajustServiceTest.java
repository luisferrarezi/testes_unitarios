package br.com.alura.tdd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;

public class ReajustServiceTest {
	private ReajusteService reajusteService;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		this.funcionario = new Funcionario("Luis", LocalDate.now(), new BigDecimal("1000"));		
		this.reajusteService = new ReajusteService();
	}
	
	@Test
	public void reajuste3Porcento() {		
		reajusteService.calcularReajuste(funcionario, Desempenho.A_DESEJAR);
		Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	} 
	
	@Test
	public void reajuste15Porcento() {
		reajusteService.calcularReajuste(funcionario, Desempenho.BOM);
		Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	} 
	
	@Test
	public void reajuste30Porcento() {		
		reajusteService.calcularReajuste(funcionario, Desempenho.OTIMO);
		Assert.assertEquals(new BigDecimal("1300.00"), funcionario.getSalario());
	} 	
}
