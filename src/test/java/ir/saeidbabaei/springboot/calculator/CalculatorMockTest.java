package ir.saeidbabaei.springboot.calculator;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import ir.saeidbabaei.springboot.calculator.model.CalculationResult;
import ir.saeidbabaei.springboot.calculator.model.ValuesDtO;
import ir.saeidbabaei.springboot.calculator.service.CalculatorServiceImpl;
import ir.saeidbabaei.springboot.calculator.service.CalculatorServiceIntf;


@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockTest {

	@InjectMocks
	@Spy
	CalculatorServiceIntf calculatorServiceIntf = new CalculatorServiceImpl();

	Optional<ValuesDtO> values = Optional.of(new ValuesDtO(Optional.of("15"), Optional.of("3")));
	
	String value = "{\"value\":\"5\"}";

	@Before
	public void setUp() {

		when(this.calculatorServiceIntf.add(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(18)));
		
		when(this.calculatorServiceIntf.divide(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(5)));
		
		when(this.calculatorServiceIntf.multiply(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(45)));
		
		when(this.calculatorServiceIntf.subtract(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(12)));
		
		when(this.calculatorServiceIntf.square(this.value)).thenReturn(new CalculationResult(BigDecimal.valueOf(25)));
		
		when(this.calculatorServiceIntf.factorial(this.value)).thenReturn(new CalculationResult(BigDecimal.valueOf(120)));
		
		when(this.calculatorServiceIntf.prime(this.value)).thenReturn("{\r\n\"result\":\"true\"\r\n}");

	}

	@Test
	public void testAdd() {
		assertEquals(BigDecimal.valueOf(18), this.calculatorServiceIntf.add(this.values).getResult());
	}

	@Test
	public void testDivide() {
		assertEquals(BigDecimal.valueOf(5), this.calculatorServiceIntf.divide(this.values).getResult());
	}

	@Test
	public void testMultiply() {
		assertEquals(BigDecimal.valueOf(45), this.calculatorServiceIntf.multiply(this.values).getResult());
	}

	@Test
	public void testSubtract() {
		assertEquals(BigDecimal.valueOf(12), this.calculatorServiceIntf.subtract(this.values).getResult());
	}
	
	@Test
	public void testSquare() {
		assertEquals(BigDecimal.valueOf(25), this.calculatorServiceIntf.square(this.value).getResult());
	}
	
	@Test
	public void testFactorial() {
		assertEquals(BigDecimal.valueOf(120), this.calculatorServiceIntf.factorial(this.value).getResult());
	}
	
	@Test
	public void testPrime() {
		assertEquals("{\r\n\"result\":\"true\"\r\n}", this.calculatorServiceIntf.prime(this.value));
	}
}