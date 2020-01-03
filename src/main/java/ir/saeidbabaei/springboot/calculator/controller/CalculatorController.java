package ir.saeidbabaei.springboot.calculator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.saeidbabaei.springboot.calculator.model.CalculationResult;
import ir.saeidbabaei.springboot.calculator.model.ValuesDtO;
import ir.saeidbabaei.springboot.calculator.service.CalculatorServiceIntf;

/**
 * Calculator controller that offers a REST API for simple operations on numbers.
 * Operations(Add, Divide, Multiply, Subtract).
 * 
 * @author Saeid Babaei
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	private CalculatorServiceIntf calculatorServiceIntf;

	@Autowired
	public CalculatorController(CalculatorServiceIntf calculatorServiceIntf) {

		this.calculatorServiceIntf = calculatorServiceIntf;

	}


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<CalculationResult> add(@RequestBody Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorServiceIntf.add(values));
	}


	@RequestMapping(value = "/divide", method = RequestMethod.GET)
	public ResponseEntity<CalculationResult> divide(@RequestBody Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorServiceIntf.divide(values));

	}


	@RequestMapping(value = "/multiply", method = RequestMethod.GET)
	public ResponseEntity<CalculationResult> multiply(@RequestBody Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorServiceIntf.multiply(values));

	}


	@RequestMapping(value = "/subtract", method = RequestMethod.GET)
	public ResponseEntity<CalculationResult> subtract(@RequestBody Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorServiceIntf.subtract(values));
	}

}