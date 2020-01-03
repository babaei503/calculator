package ir.saeidbabaei.springboot.calculator.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

}