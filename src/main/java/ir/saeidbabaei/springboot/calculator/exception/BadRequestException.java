package ir.saeidbabaei.springboot.calculator.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * A class for return BadRequestException in case of number format exception.
 * 
 * @author Saeid Babaei
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please enter a valid input")
public class BadRequestException extends NumberFormatException {

	private static final long serialVersionUID = 1L;

}