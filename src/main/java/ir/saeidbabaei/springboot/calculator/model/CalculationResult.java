package ir.saeidbabaei.springboot.calculator.model;

import java.math.BigDecimal;

/**
 * A class for return the result of an operation.
 * 
 * @author Saeid Babaei
 * @version 1.0
 * @since 1.0
 */
public class CalculationResult {

	private BigDecimal result;	

	/** Creates an CalculationResult with the specified result.
	 * 
	 * @param result	The result that should be return.
	*/
	public CalculationResult(BigDecimal result) {
		super();
		this.result = result;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

}