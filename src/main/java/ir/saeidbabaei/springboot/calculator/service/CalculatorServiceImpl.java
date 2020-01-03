package ir.saeidbabaei.springboot.calculator.service;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ir.saeidbabaei.springboot.calculator.exception.BadRequestException;
import ir.saeidbabaei.springboot.calculator.model.CalculationResult;
import ir.saeidbabaei.springboot.calculator.model.ValuesDtO;

@Service
public class CalculatorServiceImpl implements CalculatorServiceIntf {

	@Override
	public CalculationResult add(Optional<ValuesDtO> values) {

		ValuesDtO initValues = new ValuesDtO(values.get().getFirstValue(), values.get().getSecondValue());

		float firstValue = initValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());
		
		float secondValue = initValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());

		return new CalculationResult(BigDecimal.valueOf(firstValue).add(BigDecimal.valueOf(secondValue)));
	}

	@Override
	public CalculationResult divide(Optional<ValuesDtO> values) {

		ValuesDtO initValues = new ValuesDtO(values.get().getFirstValue(), values.get().getSecondValue());

		float firstValue = initValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());
		
		float secondValue = initValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());

		if (secondValue==0)
			throw new BadRequestException();
		
		return new CalculationResult(BigDecimal.valueOf(firstValue).divide(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));

	}

	@Override
	public CalculationResult multiply(Optional<ValuesDtO> values) {

		ValuesDtO initValues = new ValuesDtO(values.get().getFirstValue(), values.get().getSecondValue());

		float firstValue = initValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());
		
		float secondValue = initValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());

		return new CalculationResult(BigDecimal.valueOf(firstValue).multiply(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));
	}

	@Override
	public CalculationResult subtract(Optional<ValuesDtO> values) {

		ValuesDtO initValues = new ValuesDtO(values.get().getFirstValue(), values.get().getSecondValue());

		float firstValue = initValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());
		
		float secondValue = initValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(() -> new BadRequestException());
		
		return new CalculationResult(BigDecimal.valueOf(firstValue).subtract(BigDecimal.valueOf(secondValue)));
	}
	
	@Override
	public CalculationResult square(String value) {

		try
		{
		    JsonNode rootNode = new ObjectMapper().readTree(new StringReader(value));
			
			JsonNode aValue = rootNode.get("value");
			
			Optional<String> initValue = Optional.ofNullable(aValue.asText()).filter(s -> !s.isEmpty()) ;
	
			float number = initValue.filter(str -> str.matches("^(\\+|-)?(\\d*\\.)?\\d+$"))
					.map(Float::parseFloat).orElseThrow(() -> new BadRequestException());
			
			return new CalculationResult(BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number), MathContext.DECIMAL32));
		}
		catch (IOException e) {
			throw new BadRequestException();
		}
	}	

	private long getFactorial(int n){    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * getFactorial(n-1));    
	} 
	 
	@Override
	public CalculationResult factorial(String value) {

		try
		{
		    JsonNode rootNode = new ObjectMapper().readTree(new StringReader(value));
			
			JsonNode aValue = rootNode.get("value");
			
			Optional<String> initValue = Optional.ofNullable(aValue.asText()).filter(s -> !s.isEmpty()) ;
		
			int number = initValue.filter(str -> str.matches("^[+]?\\d+$"))
					.map(Integer::parseInt).orElseThrow(() -> new BadRequestException());
			
			return new CalculationResult(new BigDecimal(getFactorial(number), MathContext.DECIMAL64));
		}
		catch (IOException e) {
			throw new BadRequestException();
		}
	}


	private boolean isPrime(int n) {

	    if (n%2==0) return false;

	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
    
	@Override
	public String prime(String value) {

		try
		{
		    JsonNode rootNode = new ObjectMapper().readTree(new StringReader(value));
			
			JsonNode aValue = rootNode.get("value");
			
			Optional<String> initValue = Optional.ofNullable(aValue.asText()).filter(s -> !s.isEmpty()) ;
		
			int number = initValue.filter(str -> str.matches("^[+]?\\d+$"))
					.map(Integer::parseInt).orElseThrow(() -> new BadRequestException());
			
			String jsonResult = "{\r\n\"result\":\"" + isPrime(number) + "\"\r\n}";
			
			return jsonResult;
		}
		catch (IOException e) {
			throw new BadRequestException();
		}
	}	

}