package ir.saeidbabaei.springboot.calculator.service;

import java.util.Optional;

import ir.saeidbabaei.springboot.calculator.model.CalculationResult;
import ir.saeidbabaei.springboot.calculator.model.ValuesDtO;

/**
 * Calculator class that offers simple operations on numbers.
 * Operations(Add, Divide, Multiply, Subtract) and
 * Operations(Square, Factorial, Prime).
 * 
 * @author Saeid Babaei
 * @version 1.0
 * @since 1.0
 */
public interface CalculatorServiceIntf {

	/**Get two numbers in ValuesDtO format
	 * add the numbers and return result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.ValuesDtO}
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		values	Two numbers in ValuesDtO format.
     * @return   			The result of adding two numbers in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult add(Optional<ValuesDtO> values);

	/**Get two numbers in ValuesDtO format
	 * divide the numbers and return result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.ValuesDtO}
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		values	Two numbers in ValuesDtO format.
     * @return   			The result of dividing two numbers in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult divide(Optional<ValuesDtO> values);

	/**Get two numbers in ValuesDtO format
	 * multiply the numbers and return result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.ValuesDtO}
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		values	Two numbers in ValuesDtO format.
     * @return   			The result of multiplying two numbers in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult multiply(Optional<ValuesDtO> values);

	/**Get two numbers in ValuesDtO format
	 * subtract the numbers and return result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.ValuesDtO}
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		values	Two numbers in ValuesDtO format.
     * @return   			The result of subtracting two numbers in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult subtract(Optional<ValuesDtO> values);
	
	/**Get a number in String format return square as result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		value	A number in String format.
     * @return   			The square as result in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult square(String value);	
	
	/**Get a number in String format return factorial as result in
	 * CalculationResult format.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.model.CalculationResult}
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		value	A number in String format.
     * @return   			The factorial as result in CalculationResult format.
     * @exception 			BadRequestException if input is not valid.
	 */
	CalculationResult factorial(String value);
	
	/**Get a number in String format and calculate that 
	 * it is prime or not.
	 * See also 
	 * {@link ir.saeidbabaei.springboot.calculator.exception.BadRequestException}
	 * 
	 * @param 		value	A number in String format.
     * @return   			The number is prime or not(true or false).
     * @exception 			BadRequestException if input is not valid.
	 */
	String prime(String value);

}