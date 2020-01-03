package ir.saeidbabaei.springboot.calculator.model;

import java.util.Optional;


/**
 * A class for get two integer or decimal number.
 * firstValue and secondValue.
 * 
 * @author Saeid Babaei
 * @version 1.0
 * @since 1.0
 */
public class ValuesDtO {

	private Optional<String> firstValue;
	private Optional<String> secondValue;
	
	/** Creates an ValuesDtO with the specified firstValue and secondValue.
	 * 
	 * @param firstValue	The first number.
	 * @param secondValue	The second number.
	*/
	public ValuesDtO(Optional<String> firstValue, Optional<String> secondValue) {
		this.firstValue = firstValue.filter(str -> str.matches("^(\\+|-)?(\\d*\\.)?\\d+$"));
		this.secondValue = secondValue.filter(str -> str.matches("^(\\+|-)?(\\d*\\.)?\\d+$"));
	}

	public Optional<String> getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Optional<String> firstValue) {
		this.firstValue = firstValue;
	}

	public Optional<String> getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Optional<String> secondValue) {
		this.secondValue = secondValue;
	}

	public String toJsonString() {
		
		  String jsonStr = "{\r\n \"firstValue\": \"" 
				  	+ this.firstValue.get() 
				  	+ "\",\r\n \"secondValue\": \"" 
				  	+ this.secondValue.get() 
				  	+ "\" \r\n}";
		  
		  return jsonStr;
		  
	}
}