package ir.saeidbabaei.springboot.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import ir.saeidbabaei.springboot.calculator.model.ValuesDtO;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculatorControllerTest {
	
  @LocalServerPort
  private int port;

  private String baseUrl = "";
  
  @Autowired
  private MockMvc mvc;
	
  @Before
  public void setup() throws Exception {
	  
	  this.baseUrl = "http://localhost:" + this.port + "/api/calculator/";
  
  }

  @Test
  public void shouldAddTwoNumber() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "add")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(18.0));

  }
  
  @Test
  public void shouldAddTwoNumberWithNegative() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("-3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "add")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(12.0));

  }  
  
  @Test
  public void validateAddStatusCodeWithString() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ "a"
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "add")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }
  
  @Test
  public void validateAddStatusCodeWithEmpty() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ ""
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "add")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }    
  
  @Test
  public void shouldDivideTwoNumber() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "divide")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(5.0));

  }
  
  @Test
  public void shouldDivideTwoNumberWithNegative() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("-3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "divide")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(-5.0));

  }  
  
  @Test
  public void validateDivideStatusCodeWithString() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ "a"
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "divide")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }
  
  @Test
  public void validateDivideStatusCodeWithEmpty() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ ""
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "divide")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }   
  
  @Test
  public void validateDivideStatusCodeWithZero() throws Exception{
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("0");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "divide")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }   
  
  @Test
  public void shouldMultiplyTwoNumber() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "multiply")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(45.0));

  }
  
  @Test
  public void shouldMultiplyTwoNumberWithNegative() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("-3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "multiply")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(-45.0));

  }  
  
  @Test
  public void validateMultiplyStatusCodeWithString() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ "a"
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "multiply")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }
  
  @Test
  public void validateMultiplyStatusCodeWithEmpty() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ ""
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "multiply")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }   
  
  @Test
  public void shouldSubtractTwoNumber() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "subtract")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(12.0));

  }
  
  @Test
  public void shouldSubtractTwoNumberWithNegative() throws Exception {
	  
	  Optional<String> firstValue = Optional.of("15");
	  Optional<String> secondValue = Optional.of("-3");
	  
	  ValuesDtO values = new ValuesDtO(firstValue,secondValue);
	  
	  String valuesJsonStr = values.toJsonString();
	  	  
	  mvc.perform(MockMvcRequestBuilders
	    	      .get(this.baseUrl + "subtract")
				  .content(valuesJsonStr)
				  .contentType(MediaType.APPLICATION_JSON_UTF8)
				  .accept(MediaType.APPLICATION_JSON_UTF8))
				  .andExpect(status().isOk())
				  .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(18.0));

  }  
  
  @Test
  public void validateSubtractStatusCodeWithString() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ "a"
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "multiply")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  }
  
  @Test
  public void validateSubtractStatusCodeWithEmpty() throws Exception{
	  
	  String valuesJsonStr = "{\r\n \"firstValue\": \"" 
			  	+ "15" 
			  	+ "\",\r\n \"secondValue\": \"" 
			  	+ ""
			  	+ "\" \r\n}";
	  	  
	  mvc.perform(MockMvcRequestBuilders
    	      .get(this.baseUrl + "subtract")
			  .content(valuesJsonStr)
			  .contentType(MediaType.APPLICATION_JSON_UTF8)
			  .accept(MediaType.APPLICATION_JSON_UTF8))
			  .andDo(print())
		      .andExpect(status().isBadRequest());
	  
  } 
  
  


}